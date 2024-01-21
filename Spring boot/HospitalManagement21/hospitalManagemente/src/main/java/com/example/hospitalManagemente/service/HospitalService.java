package com.example.hospitalManagemente.service;


import com.example.hospitalManagemente.model.Appointments;
import com.example.hospitalManagemente.model.Bill;
import com.example.hospitalManagemente.model.Doctor;
import com.example.hospitalManagemente.repository.BillRepository;
import com.example.hospitalManagemente.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private BillRepository billRepository;

    public  void saveDoctor(Bill bill){
        billRepository.save(bill);
    }

    public List<Bill> getAllDoctor(){
        return  billRepository.findAll();
    }

    public void deleteById(int admission_id){
        billRepository.deleteById(admission_id);
    }

    public Bill findBy(int admission_id){
        return  billRepository.findById(admission_id).get();
    }



    public List<Appointments> findPatientsByDoctorId(Long doctorId) {
        return doctorRepo.findPatientsByDoctorId(doctorId);
    }
}
