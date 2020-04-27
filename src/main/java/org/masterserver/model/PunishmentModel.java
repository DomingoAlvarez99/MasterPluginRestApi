package org.masterserver.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="\"punishment\"")
public class PunishmentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "description" ,length = 500)
	private String description;
	
	@Column(name = "type", length = 50)
	private String type;
	
	@Column(name = "date")
	private Calendar date;
	
	@Column(name = "player_id")
	private long playerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false)
	@JsonBackReference
	private PlayerModel player;

	public PunishmentModel(long id, String description, String type, Calendar date, long playerId, PlayerModel player) {
		this.id = id;
		this.description = description;
		this.type = type;
		this.date = date;
		this.playerId = playerId;
		this.player = player;
	}
	
	public PunishmentModel(long id, String description, String type, Calendar date, long playerId) {
		this.id = id;
		this.description = description;
		this.type = type;
		this.date = date;
		this.playerId = playerId;
	}

	public PunishmentModel(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}
	
}

