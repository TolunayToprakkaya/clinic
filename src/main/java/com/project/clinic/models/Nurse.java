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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "nurses")
public class Nurse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nurse_id")
	private Integer nurse_id;
	
	@Column(name = "name")
	@NotEmpty(message = "*İsmini Girin")
	private String name;
	
	@Column(name = "surname")
	@NotEmpty(message = "*Soyadını Girin")
	private String surname;
	
	@Column(name = "age")
	@NotEmpty(message = "*Yaş Alanını Doldurunuz!")
	@Size(min = 1, max = 3, message = "Yaş Min 1 Max 3 karakterli olmalıdır!")
	private String age;	

	@Column(name = "experience")
	@NotEmpty(message = "*Deneyim Alanını Doldurunuz!")
	@Size(min = 1, max = 3, message = "Deneyim Min 1 Max 3 karakterli olmalıdır!")
	private String experience;
	
	@Column(name = "department")
	@NotEmpty(message = "*Bölüm Alanını Doldurunuz!")
	private String department;

	@Column(name = "email")
	@Email(message = "*Mail Formatında Doldurun!")
	@NotEmpty(message = "*Mail Alanını Doldurunuz!")
	private String email;	
	
	@Lob
	@Column(name = "image", length=100000)
	@NotEmpty(message = "*Resim Zorunludur")
	private byte[]  image;
	
	@Column(name = "phoneNumber")
	@Size(min = 11, max = 11, message = "Telefon Numarası 11 karakterli olmalıdır!")
	@NotEmpty(message = "*Telefon Numarasını Girin")
	private String phoneNumber;
	
	@Column(name = "address")
	@NotEmpty(message = "*Adresini Girin")
	private String address;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "nurses" )
	private Set<Patient> patients = new HashSet<>();
	
	public Integer getNurse_id() {
		return nurse_id;
	}
	public void setNurse_id(Integer nurse_id) {
		this.nurse_id = nurse_id;
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
	
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
}
