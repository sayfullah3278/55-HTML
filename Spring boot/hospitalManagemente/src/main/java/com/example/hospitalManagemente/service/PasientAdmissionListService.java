package com.example.hospitalManagemente.service;


import com.example.hospitalManagemente.model.PasientAdmissionList;
import com.example.hospitalManagemente.repository.PasientAdmissionListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasientAdmissionListService {

    @Autowired
    private PasientAdmissionListRepo admissionListRepo;

    public void savePasientAdmissionList(PasientAdmissionList admissionList){
        admissionListRepo.save(admissionList);
    }

    public List<PasientAdmissionList> getAllPasientAdmitionList(){
      return admissionListRepo.findAll();
    }

    public void deleteById(int id){

        admissionListRepo.deleteById(id);
    }

    public PasientAdmissionList findBy(int id){
        return admissionListRepo.findById(id).get();
    }



}
