package org.masterserver.repository;

import java.util.Optional;

import org.masterserver.model.RankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<RankModel, Long> {
	
	Optional<RankModel> findByName(String name);

}
