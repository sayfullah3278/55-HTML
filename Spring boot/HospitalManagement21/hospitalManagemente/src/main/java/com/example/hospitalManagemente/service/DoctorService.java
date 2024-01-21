package com.example.hospitalManagemente.service;

import com.example.hospitalManagemente.model.Doctor;
import com.example.hospitalManagemente.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {


    @Autowired
    private DoctorRepo doctorRepo;

    public  void saveDoctor(Doctor doctor){
        doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctor(){
        return  doctorRepo.findAll();
    }

    public void deleteById(int doctorId){
        doctorRepo.deleteById(doctorId);
    }

    public Doctor findBy(int doctorId){
        return  doctorRepo.findById(doctorId).get();
    }
}
