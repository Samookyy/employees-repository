package com.example.springbootEmployees.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String civilStatus;
    private String idDocument;
    private String address;
    private String phoneNumber;
    private String email;
}
