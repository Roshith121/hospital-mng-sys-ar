package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.entity.Patient;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1")
public class patientController {
	
	public patientController(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	private PatientRepository patientRepository;
	
	@PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient  patient) {
        return patientRepository.save(patient);
        }
    }
