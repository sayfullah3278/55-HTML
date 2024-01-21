package com.example.hospitalManagemente.controller;



import com.example.hospitalManagemente.model.Appointments;
import com.example.hospitalManagemente.model.Doctor;
import com.example.hospitalManagemente.model.Patient;

import com.example.hospitalManagemente.repository.DoctorRepo;
import com.example.hospitalManagemente.service.AppointmentService;
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
    private AppointmentService appointMentService;
    @Autowired
    private DoctorRepo doctorRepo;

    @RequestMapping("/appointlist")
    public String addAppointmentList(Model m){
        List<Appointments> appointList=appointMentService.getAllAppointMent();
        m.addAttribute("appointList",appointList);
        m.addAttribute("titel","All Appointment");
        return "appointMentList";
    }

    @RequestMapping("/appolistpform")
    public String appoSaveForm(Model m){
        //doctor dropdown
        List<Doctor> doctor=doctorRepo.findAll();
        m.addAttribute("doctor",doctor);
        //doctor dropdown end
        m.addAttribute("appoSave",new Appointments() );
        m.addAttribute("title","Appointment List");
        return "appointMent";
    }

    @PostMapping("/appopost")
    public String appointSaveF(@ModelAttribute Appointments appointMent){
        appointMentService.saveAppointMent(appointMent);
        return "redirect:/appointlist";
    }

    @RequestMapping("/appodelete/{appointment_id}")
    public String appoDelete(@PathVariable int appointment_id){
        appointMentService.deleteById(appointment_id);
        return  "redirect:/appointlist";
    }

    @RequestMapping("/appoedit/{appointment_id}")
    public String appoEditFrm(@PathVariable int appointment_id,Model m){
        Appointments appolist=appointMentService.findBy(appointment_id);
        m.addAttribute("appoSave",appolist);
        return "appointMent";
    }


//        @RequestMapping("/patientsByDoctor")
//    public ResponseEntity<List<Patient>> findPatientsByDoctorName
//            (Model m,@RequestParam String name) {
//        List<Patient> patients =
//                appointMentService.findPatientsByDoctorName(name);
//        m.addAttribute("pasentList",patients);
//        m.addAttribute("titel","Patients By Doctor");
//
////        return "pasentfindbydoctorname";
//        return ResponseEntity.ok(patients);
//    }
//    @RequestMapping("/add")
//    public String showAppointmentForm(Model model) {
//        model.addAttribute("appointment", new Appointments());
//        model.addAttribute("doctors", doctorRepo.findAll());
//        return "add-appointment";
//    }

}
