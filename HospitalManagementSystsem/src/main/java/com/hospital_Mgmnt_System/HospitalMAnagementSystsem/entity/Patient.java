package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
@Table(name = "patients")
public class Patient {


	@Id
	private long id;
	
	@Column(name = "first_name")
	private String name;
	@Column(name = "age")
	private String age;
	@Column(name = "blood_group")
	private String blood;
	@Column(name = "prescription")
	private String prescription;
	@Column(name = "dose")
	private String dose;
	@Column(name = "fees")
	private String fees;
	@Column(name = "urgency")
	private String urgency;
	
}