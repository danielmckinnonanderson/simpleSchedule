package com.simpleschedule.daniel.anderson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance {
	@Id
	@Column(name="patientId", length=4)
	private Integer iPatientId;
	
	@Column(name="id", nullable=false)
	private String iId;
	
	@Column(name="groupId", nullable=false)
	private String iGroupId;
	
	@Column(name="planId", nullable=false)
	private String planId;
	
	public Insurance() {
		super();
	}

	public Insurance(String iId, String iGroupId, String planId) {
		super();
		this.iId = iId;
		this.iGroupId = iGroupId;
		this.planId = planId;
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
}
