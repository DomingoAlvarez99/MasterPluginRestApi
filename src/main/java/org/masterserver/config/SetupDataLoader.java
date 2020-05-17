package org.masterserver.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.masterserver.model.PermissionModel;
import org.masterserver.model.RankModel;
import org.masterserver.repository.PermissionRepository;
import org.masterserver.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup;

	@Autowired
	private RankRepository rankRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}
		createRankWithPermissions("member",
				Arrays.asList("change.single_color.self", "seen.self", "ping.self", "stats.self"));
		createRankWithPermissions("owner",
				Arrays.asList("change.all_color","chunksLoaded","tpRandom.self", "tpRandom.everyone", "list.colors", "seen.self",
						"seen.everyone", "ping.self", "ping.everyone", "stats.self", "stats.everyone"));
	}

	@Transactional
	public void createRankIfNoExists(String name) {
		Optional<RankModel> rank = rankRepository.findByName(name);
		if (!rank.isPresent()) {
			rankRepository.save(new RankModel(name));
		}
	}

	@Transactional
	public void createRankWithPermissions(String rankName, List<String> privileges) {
		Set<PermissionModel> permissions = new HashSet<>();
		if (privileges != null) {
			for (String permissionName : privileges) {
				if (!permissionRepository.findByName(permissionName).isPresent()) {
					PermissionModel permission = permissionRepository.save(new PermissionModel(permissionName));
					permissions.add(permission);
				} else {
					PermissionModel permission = permissionRepository.findByName(permissionName).get();
					permissions.add(permission);
				}
			}
		}
		RankModel rank = new RankModel();
		rank.setName(rankName);
		rank.setPermissions(permissions);
		if (!rankRepository.findByName(rankName).isPresent()) {
			rankRepository.save(rank);
		}
	}

}