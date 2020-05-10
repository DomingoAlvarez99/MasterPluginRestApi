package org.masterserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "\"permission\"")
public class PermissionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", length = 50)
	private String name;

	@ManyToMany(mappedBy = "permissions")
	@JsonBackReference
	private Set<RankModel> ranks = new HashSet<>();

	public PermissionModel() {

	}

	public PermissionModel(String name) {
		this.name = name;
	}

	public PermissionModel(long id) {
		this.id = id;
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

	public Set<RankModel> getRanks() {
		return ranks;
	}

	public void setRanks(Set<RankModel> ranks) {
		this.ranks = ranks;
	}

}