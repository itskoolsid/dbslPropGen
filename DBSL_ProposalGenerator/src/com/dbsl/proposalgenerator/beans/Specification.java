package com.dbsl.proposalgenerator.beans;

// Generated Sep 25, 2015 9:10:21 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Specification generated by hbm2java
 */
@Entity
@Table(name = "specification", catalog = "dbsl_proposal_generator")
public class Specification implements java.io.Serializable {

	private Integer id;
	private String key;
	private String value;
	private Boolean isActive;
	private Set<Model> models = new HashSet<Model>(0);

	public Specification() {
	}

	public Specification(String key, String value, Boolean isActive,
			Set<Model> models) {
		this.key = key;
		this.value = value;
		this.isActive = isActive;
		this.models = models;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "key")
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "value")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "details_has_specification", catalog = "dbsl_proposal_generator", joinColumns = { @JoinColumn(name = "SPECIFICATION_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "DETAILS_id", nullable = false, updatable = false) })
	public Set<Model> getModels() {
		return this.models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}

}
