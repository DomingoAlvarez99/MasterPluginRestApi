package org.masterserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "\"warp\"", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "player_id" }) })
public class WarpModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "coordinate_x")
	private long coordinateX;

	@Column(name = "coordinate_y")
	private long coordinateY;

	@Column(name = "coordinate_z")
	private long coordinateZ;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player_id")
	@JsonBackReference
	private PlayerModel player;

	public WarpModel(long id, String name, long coordinateX, long coordinateY, long coordinateZ,
			PlayerModel player) {
		this.id = id;
		this.name = name;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.coordinateZ = coordinateZ;
		this.player = player;
	}

	public WarpModel(long id, String name, long coordinateX, long coordinateY, long coordinateZ) {
		this.id = id;
		this.name = name;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.coordinateZ = coordinateZ;
	}

	public WarpModel(long id) {
		this.id = id;
	}
	
	public WarpModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(long coordinateX) {
		this.coordinateX = coordinateX;
	}

	public long getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(long coordinateY) {
		this.coordinateY = coordinateY;
	}

	public long getCoordinateZ() {
		return coordinateZ;
	}

	public void setCoordinateZ(long coordinateZ) {
		this.coordinateZ = coordinateZ;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

}
