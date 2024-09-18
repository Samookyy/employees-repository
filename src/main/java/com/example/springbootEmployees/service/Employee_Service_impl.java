package com.example.springbootEmployees.service;

import com.example.springbootEmployees.dtos.EmployeeRecordDto;
import com.example.springbootEmployees.entity.EmployeeEntity;
import com.example.springbootEmployees.repository.Employee_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.List;

@Service
public class Employee_Service_impl implements Employee_Service {

    @Autowired
    private Employee_repository employeeRepository;


    @Override
    public EmployeeEntity create_Employee(EmployeeRecordDto employeeRecordDto) {
        var employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeRecordDto.name());
        employeeEntity.setSurname(employeeRecordDto.surname());
        employeeEntity.setDateOfBirth(employeeRecordDto.dateOfBirth());
        employeeEntity.setCivilStatus(employeeRecordDto.civilStatus());
        employeeEntity.setIdDocument(employeeRecordDto.idDocument());
        employeeEntity.setNuit(employeeRecordDto.nuit());
        employeeEntity.setAddress(employeeRecordDto.address());
        employeeEntity.setPhoneNumber(employeeRecordDto.phoneNumber());
        employeeEntity.setEmail(employeeRecordDto.email());

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

        employeeEntity.setName(employeeRecordDto.name());
        employeeEntity.setSurname(employeeRecordDto.surname());
        employeeEntity.setDateOfBirth(employeeRecordDto.dateOfBirth());
        employeeEntity.setCivilStatus(employeeRecordDto.civilStatus());
        employeeEntity.setIdDocument(employeeRecordDto.idDocument());
        employeeEntity.setNuit(employeeRecordDto.nuit());
        employeeEntity.setAddress(employeeRecordDto.address());
        employeeEntity.setPhoneNumber(employeeRecordDto.phoneNumber());
        employeeEntity.setEmail(employeeRecordDto.email());

        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        employeeRepository.delete(employeeEntity);
    }
}
