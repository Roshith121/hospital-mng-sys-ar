package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.entity.Patient;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/patients")
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
	
	@GetMapping("/fetch")
	public List<Patient> getPatients()
	{
		return patientRepository.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException
	{
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient with "+ id + " number didn't exist in records"));
		return ResponseEntity.ok(patient);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException
	{
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient with "+ id + " number didn't exist in records"));
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted Patient", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatientDetail(@PathVariable long id, @RequestBody Patient patientDetail) throws AttributeNotFoundException
	{
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient with "+ id + " number didn't exist in records"));
		patient.setAge(patientDetail.getAge());
		patient.setBlood(patientDetail.getBlood());
		patient.setDose(patientDetail.getDose());
		patient.setFees(patientDetail.getFees());
		patient.setId(patientDetail.getId());
		patient.setName(patientDetail.getName());
		patient.setPrescription(patientDetail.getPrescription());
		patient.setUrgency(patientDetail.getUrgency());
		
		Patient savedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(savedPatient);
		
	}
 }
