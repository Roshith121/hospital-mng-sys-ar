package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "Medicine")
public class Medicine {
	
	@Id
	private long id;

	@Column(name = "drug")
	private String drug;
	
	@Column(name="stock")
	private String stock;

}
