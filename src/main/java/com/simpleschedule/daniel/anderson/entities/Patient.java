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
	private String pFirstname;
	
	@Column(name="namel", nullable=false)
	private String pLastname;
	
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
		this.pFirstname = pFirstname;
		this.pLastname = pLastname;
		this.pDob = pDob;
		this.pPrimary = pPrimary;
	}
	
	@Override
	public String toString() {
		return String.format("Patient ID %d: %s %s, DOB: %s ", 
				this.pId, this.pFirstname, this.pLastname, this.pDob);
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
		if (pFirstname == null) {
			if (other.pFirstname != null)
				return false;
		} else if (!pFirstname.equals(other.pFirstname))
			return false;
		if (pId != other.pId)
			return false;
		if (pLastname == null) {
			if (other.pLastname != null)
				return false;
		} else if (!pLastname.equals(other.pLastname))
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
		return pFirstname;
	}

	public void setpFirstname(String pFirstname) {
		this.pFirstname = pFirstname;
	}

	public String getpLastname() {
		return pLastname;
	}

	public void setpLastname(String pLastname) {
		this.pLastname = pLastname;
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