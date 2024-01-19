package com.example.hospitalManagemente.controller;


import com.example.hospitalManagemente.model.DoctorList;
import com.example.hospitalManagemente.service.DoctorListService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class AddDoctorController {

    @Autowired
    DoctorListService doctorListService;

    @RequestMapping("/doclist")
    public String addDoctorList(Model m){
        List<DoctorList> doctorList=doctorListService.getAllDoctor();
        m.addAttribute("doctorList",doctorList);
        m.addAttribute("titel","All Doctors");
        return "adddoctorlist";
    }
@RequestMapping("/docform")
public String addDoctor(Model m){
//    List<DoctorList> doctorList=doctorListService.getAllDoctor();
//        m.addAttribute("doctorList",doctorList);
        m.addAttribute("docSave",new DoctorList());
        m.addAttribute("title","Doctor List");
        return "addDoctor";
}

@PostMapping("/doctorform")
public String doctorsSaveForm(@ModelAttribute DoctorList docSave){
doctorListService.saveDoctorList(docSave);
return "redirect:/doclist";

}



@RequestMapping("/docdelete/{doctor_id}")
public String  docDelete (@PathVariable int doctor_id){
 doctorListService.deleteById(doctor_id);
 return "redirect:/doclist";
}

@RequestMapping("/editDoc/{doctor_id}")
public String docEditForm(@PathVariable int doctor_id,Model m){
    DoctorList  doclist= doctorListService.findBy(doctor_id);
    m.addAttribute("docSave",doclist);
    return "addDoctor";
}

}
