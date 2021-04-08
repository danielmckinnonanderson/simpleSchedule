package com.simpleschedule.daniel.anderson.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, length = 3)
	private Integer pId;

	@Column(name = "namef", nullable = false)
	@NotEmpty
	private String pFirstName;

	@Column(name = "namel", nullable = false)
	@NotEmpty
	private String pLastName;

	@Column(name = "dob", nullable = false)
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date pDob;

	@Column(name = "primaryid", nullable = true, length = 3)
	private Integer pPrimary;

	public Patient() {
		super();
	}

	public Patient(String pFirstName, String pLastName, Date pDob, Integer pPrimary) {
		super();
		this.pFirstName = pFirstName;
		this.pLastName = pLastName;
		this.pDob = pDob;
		this.pPrimary = pPrimary;
	}

	public Patient(Integer pId, String pFirstName, String pLastName, Date pDob, Integer pPrimary) {
		super();
		this.pId = pId;
		this.pFirstName = pFirstName;
		this.pLastName = pLastName;
		this.pDob = pDob;
		this.pPrimary = pPrimary;
	}

	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", pFirstName=" + pFirstName + ", pLastName=" + pLastName + ", pDob=" + pDob
				+ ", pPrimary=" + pPrimary + "]";
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

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpFirstName() {
		return pFirstName;
	}

	public void setpFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}

	public String getpLastName() {
		return pLastName;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public Date getpDob() {
		return pDob;
	}

	public void setpDob(Date pDob) {
		this.pDob = pDob;
	}

	public Integer getpPrimary() {
		return pPrimary;
	}

	public void setpPrimary(Integer pPrimary) {
		this.pPrimary = pPrimary;
	}
}