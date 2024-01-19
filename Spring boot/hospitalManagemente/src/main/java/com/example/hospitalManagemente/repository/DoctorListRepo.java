package com.example.hospitalManagemente.repository;

import com.example.hospitalManagemente.model.DoctorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorListRepo extends JpaRepository<DoctorList, Integer> {

    Optional<DoctorList> findByDoctor_id(Integer id);


}
