package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int doctorId;


    private  String name;



    private  String phone;


    private  String department;


    private  String specilization;


    private  String qualification;

    private  String experience;


//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;


    @OneToMany(mappedBy = "doctorsId", cascade = CascadeType.ALL)
    private List<Appointments> appointments = new ArrayList<>();



}
