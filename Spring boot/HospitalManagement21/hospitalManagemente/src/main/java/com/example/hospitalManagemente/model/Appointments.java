package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Appointments {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int appointment_id;


        private  String name;


        private  String email;



        private  String phone;


        private  String date;


        private  String department;


        private  String doctor;


        private  String disise;

        @ManyToOne
        @JoinColumn(name = "doctorId")
        private Doctor doctorsId;

        @ManyToOne
        @JoinColumn(name = "patient_id")
        private Patient patient;



    }
