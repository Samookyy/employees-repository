package com.example.springbootEmployees.service;

import com.example.springbootEmployees.dtos.EmployeeRecordDto;
import com.example.springbootEmployees.entity.EmployeeEntity;
import com.example.springbootEmployees.mapper.Employee_Mapper;
import com.example.springbootEmployees.repository.Employee_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class Employee_Service_impl implements Employee_Service {

    @Autowired
    private Employee_Mapper employee_mapper;

    @Autowired
    private Employee_repository employeeRepository;


    @Override
    public EmployeeEntity create_Employee(EmployeeRecordDto employeeRecordDto) {
        EmployeeEntity employeeEntity = employee_mapper.mapToEmployeeEntity(employeeRecordDto);
       return employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> listAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

    }

    @Override
    public EmployeeEntity updateEmployeeById(Long id, EmployeeRecordDto employeeRecordDto) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        employee_mapper.mapToEntity(employeeRecordDto,employeeEntity);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity deleteEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        employeeRepository.delete(employeeEntity);
        return employeeEntity;
    }
}
