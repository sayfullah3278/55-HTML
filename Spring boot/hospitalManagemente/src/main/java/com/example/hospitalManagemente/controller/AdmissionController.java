package com.example.hospitalManagemente.controller;


import com.example.hospitalManagemente.model.PasientAdmissionList;
import com.example.hospitalManagemente.service.AppointMentService;
import com.example.hospitalManagemente.service.DoctorListService;
import com.example.hospitalManagemente.service.PasientAdmissionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class AdmissionController {


    @Autowired
    private PasientAdmissionListService admissionListService;


    @RequestMapping("/admitpasentlist")
    public String patientsAdmissionList(Model m){
        List<PasientAdmissionList> admissionList=admissionListService.getAllPasientAdmitionList();
        m.addAttribute("admissionList",admissionList);
        m.addAttribute("title", "All Admited Pasient");
        return "patientsAdmissionList";
    }

    @RequestMapping("/admissionsaveform")
    public String patintAdmitionSaveForm(Model m){

        m.addAttribute("pasAdmissionSave",new PasientAdmissionList());
        m.addAttribute("title", "All Admission");
        return "patientsAdmission";
    }


    @PostMapping("/passadmission")
    public  String admissionSaveForm(@ModelAttribute PasientAdmissionList admissionList, Model m){
        admissionListService.savePasientAdmissionList(admissionList);
        return "redirect:/admitpasentlist";
    }

    @RequestMapping("/admissiondelet/{id}")
    public String admissionDelete(@PathVariable int id){
        admissionListService.deleteById(id);
        return "redirect:/admitpasentlist";
    }

    @RequestMapping("/admissioneditfrm/{id}")
    public String admissionEditFrm(@PathVariable int id,Model m){
        PasientAdmissionList admissionList=admissionListService.findBy(id);
        m.addAttribute("pasAdmissionSave",admissionList);
        return "patientsAdmission";
    }

}
