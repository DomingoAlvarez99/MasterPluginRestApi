package org.masterserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="\"rank\"")
public class RankModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@OneToMany(mappedBy = "rank", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<PlayerModel> players = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "\"rank_permission\"", 
	  joinColumns = @JoinColumn(name = "rank_id"), 
	  inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<RankModel> permissions = new HashSet<>();
	
	public RankModel() {

	}

	public RankModel(String name) {
		this.name = name;
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

	public Set<PlayerModel> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerModel> players) {
		this.players = players;
	}

	public Set<RankModel> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<RankModel> permissions) {
		this.permissions = permissions;
	}

}
