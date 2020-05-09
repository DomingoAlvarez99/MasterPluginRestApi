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
@Table(name="\"command\"")
public class CommandModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "command", length = 500)
	private String command;
	
	@Column(name = "date")
	private Calendar date;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
	@JsonBackReference
	private PlayerModel player;

	public CommandModel(long id, String command, Calendar date, PlayerModel player) {
		this.id = id;
		this.command = command;
		this.date = date;
		this.player = player;
	}
	
	public CommandModel(long id, String command, Calendar date) {
		this.id = id;
		this.command = command;
		this.date = date;
	}

	public CommandModel(long id) {
		this.id = id;
	}
	
	public CommandModel() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}
	
}
