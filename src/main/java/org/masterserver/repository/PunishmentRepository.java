package org.masterserver.repository;

import java.util.Calendar;
import java.util.List;

import org.masterserver.model.PunishmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunishmentRepository extends JpaRepository<PunishmentModel, Long> {
	
	List<PunishmentModel> findByDate(Calendar date);
	List<PunishmentModel> findByType(String type);
	List<PunishmentModel> findByDescription(String type);
	
}