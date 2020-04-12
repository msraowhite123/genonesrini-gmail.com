package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.orderservice.model.Department;
import com.order.orderservice.model.Employee;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	//Object findById(Long employeeId);

}
