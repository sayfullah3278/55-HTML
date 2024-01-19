package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,updatable = false)
    private int id;

    @Column(nullable = false,updatable = false)
    private  String name;


    @Column(nullable = false)
    private  String phone;

    @Column(nullable = false)
    private  String department;

    @Column(nullable = false)
    private  String specilization;

    @Column(nullable = false)
    private  String qualification;

    @Column(nullable = false)
    private  String experience;

    @Column(nullable = false)
    private  String date;


}
