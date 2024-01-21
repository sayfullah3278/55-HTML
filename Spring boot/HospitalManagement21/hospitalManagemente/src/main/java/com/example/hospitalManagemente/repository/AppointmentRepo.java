package com.example.hospitalManagemente.repository;


import com.example.hospitalManagemente.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointments, Integer> {
//    List<AppointMent> findByDoctorName(String name);


}


