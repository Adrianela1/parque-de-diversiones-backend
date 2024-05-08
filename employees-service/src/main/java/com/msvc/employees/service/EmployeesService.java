package com.msvc.employees.service;

import com.msvc.employees.model.Employees;
import com.msvc.employees.repository.EmployeesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {


        @Autowired
        private EmployeesRepository employeesRepository;

        public List<Employees> getAllEmployees() {
            return employeesRepository.findAll();
        }

        public Employees getEmployeesById(Long id) {
            return employeesRepository.findById(id).orElse(null);
        }

        public Employees createEmployees(Employees employees) {
            return employeesRepository.save(employees);
        }

        public Employees updateEmployees(Long id, Employees employeesDetails) {
            Employees employees = employeesRepository.findById(id).orElse(null);
            if (employees != null) {
                BeanUtils.copyProperties(employeesDetails, employees, "id");
                return employeesRepository.save(employees);
            }
            return null;
        }

        public void deleteEmployees(Long id) {
            employeesRepository.deleteById(id);
        }

}
