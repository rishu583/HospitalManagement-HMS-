package com.lcwr.HMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwr.HMS.entiy.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {

}
