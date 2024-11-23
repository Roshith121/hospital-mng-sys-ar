package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Appointment;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;
	


	public AppointmentController(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}



	@PostMapping("/add")
	public Appointment creatAppointment(@RequestBody Appointment appointment){
		return appointmentRepository.save(appointment);
	}
	
	@GetMapping()
	public List<Appointment> getAppointments() {
		return appointmentRepository.findAll();
	}	
	
}
