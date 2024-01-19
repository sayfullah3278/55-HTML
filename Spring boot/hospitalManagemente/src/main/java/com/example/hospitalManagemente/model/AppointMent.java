package com.example.hospitalManagemente.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointMent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,updatable = false)
    private int id;

    @Column(nullable = false,updatable = false)
    private  String name;

    @Column(unique = true, nullable = false)
    private  String email;


    @Column(nullable = false)
    private  String phone;

    @Column(nullable = false)
    private  String date;

    @Column(nullable = false)
    private  String department;

    @Column(nullable = false)
    private  String doctor;

    @Column(nullable = false)
    private  String disise;

    @ManyToOne
    @JoinColumn(name = "id")
    private DoctorList doctorList;

    @ManyToOne
    @JoinColumn(name = "id")
    private PatientList patient;

}
