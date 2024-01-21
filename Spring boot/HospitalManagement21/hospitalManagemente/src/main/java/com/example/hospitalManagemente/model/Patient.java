package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private String phone;

        @ManyToOne
        @JoinColumn(name = "doctorId")
        private Doctor doctorId;
    }


