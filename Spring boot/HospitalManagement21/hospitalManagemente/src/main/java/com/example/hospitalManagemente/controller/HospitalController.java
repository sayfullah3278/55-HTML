package com.example.hospitalManagemente.controller;

import com.example.hospitalManagemente.model.Admission;
import com.example.hospitalManagemente.model.Bill;
import com.example.hospitalManagemente.model.Appointments;
import com.example.hospitalManagemente.repository.AdmissionRepo;
import com.example.hospitalManagemente.repository.BillRepository;
import com.example.hospitalManagemente.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("")
public class HospitalController {

    @Autowired
    private AdmissionRepo admissionRepo;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/discharge/{admission_id}")
    public String dischargePatientForm(@PathVariable int admission_id, Model model) {
        try {
            Admission admission = admissionRepo.findById(admission_id).orElseThrow();
            model.addAttribute("admission", admission);
            return "patient-dischargeform";
        } catch (NoSuchElementException e) {
            // Handle the exception and return an error page
            return "error";
        }
    }

    @PostMapping("/discharge")
    public String dischargePatient(@ModelAttribute Admission admission) {
        // Perform discharge logic (update patient status, etc.)
        admissionRepo.save(admission);
        return "redirect:/hospital/discharge/" + admission.getAdmission_id();
    }

    @RequestMapping("/billing/{admission_id}")
    public String billingForm(@PathVariable int admission_id, Model model) {
        try {
            Admission admission = admissionRepo.findById(admission_id).orElseThrow();
            model.addAttribute("admission", admission);
            model.addAttribute("bill", new Bill());
            return "billform";
        } catch (NoSuchElementException e) {
            // Handle the exception and return an error page
            return "error";
        }
    }

    @GetMapping("/billing")
    public String submitBilling(@ModelAttribute Bill bill) {
//         Perform billing logic (calculate total amount, save bill, etc.)
        billRepository.save(bill);
        return "redirect:/hospital/billing/" + bill.getAdmission();
    }

    @RequestMapping("/patientsfindById")
    public String searchPatientsByDoctor(@RequestParam("doctorId") int doctorId, Model model) {
        List<Appointments> appointments = hospitalService.findPatientsByDoctorId(doctorId);
        model.addAttribute("appointments", appointments);
        return "pasentfindbydoctorname"; // Replace with the actual view name
    }
}
