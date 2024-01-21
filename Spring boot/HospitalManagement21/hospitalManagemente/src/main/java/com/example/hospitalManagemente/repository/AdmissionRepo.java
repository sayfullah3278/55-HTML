package com.example.hospitalManagemente.repository;

import com.example.hospitalManagemente.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepo extends JpaRepository<Admission, Integer> {
   // List<PasientAdmissionList> findByDoctorName(String name);
}
