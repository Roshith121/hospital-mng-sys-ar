package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Medicine;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.repository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/medicine")
@RestController
public class MedicineController {

	private  MedicineRepository medicineRepository;
	
	public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}

	@PostMapping("/meds")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	@GetMapping
	public List<Medicine> getAllMedicines(){
		return medicineRepository.findAll();
	}
}
