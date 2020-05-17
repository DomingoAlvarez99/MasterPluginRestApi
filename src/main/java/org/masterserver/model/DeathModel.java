package org.masterserver.model;

import java.time.LocalDateTime;

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
@Table(name = "\"death\"")
public class DeathModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "date")
	private LocalDateTime date;

	@Column(name = "cause", length = 100)
	private String cause;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "assasin_id")
	@JsonBackReference("assasin")
	private PlayerModel assasin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "murdered_id")
	@JsonBackReference("murdered")
	private PlayerModel murdered;

	public DeathModel(long id, LocalDateTime date, String cause, PlayerModel assasin, PlayerModel murdered) {
		this.id = id;
		this.date = date;
		this.cause = cause;
		this.assasin = assasin;
		this.murdered = murdered;
	}

	public DeathModel(long id, LocalDateTime date, String cause) {
		this.id = id;
		this.date = date;
		this.cause = cause;
	}

	public DeathModel(long id) {
		this.id = id;
	}

	public DeathModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
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
