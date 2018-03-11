package com.project.clinic.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private Integer patient_id;
	
	@Column(name = "identity_number")
	@Size(min = 11, max = 11, message = "*TC Numarası 11 karakterli olmalıdır!")
	@NotEmpty(message = "*TC Numarasını Doldurunuz!")
	private String identity_number;
	
	@Column(name = "name")
	@NotEmpty(message = "*Adınız Alanını Doldurunuz!")
	private String name;
	
	@Column(name = "surname")
	@NotEmpty(message = "*Soyadınız Alanını Doldurunuz!")
	private String surname;
	
	@Column(name = "age")
	@NotEmpty(message = "*Yaş Alanını Doldurunuz!")
	private String age;
	
	@NotEmpty(message = "*Telefon Numaranızı Doldurunuz!")
	@Size(min = 11, max = 11, message = "*Telefon Numarası 11 karakterli olmalıdır!")
	@Column(name = "phoneNumber")	
	private String phoneNumber;
	
	@NotEmpty(message = "*Telefon Numaranızı Doldurunuz!")
	@Size(min = 11, max = 11, message = "*Telefon Numarası 11 karakterli olmalıdır!")
	@Column(name = "sitterPhoneNumber")	
	private String sitterPhoneNumber;
	
	@Column(name = "address")
	@NotEmpty(message = "Adres Alanını Doldurunuz!")
	private String address;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "patient_doctor", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private Set<Doctor> doctors = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "patient_nurse", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "nurse_id"))
	private Set<Nurse> nurses = new HashSet<>();
	
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getIdentity_number() {
		return identity_number;
	}
	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSitterPhoneNumber() {
		return sitterPhoneNumber;
	}
	public void setSitterPhoneNumber(String sitterPhoneNumber) {
		this.sitterPhoneNumber = sitterPhoneNumber;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Set<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(Set<Nurse> nurses) {
		this.nurses = nurses;
	}
}
