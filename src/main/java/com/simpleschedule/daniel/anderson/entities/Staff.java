package com.simpleschedule.daniel.anderson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	@Column(name="id")
	private Integer sId;
	
	@Column(name="namef")
	private String sFirstname;
	
	@Column(name="namel")
	private String sLastname;
	
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
		this.sFirstname = sFirstname;
		this.sLastname = sLastname;
		this.sLocation = sLocation;
		this.sTitle = sTitle;
	}

	@Override
	public String toString() {
		return String.format("Staff ID %d: %s, %s. %s working out of location %d", 
				sId, sLastname, sFirstname, sTitle, sLocation);
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
		if (sFirstname == null) {
			if (other.sFirstname != null)
				return false;
		} else if (!sFirstname.equals(other.sFirstname))
			return false;
		if (sId != other.sId)
			return false;
		if (sLastname == null) {
			if (other.sLastname != null)
				return false;
		} else if (!sLastname.equals(other.sLastname))
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
		return sFirstname;
	}

	public void setsFirstname(String sFirstname) {
		this.sFirstname = sFirstname;
	}

	public String getsLastname() {
		return sLastname;
	}

	public void setsLastname(String sLastname) {
		this.sLastname = sLastname;
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
