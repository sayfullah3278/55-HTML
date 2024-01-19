package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PasientAdmissionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (insertable=false, updatable=false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String phone;

    @Column( nullable = false)
    private int age;

    @Column( nullable = false)
    private String sex;

    @Column( nullable = false)
    private String bloodGroup;

    @Column( nullable = false)
    private String department;

    @Column( nullable = false)
    private String doctor;

    @Column(nullable = false)
    private String diseaseDescription;

    @Column(nullable = false)
    private LocalDateTime admissionDate;

    @Column(nullable = false)
    private String emergencyContactNumber;

    @Column(nullable = false)
    private String relationshipWithPatient;

    @ManyToOne
    @JoinColumn(name = "id")
    private DoctorList doctorList;
}
