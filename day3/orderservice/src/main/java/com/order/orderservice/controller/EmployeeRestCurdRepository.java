package com.order.orderservice.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.order.orderservice.model.EmployeeCurdOperation;

@RepositoryRestResource(collectionResourceRel = "employeecurdopr", path = "restEmployee")
public interface EmployeeRestCurdRepository extends CrudRepository<EmployeeCurdOperation, Long> {

}