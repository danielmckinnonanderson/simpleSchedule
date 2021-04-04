package com.simpleschedule.daniel.anderson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {
	@Id
	@Column(name="patientid")
	private Integer cPatientId;
	
	@Column(name="phone1", nullable=false)
	private Long cPhone1;
	
	@Column(name="phone2", nullable=true)
	private Long cPhone2;
	
	@Column(name="phone3", nullable=true)
	private Long cPhone3;
	
	@Column(name="email", nullable=false)
	private String cEmail;
	
	public Contact() {
		super();
	}

	public Contact(Integer cPatientId, String cEmail, Long cPhone1) {
		super();
		this.cPatientId = cPatientId;
		this.cEmail = cEmail;
	}
	

	public Contact(Integer cPatientId, Long cPhone1, String cEmail) {
		super();
		this.cPatientId = cPatientId;
		this.cPhone1 = cPhone1;
		this.cEmail = cEmail;
	}

	public Contact(Integer cPatientId, Long cPhone1, Long cPhone2, String cEmail) {
		super();
		this.cPatientId = cPatientId;
		this.cPhone1 = cPhone1;
		this.cPhone2 = cPhone2;
		this.cEmail = cEmail;
	}

	public Contact(Integer cPatientId, Long cPhone1, Long cPhone2, Long cPhone3, String cEmail) {
		super();
		this.cPatientId = cPatientId;
		this.cPhone1 = cPhone1;
		this.cPhone2 = cPhone2;
		this.cPhone3 = cPhone3;
		this.cEmail = cEmail;
	}

	@Override
	public String toString() {
		return String.format("Contact for Patient ID %d: Phone 1- %d, Phone 2- %d, Phone 3-%d, Email- %s",
				cPatientId, cPhone1, cPhone2, cPhone3, cEmail);
	}
	
	public Integer getcPatientId() {
		return cPatientId;
	}

	public void setcPatientId(Integer cPatientId) {
		this.cPatientId = cPatientId;
	}

	public Long getcPhone1() {
		return cPhone1;
	}

	public void setcPhone1(Long cPhone1) {
		this.cPhone1 = cPhone1;
	}

	public Long getcPhone2() {
		return cPhone2;
	}

	public void setcPhone2(Long cPhone2) {
		this.cPhone2 = cPhone2;
	}

	public Long getcPhone3() {
		return cPhone3;
	}

	public void setcPhone3(Long cPhone3) {
		this.cPhone3 = cPhone3;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
}
