package com.lcwr.HMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwr.HMS.entiy.DoctorEntity;
import com.lcwr.HMS.repositories.DoctorRepository;

@Service
public class DoctorServiceImple implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<DoctorEntity> getAllDoctors() {
		
		return doctorRepository.findAll();
	}

	@Override
	public DoctorEntity getDoctorById(int id) {
		
		return doctorRepository.findById(id).get();
	}

	@Override
	public DoctorEntity addNewDoctor(DoctorEntity doctor) {
		DoctorEntity newDoc=doctorRepository.save(doctor);
		return newDoc;
	}

	@Override
	public DoctorEntity updateDoctor(DoctorEntity doctor) {
		DoctorEntity doct=null;
		List<DoctorEntity> list=doctorRepository.findAll();
		for(DoctorEntity d:list) {
			if(d.getId()==doctor.getId()) {
				doct=d;
				break;
			}
		}
		return doct;
	}

	@Override
	public String removeDoctor(int id) {
		doctorRepository.deleteById(id);
		return "doctor is removedSuccessfully";
	}
	

}
