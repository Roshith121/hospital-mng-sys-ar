package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Medicine")
public class Medicine {
	
	@Id
	private long id;
	
	public Medicine(long id, String drug, String stock) {
		super();
		this.id = id;
		this.drug = drug;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", drug=" + drug + ", stock=" + stock + "]";
	}

	public Medicine() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	@Column(name = "drug")
	private String drug;
	
	@Column(name="stock")
	private String stock;

}
