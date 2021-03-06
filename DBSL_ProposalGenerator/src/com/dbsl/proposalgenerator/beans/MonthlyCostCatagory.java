package com.dbsl.proposalgenerator.beans;

// Generated Sep 25, 2015 9:10:21 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MonthlyCostCatagory generated by hbm2java
 */
@Entity
@Table(name = "monthly_cost_catagory", catalog = "dbsl_proposal_generator")
public class MonthlyCostCatagory implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;
	private Float unitPrice;
	private Boolean isActive;

	public MonthlyCostCatagory() {
	}

	public MonthlyCostCatagory(Category category) {
		this.category = category;
	}

	public MonthlyCostCatagory(Category category, String name, Float unitPrice,
			Boolean isActive) {
		this.category = category;
		this.name = name;
		this.unitPrice = unitPrice;
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

}
