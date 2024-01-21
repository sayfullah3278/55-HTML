package com.example.hospitalManagemente.controller;


import com.example.hospitalManagemente.model.Doctor;
import com.example.hospitalManagemente.service.DoctorService;
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
public class DoctorController {

    @Autowired
    DoctorService doctorListService;

    @RequestMapping("/doclist")
    public String addDoctor(Model m){
        List<Doctor> doctor=doctorListService.getAllDoctor();
        m.addAttribute("doctor",doctor);
        m.addAttribute("titel","All Doctors");
        return "adddoctorlist";
    }
@RequestMapping("/docform")
public String addDoctorfrm(Model m){
//    List<DoctorList> doctorList=doctorListService.getAllDoctor();
//        m.addAttribute("doctorList",doctorList);
        m.addAttribute("docSave",new Doctor());
        m.addAttribute("title","Doctor List");
        return "addDoctor";
}

@PostMapping("/doctorform")
public String doctorsSaveForm(@ModelAttribute Doctor docSave){
doctorListService.saveDoctor(docSave);
return "redirect:/doclist";


}



@RequestMapping("/docdelete/{doctorId}")
public String  docDelete (@PathVariable int doctorId){
 doctorListService.deleteById(doctorId);
 return "redirect:/doclist";
}

@RequestMapping("/editDoc/{doctorId}")
public String docEditForm(@PathVariable int doctorId,Model m){
    Doctor  doclist= doctorListService.findBy(doctorId);
    m.addAttribute("docSave",doclist);
    return "addDoctor";
}

}
