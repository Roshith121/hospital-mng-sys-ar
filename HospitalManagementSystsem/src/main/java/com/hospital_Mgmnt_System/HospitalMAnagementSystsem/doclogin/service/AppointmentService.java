package com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.service;

import java.nio.channels.Pipe.SourceChannel;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Appointment;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.entity.Medicine;
import com.hospital_Mgmnt_System.HospitalMAnagementSystsem.doclogin.repository.AppointmentRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	
	public Appointment updateAppointmentById (long id,Appointment appointmentDetail) throws AttributeNotFoundException {
		Appointment appointment = appointmentRepository.findById(id).get();
		appointment.setSymptoms(appointmentDetail.getSymptoms());
		appointmentRepository.save(appointment);
		return appointment;
	}
	


}
