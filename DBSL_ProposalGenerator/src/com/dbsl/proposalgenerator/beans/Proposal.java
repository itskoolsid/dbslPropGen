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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Proposal generated by hbm2java
 */
@Entity
@Table(name = "proposal", catalog = "dbsl_proposal_generator")
public class Proposal implements java.io.Serializable {

	private Integer id;
	private Date createdOn;
	private Boolean isComplete;
	private Boolean isSent;
	private Boolean isActive;
	private Set<Solution> solutions = new HashSet<Solution>(0);
	private Set<Client> clients = new HashSet<Client>(0);

	public Proposal() {
	}

	public Proposal(Date createdOn, Boolean isComplete, Boolean isSent,
			Boolean isActive, Set<Solution> solutions, Set<Client> clients) {
		this.createdOn = createdOn;
		this.isComplete = isComplete;
		this.isSent = isSent;
		this.isActive = isActive;
		this.solutions = solutions;
		this.clients = clients;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "isComplete")
	public Boolean getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Column(name = "isSent")
	public Boolean getIsSent() {
		return this.isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "proposal_has_solution", catalog = "dbsl_proposal_generator", joinColumns = { @JoinColumn(name = "PROPOSAL_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SOLUTION_id", nullable = false, updatable = false) })
	public Set<Solution> getSolutions() {
		return this.solutions;
	}

	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "proposal_has_client", catalog = "dbsl_proposal_generator", joinColumns = { @JoinColumn(name = "PROPOSAL_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Client_id", nullable = false, updatable = false) })
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
