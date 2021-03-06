package com.dbsl.proposalgenerator.beans;

// Generated Sep 25, 2015 9:10:21 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OtherService generated by hbm2java
 */
@Entity
@Table(name = "other_service", catalog = "dbsl_proposal_generator")
public class OtherService implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;
	private Boolean isAcitve;
	private Date createdOn;
	private Set<Details> detailses = new HashSet<Details>(0);

	public OtherService() {
	}

	public OtherService(Category category) {
		this.category = category;
	}

	public OtherService(Category category, String name, Boolean isAcitve,
			Date createdOn, Set<Details> detailses) {
		this.category = category;
		this.name = name;
		this.isAcitve = isAcitve;
		this.createdOn = createdOn;
		this.detailses = detailses;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isAcitve")
	public Boolean getIsAcitve() {
		return this.isAcitve;
	}

	public void setIsAcitve(Boolean isAcitve) {
		this.isAcitve = isAcitve;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "otherService")
	public Set<Details> getDetailses() {
		return this.detailses;
	}

	public void setDetailses(Set<Details> detailses) {
		this.detailses = detailses;
	}

}
