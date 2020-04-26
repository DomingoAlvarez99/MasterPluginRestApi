package org.masterserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"item\"")
public class ItemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "uuid")
	private long uuid;
	
	@Column(name = "durability")
	private long durability;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "type", length = 50)
	private String type;

	public ItemModel(long id, long uuid, long durability, String name, String type) {
		this.id = id;
		this.uuid = uuid;
		this.durability = durability;
		this.name = name;
		this.type = type;
	}

	public ItemModel(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public long getDurability() {
		return durability;
	}

	public void setDurability(long durability) {
		this.durability = durability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}