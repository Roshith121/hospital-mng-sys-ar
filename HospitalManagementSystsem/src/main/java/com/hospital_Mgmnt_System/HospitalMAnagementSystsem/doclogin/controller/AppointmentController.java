package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Appointment;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.repository.AppointmentRepository;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.service.AppointmentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	AppointmentService appointmentService;


//	public AppointmentController(AppointmentRepository appointmentRepository) {
//		super();
//		this.appointmentRepository = appointmentRepository;
//	}



	@PostMapping("/add")
	public ResponseEntity<Appointment> creatAppointment(@RequestBody Appointment appointment){
		Appointment appointment1 =  appointmentRepository.save(appointment);
		return ResponseEntity.ok(appointment1);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Appointment>> getAppointments() {
		List<Appointment> appointment= appointmentRepository.findAll();
		return ResponseEntity.ok(appointment);
		
	}	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException
	{
		Appointment appointment = appointmentRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Attribute with" +   id + " doesn't exist"));
		appointmentRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updateSymptoms/{id}")
	public ResponseEntity<Appointment> updateSymptoms(@PathVariable long id, @RequestBody Appointment appointmentDetails ) throws AttributeNotFoundException{
		Appointment appointment= appointmentService.updateAppointmentById(id, appointmentDetails);
		return ResponseEntity.ok(appointment);
		
	}
	
}
