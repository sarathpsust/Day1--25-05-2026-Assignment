package com.patient.dto;

import lombok.Data;

@Data
public class PatientResponseDto {

    private String patientName;
    private String doctorName;
    private String specialization;
}
