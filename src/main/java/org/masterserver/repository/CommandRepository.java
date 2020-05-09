package org.masterserver.repository;

import java.util.List;

import org.masterserver.model.CommandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<CommandModel, Long> {
	
	List<CommandModel> findByCommand(String command);
	
}
