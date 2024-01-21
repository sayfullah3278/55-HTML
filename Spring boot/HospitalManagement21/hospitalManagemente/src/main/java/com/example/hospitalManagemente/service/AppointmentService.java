package com.example.hospitalManagemente.service;




import com.example.hospitalManagemente.model.Appointments;
import com.example.hospitalManagemente.model.Patient;

import com.example.hospitalManagemente.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    public void saveAppointMent(Appointments appointment){
        appointmentRepo.save(appointment);
    }

    public List<Appointments> getAllAppointMent(){
        return appointmentRepo.findAll();
    }
    public void deleteById(int appointment_id){
        appointmentRepo.deleteById(appointment_id);
    }

    public Appointments findBy(int appointment_id){
        return appointmentRepo.findById(appointment_id).get();
    }

//    public List<Patient> findPatientsByDoctorName(String name) {
//        List<Appointments> appointmentList = appointmentRepo.findByDoctorName(name);
//
//        // Extract patient names from Appointment
//        List<Patient> patients = appointmentList.stream()
//                .map(Appointments::getPatient)
//                .collect(Collectors.toList());
//
//        return patients;
//    }


}
