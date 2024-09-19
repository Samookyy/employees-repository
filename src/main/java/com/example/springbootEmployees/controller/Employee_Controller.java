package com.example.springbootEmployees.controller;

import com.example.springbootEmployees.dtos.EmployeeRecordDto;
import com.example.springbootEmployees.entity.EmployeeEntity;
import com.example.springbootEmployees.repository.Employee_repository;
import com.example.springbootEmployees.service.Employee_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //indica que a classe é um controller Spring mvc que os metodos retornam os dados que serão convertidos para json(ou outro formato
@RequestMapping("api/v1/employees") // define a base url pra os endpoints
public class Employee_Controller {

    @Autowired //usado para injectar o serviço que manipula a logica de negocios
    private Employee_Service employee_service;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> createEmployee(@Valid @RequestBody EmployeeRecordDto employeeRecordDto) {
        EmployeeEntity employee1 = employee_service.create_Employee(employeeRecordDto);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @GetMapping("/employeesdb")
    public ResponseEntity <List<EmployeeEntity>> getAllEmployees() {
       List<EmployeeEntity> employeeEntityList = employee_service.listAllEmployees();
       return new ResponseEntity<>(employeeEntityList, HttpStatus.OK);
    }

    @GetMapping("/{id}") //Mapeia requisições GET para /employees/{id}
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
        EmployeeEntity employee = employee_service.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PutMapping("/employees")
    public ResponseEntity<EmployeeEntity> updateEmployeeById(@RequestBody Long id,@Valid EmployeeRecordDto employeeRecordDto) {
        EmployeeEntity employee = employee_service.updateEmployeeById(id, employeeRecordDto);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<EmployeeEntity> deleteEmployeeById(@PathVariable Long id) {
        EmployeeEntity employee = employee_service.deleteEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
