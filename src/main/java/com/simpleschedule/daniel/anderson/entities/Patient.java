package com.simpleschedule.daniel.anderson.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", nullable=false, length=4)
	private Integer pId;
	
	@Column(name="namef", nullable=false)
	private String pFirstName;
	
	@Column(name="namel", nullable=false)
	private String pLastName;
	
	@Column(name="dob", nullable=false)
	private Date pDob;
	
	@Column(name="primaryid", nullable=true)
	private Integer pPrimary;
	
	public Patient() {
		super();
	}
	
	public Patient(int pId, String pFirstname, String pLastname, Date pDob, int pPrimary) {
		super();
		this.pId = pId;
		this.pFirstName = pFirstname;
		this.pLastName = pLastname;
		this.pDob = pDob;
		this.pPrimary = pPrimary;
	}
	
	@Override
	public String toString() {
		return String.format("Patient ID %d: %s %s, DOB: %s ", 
				this.pId, this.pFirstName, this.pLastName, this.pDob);
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (pDob == null) {
			if (other.pDob != null)
				return false;
		} else if (!pDob.equals(other.pDob))
			return false;
		if (pFirstName == null) {
			if (other.pFirstName != null)
				return false;
		} else if (!pFirstName.equals(other.pFirstName))
			return false;
		if (pId != other.pId)
			return false;
		if (pLastName == null) {
			if (other.pLastName != null)
				return false;
		} else if (!pLastName.equals(other.pLastName))
			return false;
		if (pPrimary != other.pPrimary)
			return false;
		return true;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpFirstname() {
		return pFirstName;
	}

	public void setpFirstname(String pFirstname) {
		this.pFirstName = pFirstname;
	}

	public String getpLastname() {
		return pLastName;
	}

	public void setpLastname(String pLastname) {
		this.pLastName = pLastname;
	}

	public Date getpDob() {
		return pDob;
	}

	public void setpDob(Date pDob) {
		this.pDob = pDob;
	}

	public int getpPrimary() {
		return pPrimary;
	}

	public void setpPrimary(int pPrimary) {
		this.pPrimary = pPrimary;
	}
}