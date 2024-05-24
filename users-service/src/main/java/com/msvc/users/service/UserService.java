package com.msvc.users.service;

import com.msvc.users.config.rabbitmq.Producer;
import com.msvc.users.external.services.EmployeesService;
import com.msvc.users.model.Employees;
import com.msvc.users.model.User;
import com.msvc.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private Producer producer;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            BeanUtils.copyProperties(userDetails, user, "id");
            return userRepository.save(user);
        }
        return null;
    }

    public ResponseEntity<Employees> createEmployeeForUser(String userId, Employees employee) {
        if (userExists(userId)) {
            // Establecer el ID de usuario en el objeto empleado
            employee.setUserId(userId);
            // Crear el empleado utilizando el servicio de empleados externo
            Employees createdEmployee = employeesService.createEmpleado(employee);
            enviarMensajeConRabbitMQ("Notificacion con RabbitMQ, Empleado creado con exito");
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public boolean userExists(String userId) {
        return userRepository.existsById(userId);
    }

    private void enviarMensajeConRabbitMQ(String message){
        log.info("El mensaje '{}' ha sido enviado con exito", message);
        producer.send(message);
    }



    public User getUserAndEmployees(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        // Verifica si el usuario existe
        if (user != null) {
            List<Employees> employees = employeesService.getEmployesByUserId(userId);
            user.setEmployees(employees);
        }
        return user;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
