package org.masterserver.repository;

import java.util.List;

import org.masterserver.model.DeathModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathRepository extends JpaRepository<DeathModel, Long> {
	
	List<DeathModel> findByCause(String cause);
	
}
