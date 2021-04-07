package com.simpleschedule.daniel.anderson.entities;

import java.util.Date;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aId;

	@Column(name = "date")
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE, pattern="yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date aDate;
	
	@Column(name = "locationId")
	private Integer aLocationId;

	@Column(name = "patientId")
	private Integer aPatientId;

	@Column(name = "primaryId")
	private Integer aPrimaryId;

	@Column(name = "timeStart")
	@DateTimeFormat(pattern="HH:mm")
	@Temporal(value = TemporalType.TIME)
	private Date aTimeStart;

	@Column(name = "timeEnd")
	@DateTimeFormat(pattern="HH:mm")
	@Temporal(value = TemporalType.TIME)
	private Date aTimeEnd;

	public Appointment() {
		super();
	}

	public Appointment(Date aDate, Integer aLocationId, Integer aPatientId, Integer aPrimaryId, Date aTimeStart,
			Date aTimeEnd) {
		super();
		this.aDate = aDate;
		this.aLocationId = aLocationId;
		this.aPatientId = aPatientId;
		this.aPrimaryId = aPrimaryId;
		this.aTimeStart = aTimeStart;
		this.aTimeEnd = aTimeEnd;
	}
	
	public Appointment(Integer aId, Date aDate, Integer aLocationId, Integer aPatientId, Integer aPrimaryId, Date aTimeStart,
			Date aTimeEnd) {
		super();
		this.aId = aId;
		this.aDate = aDate;
		this.aLocationId = aLocationId;
		this.aPatientId = aPatientId;
		this.aPrimaryId = aPrimaryId;
		this.aTimeStart = aTimeStart;
		this.aTimeEnd = aTimeEnd;
	}
	
	@Override
	public String toString() {
		return "Appointment [aId=" + aId + ", aDate=" + aDate + ", aLocationId=" + aLocationId + ", aPatientId="
				+ aPatientId + ", aPrimaryId=" + aPrimaryId + ", aTimeStart=" + aTimeStart + ", aTimeEnd=" + aTimeEnd
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (aDate == null) {
			if (other.aDate != null)
				return false;
		} else if (!aDate.equals(other.aDate))
			return false;
		if (aId == null) {
			if (other.aId != null)
				return false;
		} else if (!aId.equals(other.aId))
			return false;
		if (aLocationId == null) {
			if (other.aLocationId != null)
				return false;
		} else if (!aLocationId.equals(other.aLocationId))
			return false;
		if (aPatientId == null) {
			if (other.aPatientId != null)
				return false;
		} else if (!aPatientId.equals(other.aPatientId))
			return false;
		if (aPrimaryId == null) {
			if (other.aPrimaryId != null)
				return false;
		} else if (!aPrimaryId.equals(other.aPrimaryId))
			return false;
		if (aTimeEnd == null) {
			if (other.aTimeEnd != null)
				return false;
		} else if (!aTimeEnd.equals(other.aTimeEnd))
			return false;
		if (aTimeStart == null) {
			if (other.aTimeStart != null)
				return false;
		} else if (!aTimeStart.equals(other.aTimeStart))
			return false;
		return true;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	
	public Integer getaLocationId() {
		return aLocationId;
	}
	
	public void setaLocationId(Integer aLocationId) {
		this.aLocationId = aLocationId;
	}

	public Integer getaPatientId() {
		return aPatientId;
	}

	public void setaPatientId(Integer aPatientId) {
		this.aPatientId = aPatientId;
	}

	public Integer getaPrimaryId() {
		return aPrimaryId;
	}

	public void setaPrimaryId(Integer aPrimaryId) {
		this.aPrimaryId = aPrimaryId;
	}

	public Date getaTimeStart() {
		return aTimeStart;
	}

	public void setaTimeStart(Date aTimeStart) {
		this.aTimeStart = aTimeStart;
	}

	public Date getaTimeEnd() {
		return aTimeEnd;
	}

	public void setaTimeEnd(Date aTimeEnd) {
		this.aTimeEnd = aTimeEnd;
	}
}
