package com.simpleschedule.daniel.anderson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
public class Location {
	@Id
	@Column(name="id")
	private Integer lId;
	
	@Column(name="city", nullable=false)
	private String lCity;
	
	@Column(name="state", length=2, nullable=false)
	private String lState;
	
	public Location() {
		super();
	}

	public Location(int lId, String lCity, String lState) {
		super();
		this.lId = lId;
		this.lCity = lCity;
		this.lState = lState;
	}

	@Override
	public String toString() {
		return String.format("Location ID%d: %s, %s", lId, lCity, lState);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (lCity == null) {
			if (other.lCity != null)
				return false;
		} else if (!lCity.equals(other.lCity))
			return false;
		if (lId != other.lId)
			return false;
		if (lState == null) {
			if (other.lState != null)
				return false;
		} else if (!lState.equals(other.lState))
			return false;
		return true;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getlCity() {
		return lCity;
	}

	public void setlCity(String lCity) {
		this.lCity = lCity;
	}

	public String getlState() {
		return lState;
	}

	public void setlState(String lState) {
		this.lState = lState;
	}
}