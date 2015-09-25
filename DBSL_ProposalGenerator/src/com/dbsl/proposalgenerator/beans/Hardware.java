package com.dbsl.proposalgenerator.beans;

// Generated Sep 25, 2015 9:10:21 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Hardware generated by hbm2java
 */
@Entity
@Table(name = "hardware", catalog = "dbsl_proposal_generator")
public class Hardware implements java.io.Serializable {

	private Integer id;
	private Model model;
	private StaticText staticText;
	private Category category;
	private String name;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isActive;

	public Hardware() {
	}

	public Hardware(Model model, StaticText staticText, Category category) {
		this.model = model;
		this.staticText = staticText;
		this.category = category;
	}

	public Hardware(Model model, StaticText staticText, Category category,
			String name, Date createdOn, Date updatedOn, Boolean isActive) {
		this.model = model;
		this.staticText = staticText;
		this.category = category;
		this.name = name;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isActive = isActive;
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
	@JoinColumn(name = "DETAILS_id", nullable = false)
	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATIC_TEXT_id", nullable = false)
	public StaticText getStaticText() {
		return this.staticText;
	}

	public void setStaticText(StaticText staticText) {
		this.staticText = staticText;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedOn", length = 19)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
