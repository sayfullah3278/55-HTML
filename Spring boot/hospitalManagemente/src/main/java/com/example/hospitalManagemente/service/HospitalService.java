package com.example.hospitalManagemente.service;

import com.example.hospitalManagemente.model.AppointMent;
import com.example.hospitalManagemente.model.PatientList;
import com.example.hospitalManagemente.repository.AppointMentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalService {

    @Autowired
    private AppointMentRepo appointmentRepo;

    public List<PatientList> findPatientsByDoctorName(String name) {
        List<AppointMent> appointments = appointmentRepo.findByDoctorName(name);

        // Extract patient names from appointments
        return appointments.stream()
                .map(AppointMent::getPatient)
                .collect(Collectors.toList());
    }
}
