package com.dbsl.proposalgenerator.beans;

// Generated Oct 4, 2015 12:08:23 PM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "model", catalog = "dbsl_proposal_generator")
public class Model implements java.io.Serializable {

	private Integer id;
	private Hardware hardware;
	private StaticText staticText;
	private String name;
	private String logoPath;
	private Float unitPrice;
	private Boolean isActive;
	private Set<Specification> specifications = new HashSet<Specification>(0);

	public Model() {
	}

	public Model(Hardware hardware, StaticText staticText) {
		this.hardware = hardware;
		this.staticText = staticText;
	}

	public Model(Hardware hardware, StaticText staticText, String name,
			String logoPath, Float unitPrice, Boolean isActive,
			Set<Specification> specifications) {
		this.hardware = hardware;
		this.staticText = staticText;
		this.name = name;
		this.logoPath = logoPath;
		this.unitPrice = unitPrice;
		this.isActive = isActive;
		this.specifications = specifications;
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
	@JoinColumn(name = "HARDWARE_id", nullable = false)
	public Hardware getHardware() {
		return this.hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATIC_TEXT_id", nullable = false)
	public StaticText getStaticText() {
		return this.staticText;
	}

	public void setStaticText(StaticText staticText) {
		this.staticText = staticText;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "logoPath")
	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@Column(name = "unitPrice", precision = 12, scale = 0)
	public Float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "details_has_specification", catalog = "dbsl_proposal_generator", joinColumns = { @JoinColumn(name = "DETAILS_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SPECIFICATION_id", nullable = false, updatable = false) })
	public Set<Specification> getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(Set<Specification> specifications) {
		this.specifications = specifications;
	}

}
