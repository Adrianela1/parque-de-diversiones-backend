package com.msvc.users.external.services;

import com.msvc.users.model.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EMPLOYEES-SERVICE")
public interface EmployeesService {

    @PostMapping("/api/employees")
    Employees createEmpleado(@RequestBody Employees employees);

}
