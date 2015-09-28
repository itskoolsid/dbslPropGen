package com.dbsl.proposalgenerator.beans;

// Generated Sep 25, 2015 9:10:21 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Contact generated by hbm2java
 */
@Entity
@Table(name = "contact", catalog = "dbsl_proposal_generator")
public class Contact implements java.io.Serializable {

	private Integer id;
	private String mobNo;
	private String homeNo;
	private String officeNo1;
	private String officeNo2;
	private String emailId;
	private String faxNo;
	private Set<Employee> employees = new HashSet<Employee>(0);
	private Set<Client> clients = new HashSet<Client>(0);

	public Contact() {
	}

	public Contact(String mobNo, String homeNo, String officeNo1,
			String officeNo2, String emailId, String faxNo,
			Set<Employee> employees, Set<Client> clients) {
		this.mobNo = mobNo;
		this.homeNo = homeNo;
		this.officeNo1 = officeNo1;
		this.officeNo2 = officeNo2;
		this.emailId = emailId;
		this.faxNo = faxNo;
		this.employees = employees;
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

	@Column(name = "mobNo", length = 45)
	public String getMobNo() {
		return this.mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	@Column(name = "homeNo", length = 45)
	public String getHomeNo() {
		return this.homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	@Column(name = "officeNo1", length = 45)
	public String getOfficeNo1() {
		return this.officeNo1;
	}

	public void setOfficeNo1(String officeNo1) {
		this.officeNo1 = officeNo1;
	}

	@Column(name = "officeNo2", length = 45)
	public String getOfficeNo2() {
		return this.officeNo2;
	}

	public void setOfficeNo2(String officeNo2) {
		this.officeNo2 = officeNo2;
	}

	@Column(name = "emailId", length = 45)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "faxNo", length = 45)
	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}