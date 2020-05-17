package org.masterserver.repository;

import java.util.List;

import org.masterserver.model.AchievementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<AchievementModel, Long> {
	
	List<AchievementModel> findByName(String name);
	
}