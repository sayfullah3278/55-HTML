package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admission_id;

    private String name;

    private String email;

    private String phone;

    private int age;

    private String sex;

    private String bloodGroup;

    private String department;

    private String doctor;

    private String diseaseDescription;

    private LocalDateTime admissionDate;

    private String emergencyContactNumber;

    private String relationshipWithPatient;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctorsId;

    @OneToMany(mappedBy = "id")
    private List<Bill> bills;


}
