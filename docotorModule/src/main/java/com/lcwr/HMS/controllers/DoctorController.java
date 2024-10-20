package com.lcwr.HMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwr.HMS.entiy.DoctorEntity;
import com.lcwr.HMS.services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctors")
	public List<DoctorEntity> findAllDoctors(){
		
		return doctorService.getAllDoctors();
	}
	@GetMapping("/doctors/{id}")
	public ResponseEntity<DoctorEntity> findDoctorById(@PathVariable int id) {
		 DoctorEntity doctors = doctorService.getDoctorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(doctors) ;
		
	}
	@PostMapping("/joinDoc")
	public ResponseEntity<DoctorEntity> joinNewDoctor(@RequestBody DoctorEntity doctor) {
		DoctorEntity newDoctor = doctorService.addNewDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
	}
	@PutMapping("/update")
	public ResponseEntity<DoctorEntity> updateDoctor(@RequestBody DoctorEntity doctor){
		DoctorEntity updateDoctor = doctorService.updateDoctor(doctor);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateDoctor);
	}
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
		String message = doctorService.removeDoctor(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

}
