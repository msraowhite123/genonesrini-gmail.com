package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.orderservice.model.EmployeeCurdOperation;

@Repository
public interface EmployeeCurdRepository extends JpaRepository<EmployeeCurdOperation, Long> {

	// Object findById(Long employeeId);

}
