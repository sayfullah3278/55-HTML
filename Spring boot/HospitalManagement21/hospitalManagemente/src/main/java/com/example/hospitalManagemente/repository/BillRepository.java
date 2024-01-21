package com.example.hospitalManagemente.repository;

import com.example.hospitalManagemente.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer > {
}
