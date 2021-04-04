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

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aId;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date aDate;

	@Column(name = "patientId")
	private Integer aPatientId;

	@Column(name = "primaryId")
	private Integer aPrimaryId;

	@Column(name = "timeStart")
	private LocalTime aTimeStart;

	@Column(name = "timeEnd")
	private LocalTime aTimeEnd;

	public Appointment() {
		super();
	}

	public Appointment(Integer aId, Date aDate, Integer aPatientId, Integer aPrimaryId, LocalTime aTimeStart,
			LocalTime aTimeEnd) {
		super();
		this.aId = aId;
		this.aDate = aDate;
		this.aPatientId = aPatientId;
		this.aPrimaryId = aPrimaryId;
		this.aTimeStart = aTimeStart;
		this.aTimeEnd = aTimeEnd;
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

	public LocalTime getaTimeStart() {
		return aTimeStart;
	}

	public void setaTimeStart(LocalTime aTimeStart) {
		this.aTimeStart = aTimeStart;
	}

	public LocalTime getaTimeEnd() {
		return aTimeEnd;
	}

	public void setaTimeEnd(LocalTime aTimeEnd) {
		this.aTimeEnd = aTimeEnd;
	}
}
