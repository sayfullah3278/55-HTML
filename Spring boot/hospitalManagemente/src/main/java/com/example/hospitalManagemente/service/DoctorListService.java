package com.example.hospitalManagemente.service;


import com.example.hospitalManagemente.model.DoctorList;
import com.example.hospitalManagemente.repository.DoctorListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorListService {

    @Autowired
    private DoctorListRepo
            doctorListRepo;

    public  void saveDoctorList(DoctorList doctorList){
        doctorListRepo.save(doctorList);
    }

    public List<DoctorList> getAllDoctor(){
        return  doctorListRepo.findAll();
    }

    public void deleteById(int id){
        doctorListRepo.deleteById(id);
    }

    public DoctorList findBy(int id){
        return  doctorListRepo.findById(id).get();
    }
}
