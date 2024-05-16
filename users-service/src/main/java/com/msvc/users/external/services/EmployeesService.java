package com.msvc.users.external.services;

import com.msvc.users.model.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "EMPLOYEES-SERVICE")
public interface EmployeesService {

    @PostMapping("/api/employees")
    Employees createEmpleado(@RequestBody Employees employees);

    @GetMapping("/api/employees/user/{userId}")
    List <Employees> getEmployesByUserId(@PathVariable String userId);



}
