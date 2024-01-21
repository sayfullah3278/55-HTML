package com.example.hospitalManagemente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    private int age;

    private Date admissionDate;

    private Date dischargeDate;

    private double totalAmount;

    private double paidAmount;

    private double dueAmount;


    private String paymentMethod;

    // other billing information fields

    @ManyToOne
    @JoinColumn(name = "admission_id")
    private Discharge admission;
}
