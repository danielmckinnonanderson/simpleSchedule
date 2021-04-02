package com.simpleschedule.daniel.anderson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	@Column(name="id", length=3)
	private Integer sId;
	
	@Column(name="namef")
	private String sFirstName;
	
	@Column(name="namel")
	private String sLastName;
	
	@Column(name="locationid")
	private Integer sLocation;
	
	@Column(name="title")
	private String sTitle;
	
	public Staff() {
		super();
	}

	public Staff(int sId, String sFirstname, String sLastname, int sLocation, String sTitle) {
		super();
		this.sId = sId;
		this.sFirstName = sFirstname;
		this.sLastName = sLastname;
		this.sLocation = sLocation;
		this.sTitle = sTitle;
	}

	@Override
	public String toString() {
		return String.format("Staff ID %d: %s, %s. %s working out of location %d", 
				sId, sLastName, sFirstName, sTitle, sLocation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (sFirstName == null) {
			if (other.sFirstName != null)
				return false;
		} else if (!sFirstName.equals(other.sFirstName))
			return false;
		if (sId != other.sId)
			return false;
		if (sLastName == null) {
			if (other.sLastName != null)
				return false;
		} else if (!sLastName.equals(other.sLastName))
			return false;
		if (sLocation != other.sLocation)
			return false;
		if (sTitle == null) {
			if (other.sTitle != null)
				return false;
		} else if (!sTitle.equals(other.sTitle))
			return false;
		return true;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsFirstname() {
		return sFirstName;
	}

	public void setsFirstname(String sFirstname) {
		this.sFirstName = sFirstname;
	}

	public String getsLastname() {
		return sLastName;
	}

	public void setsLastname(String sLastname) {
		this.sLastName = sLastname;
	}

	public int getsLocation() {
		return sLocation;
	}

	public void setsLocation(int sLocation) {
		this.sLocation = sLocation;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
}
