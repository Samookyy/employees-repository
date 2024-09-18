package com.example.springbootEmployees.service;

import com.example.springbootEmployees.dtos.EmployeeRecordDto;
import com.example.springbootEmployees.entity.EmployeeEntity;
import java.util.List;

public interface Employee_Service {

    EmployeeEntity create_Employee(EmployeeRecordDto employeeRecordDto);
    List<EmployeeEntity> listAllEmployees();
    EmployeeEntity getEmployeeById(Long id);
    EmployeeEntity updateEmployeeById(Long id, EmployeeRecordDto employeeRecordDto);
    void deleteEmployeeById(Long id);
}
