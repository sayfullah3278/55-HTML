package com.example.hospitalManagemente.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Discharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dischargeId;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "admission_date")
    private Date admission_date;


    @Column(name = "discharge_date")
    private Date dischargeDate;

    @Column(name = "discharge_summary", length = 1000)
    private String dischargeSummary;


    @ManyToOne
    @JoinColumn(name = "admission_id")
    private Admission admission;

}
