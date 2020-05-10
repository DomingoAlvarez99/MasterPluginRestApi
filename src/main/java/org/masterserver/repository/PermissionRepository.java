package org.masterserver.repository;

import java.util.Optional;

import org.masterserver.model.PermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel, Long> {
	
	Optional<PermissionModel> findByName(String name);

}