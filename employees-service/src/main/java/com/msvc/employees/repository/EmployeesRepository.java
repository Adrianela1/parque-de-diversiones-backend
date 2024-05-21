package com.msvc.employees.repository;

import com.msvc.employees.dto.EmployeesAndGameDto;
import com.msvc.employees.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    List<Employees> findByUserId(String userId);



}
