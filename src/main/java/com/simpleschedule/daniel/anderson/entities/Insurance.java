package com.simpleschedule.daniel.anderson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Insurance {
	@Id
	@Column(name="patientId", length=4)
	private Integer iPatientId;
	
	@Column(name="id", nullable=false)
	@NotEmpty
	private String iId;
	
	@Column(name="groupId", nullable=false)
	@NotEmpty
	private String iGroupId;
	
	@Column(name="planId", nullable=false)
	@NotEmpty
	private String iPlanId;
	
	@Column(name="provider", nullable=false)
	@NotEmpty
	private String iProvider;
	
	public Insurance() {
		super();
	}

	@Override
	public String toString() {
		return String.format("Insurance for Patient ID%s: ID: %s, GroupID: %s, PlanID: %s, Provider: %s",
				iPatientId, iId, iGroupId, iPlanId, iProvider);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		if (iGroupId == null) {
			if (other.iGroupId != null)
				return false;
		} else if (!iGroupId.equals(other.iGroupId))
			return false;
		if (iId == null) {
			if (other.iId != null)
				return false;
		} else if (!iId.equals(other.iId))
			return false;
		if (iPatientId == null) {
			if (other.iPatientId != null)
				return false;
		} else if (!iPatientId.equals(other.iPatientId))
			return false;
		if (iPlanId == null) {
			if (other.iPlanId != null)
				return false;
		} else if (!iPlanId.equals(other.iPlanId))
			return false;
		if (iProvider == null) {
			if (other.iProvider != null)
				return false;
		} else if (!iProvider.equals(other.iProvider))
			return false;
		return true;
	}

	public Insurance(Integer iPatientId, String iId, String iGroupId, String planId, String iProvider) {
		super();
		this.iPatientId = iPatientId;
		this.iId = iId;
		this.iGroupId = iGroupId;
		this.iPlanId = planId;
		this.iProvider = iProvider;
	}

	public Integer getiPatientId() {
		return iPatientId;
	}
	
	public void setiPatientId(Integer iPatientId) {
		this.iPatientId = iPatientId;
	}
	
	public String getiId() {
		return iId;
	}

	public void setiId(String iId) {
		this.iId = iId;
	}

	public String getiGroupId() {
		return iGroupId;
	}

	public void setiGroupId(String iGroupId) {
		this.iGroupId = iGroupId;
	}

	public String getiPlanId() {
		return iPlanId;
	}

	public void setiPlanId(String iPlanId) {
		this.iPlanId = iPlanId;
	}
	
	public String getiProvider() {
		return iProvider;
	}
	
	public void setiProvider(String iProvider) {
		this.iProvider = iProvider;
	}
}