package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Appointments")
public class Appointment {

	@Id
	private long id;
	
	private String name;
	
	private String symptoms;
	
	private String age;
	
	private String number;
	
}
