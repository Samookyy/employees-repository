package com.example.springbootEmployees.dtos;

import com.example.springbootEmployees.entity.Civil_status;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EmployeeRecordDto(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotNull
        LocalDate dateOfBirth,
        @NotBlank
        Civil_status civilStatus,
        @NotBlank
        String idDocument,
        @NotBlank
        String nuit,
        @NotBlank
        String address,
        @NotNull
        @Size(min = 9)
        String phoneNumber,
        @NotBlank
        @NotNull
        @Email
        String email ) {
}

