package com.lcwr.HMS.services;

import java.util.List;

import com.lcwr.HMS.entiy.DoctorEntity;

public interface DoctorService {
	
	public List<DoctorEntity> getAllDoctors();
	public DoctorEntity getDoctorById(int id);
	public DoctorEntity addNewDoctor(DoctorEntity doctor);
	public DoctorEntity updateDoctor(DoctorEntity doctor);
	public String removeDoctor(int id);

}
