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
@Table(name="\"death\"")
public class DeathModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "date")
	private Calendar date;
	
	@Column(name = "cause", length = 100)
	private String cause;
	
	@Column(name = "mobId")
	private long mobId;
	
	@Column(name = "assasin_id")
	private long assasinId;
	
	@Column(name = "murdered_id")
	private long murderedId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false)
	@JsonBackReference
	private PlayerModel assasin;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id", insertable = false, updatable = false)
	@JsonBackReference
	private PlayerModel murdered;

	public DeathModel(long id, Calendar date, String cause, long mobId, long assasinId, long murderedId,
			PlayerModel assasin, PlayerModel murdered) {
		this.id = id;
		this.date = date;
		this.cause = cause;
		this.mobId = mobId;
		this.assasinId = assasinId;
		this.murderedId = murderedId;
		this.assasin = assasin;
		this.murdered = murdered;
	}
	
	public DeathModel(long id, Calendar date, String cause, long mobId, long assasinId, long murderedId) {
		this.id = id;
		this.date = date;
		this.cause = cause;
		this.mobId = mobId;
		this.assasinId = assasinId;
	}

	public DeathModel(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public long getMobId() {
		return mobId;
	}

	public void setMobId(long mobId) {
		this.mobId = mobId;
	}

	public long getAssasinId() {
		return assasinId;
	}

	public void setAssasinId(long assasinId) {
		this.assasinId = assasinId;
	}

	public long getMurderedId() {
		return murderedId;
	}

	public void setMurderedId(long murderedId) {
		this.murderedId = murderedId;
	}

	public PlayerModel getAssasin() {
		return assasin;
	}

	public void setAssasin(PlayerModel assasin) {
		this.assasin = assasin;
	}

	public PlayerModel getMurdered() {
		return murdered;
	}

	public void setMurdered(PlayerModel murdered) {
		this.murdered = murdered;
	}

}
