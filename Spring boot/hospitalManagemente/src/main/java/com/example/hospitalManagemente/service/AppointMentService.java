package com.example.hospitalManagemente.service;


import com.example.hospitalManagemente.model.AppointMent;
import com.example.hospitalManagemente.model.PatientList;
import com.example.hospitalManagemente.repository.AppointMentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointMentService {

    @Autowired
    private AppointMentRepo appointMentRepo;

    public void saveAppointMent(AppointMent appointMent){
        appointMentRepo.save(appointMent);
    }

    public List<AppointMent> getAllAppointMent(){
        return appointMentRepo.findAll();
    }
    public void deleteById(int id){
        appointMentRepo.deleteById(id);
    }

    public AppointMent findBy(int id){
        return appointMentRepo.findById(id).get();
    }

    public List<PatientList> findPatientsByDoctorName(String doctorName) {
        List<AppointMent> appointments = appointMentRepo.findByDoctorName(doctorName);

        // Extract patient names from appointments
        List<PatientList> patients = appointments.stream()
                .map(AppointMent::getPatient)
                .collect(Collectors.toList());

        return patients;
    }

}
