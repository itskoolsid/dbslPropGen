package com.dbsl.proposalgenerator.beans;

// Generated Oct 2, 2015 12:51:43 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

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

/**
 * Employee generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "employee", catalog = "dbsl_proposal_generator")
public class Employee implements java.io.Serializable {

	private Integer id;
	private Contact contact;
	private Address address;
	private String firstName;
	private String middleName;
	private String lastName;
	private String empCode;
	private String designation;
	private Boolean isActive;
	private Set<Privilege> privileges = new HashSet<Privilege>(0);

	public Employee() {
	}

	public Employee(Contact contact, Address address) {
		this.contact = contact;
		this.address = address;
	}

	public Employee(Contact contact, Address address, String firstName,
			String middleName, String lastName, String empCode,
			String designation, Boolean isActive, Set<Privilege> privileges) {
		this.contact = contact;
		this.address = address;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.empCode = empCode;
		this.designation = designation;
		this.isActive = isActive;
		this.privileges = privileges;
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
	@JoinColumn(name = "CONTACT_id", nullable = false)
	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_id", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "firstName", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middleName", length = 45)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "lastName", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "empCode", length = 45)
	public String getEmpCode() {
		return this.empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	@Column(name = "designation", length = 45)
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}
