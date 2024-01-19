package com.example.hospitalManagemente.repository;

import com.example.hospitalManagemente.model.PasientAdmissionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasientAdmissionListRepo extends JpaRepository<PasientAdmissionList, Integer> {
    List<PasientAdmissionList> findByDoctorName(String name);
}
