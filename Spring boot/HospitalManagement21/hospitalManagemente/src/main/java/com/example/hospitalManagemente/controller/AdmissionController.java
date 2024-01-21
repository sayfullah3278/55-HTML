package com.example.hospitalManagemente.controller;


import com.example.hospitalManagemente.model.Admission;
import com.example.hospitalManagemente.model.Doctor;
import com.example.hospitalManagemente.repository.DoctorRepo;
import com.example.hospitalManagemente.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class AdmissionController {


    @Autowired
    private AdmissionService admissionListService;
    @Autowired
    private DoctorRepo doctorRepo;


    @RequestMapping("/admitpasentlist")
    public String patientsAdmissionList(Model m){
        List<Admission> admissionList=admissionListService.getAllPasientAdmitionList();
        m.addAttribute("admissionList",admissionList);
        m.addAttribute("title", "All Admited Pasient");
        return "admissionList";
    }

    @RequestMapping("/admissionsaveform")
    public String patintAdmitionSaveForm(Model m){

        List<Doctor> doctor=doctorRepo.findAll();
        m.addAttribute("doctor",doctor);

        m.addAttribute("pasAdmissionSave",new Admission());
        m.addAttribute("title", "All Admission");
        return "admission";
    }


    @PostMapping("/passadmission")
    public  String admissionSaveForm(@ModelAttribute Admission admissionList, Model m){
        admissionListService.savePasientAdmissionList(admissionList);
        return "redirect:/admitpasentlist";
    }

    @RequestMapping("/admissiondelet/{admission_id}")
    public String admissionDelete(@PathVariable int admission_id){
        admissionListService.deleteById(admission_id);
        return "redirect:/admitpasentlist";
    }

    @RequestMapping("/admissioneditfrm/{admission_id}")
    public String admissionEditFrm(@PathVariable int admission_id,Model m){
        Admission admissionList=admissionListService.findBy(admission_id);
        m.addAttribute("pasAdmissionSave",admissionList);
        return "admission";
    }

}
