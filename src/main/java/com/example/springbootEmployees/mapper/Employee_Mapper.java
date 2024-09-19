package com.example.springbootEmployees.mapper;

import com.example.springbootEmployees.dtos.EmployeeRecordDto;
import com.example.springbootEmployees.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class Employee_Mapper{

    public EmployeeEntity mapToEmployeeEntity(EmployeeRecordDto employeeRecordDto){
        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(employeeRecordDto.name());
        employeeEntity.setSurname(employeeRecordDto.surname());
        employeeEntity.setDateOfBirth(employeeRecordDto.dateOfBirth());
        employeeEntity.setCivilStatus(employeeRecordDto.civilStatus());
        employeeEntity.setIdDocument(employeeRecordDto.idDocument());
        employeeEntity.setNuit(employeeRecordDto.nuit());
        employeeEntity.setAddress(employeeRecordDto.address());
        employeeEntity.setPhoneNumber(employeeRecordDto.phoneNumber());
        employeeEntity.setEmail(employeeRecordDto.email());

        return employeeEntity;

    }

    public void mapToEntity(EmployeeRecordDto employeeRecordDto, EmployeeEntity employeeEntity){

        employeeEntity.setName(employeeRecordDto.name());
        employeeEntity.setSurname(employeeRecordDto.surname());
        employeeEntity.setDateOfBirth(employeeRecordDto.dateOfBirth());
        employeeEntity.setCivilStatus(employeeRecordDto.civilStatus());
        employeeEntity.setIdDocument(employeeRecordDto.idDocument());
        employeeEntity.setNuit(employeeRecordDto.nuit());
        employeeEntity.setAddress(employeeRecordDto.address());
        employeeEntity.setPhoneNumber(employeeRecordDto.phoneNumber());
        employeeEntity.setEmail(employeeRecordDto.email());

    }
}
