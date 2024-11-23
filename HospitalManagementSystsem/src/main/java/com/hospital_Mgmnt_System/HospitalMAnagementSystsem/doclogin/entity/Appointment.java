package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Appointments")
public class Appointment {

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", symptoms=" + symptoms + ", age=" + age + ", number="
				+ number + "]";
	}

	public Appointment(long id, String name, String symptoms, String age, String number) {
		super();
		this.id = id;
		this.name = name;
		this.symptoms = symptoms;
		this.age = age;
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Id
	private long id;
	
	private String name;
	
	private String symptoms;
	
	public Appointment() {
		super();
	}

	private String age;
	
	private String number;
	
}
