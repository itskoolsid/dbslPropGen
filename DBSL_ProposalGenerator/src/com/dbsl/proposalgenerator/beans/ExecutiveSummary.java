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
 * ExecutiveSummary generated by hbm2java
 */
@Entity
@Table(name = "executive_summary", catalog = "dbsl_proposal_generator")
public class ExecutiveSummary implements java.io.Serializable {

	private Integer id;
	private StaticText staticText;
	private Date createdOn;
	private Boolean isActive;

	public ExecutiveSummary() {
	}

	public ExecutiveSummary(StaticText staticText) {
		this.staticText = staticText;
	}

	public ExecutiveSummary(StaticText staticText, Date createdOn,
			Boolean isActive) {
		this.staticText = staticText;
		this.createdOn = createdOn;
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
	@JoinColumn(name = "STATIC_TEXT_id", nullable = false)
	public StaticText getStaticText() {
		return this.staticText;
	}

	public void setStaticText(StaticText staticText) {
		this.staticText = staticText;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
