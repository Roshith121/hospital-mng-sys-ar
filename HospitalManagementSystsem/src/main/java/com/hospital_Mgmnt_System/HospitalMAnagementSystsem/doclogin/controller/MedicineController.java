package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.hibernate.graph.internal.AttributeNodeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Medicine;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.repository.MedicineRepository;
import com.mysql.cj.protocol.x.Ok;

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
	
	@GetMapping("/fetch")
	public List<Medicine> getAllMedicines(){
		return medicineRepository.findAll();
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException
	{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine Not found"));
		return ResponseEntity.ok(medicine);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> updateExistingMedicine(@PathVariable long id, @RequestBody Medicine medicineDetail) throws AttributeNotFoundException
	{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found"));
		medicine.setDrug(medicineDetail.getDrug());
		medicine.setId(medicineDetail.getId());
		medicine.setStock(medicineDetail.getStock());
		
		Medicine savedMedicine = medicineRepository.save(medicine);
		return ResponseEntity.ok(savedMedicine);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException
	{
		Medicine medicine  = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine Record doesn't exist in db"));
		medicineRepository.delete(medicine);
		Map<String, Boolean> removedMedicine = new HashMap<String, Boolean>();
		removedMedicine.put("Delete", Boolean.TRUE);
		return ResponseEntity.ok(removedMedicine);
	}
	
}
