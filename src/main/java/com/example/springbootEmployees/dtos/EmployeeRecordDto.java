package com.example.springbootEmployees.dtos;

import com.example.springbootEmployees.entity.Civil_status;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EmployeeRecordDto(
        @NotBlank(message = "The camp must not be blank.")
        String name,
        @NotBlank(message = "The camp must not be blank.")
        String surname,
        @NotNull(message = "The camp must not be null.")
        LocalDate dateOfBirth,
        @NotNull(message = "The camp must not be blank.")
        Civil_status civilStatus,
        @NotBlank(message = "The camp must not be blank.")
        String idDocument,
        @NotBlank(message = "The camp must not be blank.")
        String nuit,
        @NotBlank(message = "The camp must not be blank.")
        String address,
        @NotNull(message = "The camp must not be null and must contain 9 numbers.")
        @Size(min = 9)
        String phoneNumber,
        @NotBlank(message = "The camp must not be blank, nor null, and must be the email format.")
        @NotNull
        @Email
        String email ) {
}

