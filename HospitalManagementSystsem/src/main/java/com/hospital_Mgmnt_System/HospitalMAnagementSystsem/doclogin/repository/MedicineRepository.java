package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
