package org.masterserver.repository;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.DeathModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathRepository extends JpaRepository<DeathModel, Long> {
	
	List<DeathModel> findByDate(Calendar date);
	List<DeathModel> findByCause(String cause);
	List<DeathModel> findByMobId(long mobId);
	List<DeathModel> findByAssasinId(long assasinId);
	List<DeathModel> findByMurderedId(long murderedId);
	
}
