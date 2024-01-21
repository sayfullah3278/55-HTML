package com.example.hospitalManagemente.repository;

import com.example.hospitalManagemente.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

    Doctor findByDoctorId(int doctorId);


}
