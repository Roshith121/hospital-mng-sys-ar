package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
