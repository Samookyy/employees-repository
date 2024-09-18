package com.example.springbootEmployees.repository;

import com.example.springbootEmployees.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_repository extends JpaRepository<EmployeeEntity, Long>  {
}
