package com.example.hospitalManagemente.repository;

import com.example.hospitalManagemente.model.AppointMent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointMentRepo extends JpaRepository<AppointMent, Integer> {
    List<AppointMent> findByDoctorName(String name);
}
