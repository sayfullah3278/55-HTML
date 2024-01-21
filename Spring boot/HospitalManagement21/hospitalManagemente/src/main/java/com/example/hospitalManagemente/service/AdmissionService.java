package com.example.hospitalManagemente.service;




import com.example.hospitalManagemente.model.Admission;
import com.example.hospitalManagemente.repository.AdmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepo admissionRepo;

    public void savePasientAdmissionList(Admission admission){
        admissionRepo.save(admission);
    }

    public List<Admission> getAllPasientAdmitionList(){
      return admissionRepo.findAll();
    }

    public void deleteById(int id){

        admissionRepo.deleteById(id);
    }

    public Admission findBy(int id){
        return admissionRepo.findById(id).get();
    }



}
