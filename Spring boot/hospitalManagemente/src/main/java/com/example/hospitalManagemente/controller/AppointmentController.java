package com.example.hospitalManagemente.controller;


import com.example.hospitalManagemente.model.AppointMent;
import com.example.hospitalManagemente.model.PatientList;
import com.example.hospitalManagemente.repository.DoctorListRepo;
import com.example.hospitalManagemente.service.AppointMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class AppointmentController {

    @Autowired
    private AppointMentService appointMentService;
    private DoctorListRepo doctorListRepo;

    @RequestMapping("/appointlist")
    public String addAppointmentList(Model m){
        List<AppointMent> appointList=appointMentService.getAllAppointMent();
        m.addAttribute("appointList",appointList);
        m.addAttribute("titel","All Appointment");
        return "appointMentList";
    }

    @RequestMapping("/appolistpform")
    public String appoSaveForm(Model m){
        m.addAttribute("appoSave",new AppointMent() );
        m.addAttribute("title","Appointment List");
        return "appointMent";
    }

    @PostMapping("/appopost")
    public String appointSaveF(@ModelAttribute AppointMent appointMent){
        appointMentService.saveAppointMent(appointMent);
        return "redirect:/appointlist/add";
    }

    @RequestMapping("/appodelete/{id}")
    public String appoDelete(@PathVariable int id){
        appointMentService.deleteById(id);
        return  "redirect:/appointlist";
    }

    @RequestMapping("/appoedit/{id}")
    public String appoEditFrm(@PathVariable int id,Model m){
        AppointMent appolist=appointMentService.findBy(id);
        m.addAttribute("appoSave",appolist);
        return "appointMent";
    }


        @RequestMapping("/patientsByDoctor")
    public ResponseEntity<List<PatientList>> findPatientsByDoctorName
            (Model m,@RequestParam String name) {
        List<PatientList> patients =
                appointMentService.findPatientsByDoctorName(name);
        m.addAttribute("pasentList",patients);
        m.addAttribute("titel","Patients By Doctor");

//        return "pasentfindbydoctorname";
        return ResponseEntity.ok(patients);
    }
    @RequestMapping("/add")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new AppointMent());
        model.addAttribute("doctors",doctorListRepo.findAll());
        return "add-appointment";
    }

}
