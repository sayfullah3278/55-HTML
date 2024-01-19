package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (insertable=false, updatable=false)
    private int id;

    private String name;

    private String age;
}
