package org.masterserver.repository;

import java.util.List;
import java.util.Optional;

import org.masterserver.model.PlayerModel;
import org.masterserver.model.WarpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarpRepository extends JpaRepository<WarpModel, Long> {
	
	List<WarpModel> findByName(String name);
	Optional<WarpModel> findByNameAndPlayer(String name, PlayerModel player);
	List<WarpModel> findByCoordinateX(long coordinateX);
	List<WarpModel> findByCoordinateY(long coordinateY);
	List<WarpModel> findByCoordinateZ(long coordinateZ);
	
}