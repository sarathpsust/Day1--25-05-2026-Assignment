package com.patient.service;

import com.patient.dto.DoctorDto;
import com.patient.dto.PatientDto;
import com.patient.dto.PatientResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientService {

    private final RestTemplate restTemplate;

    public PatientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PatientResponseDto getPatient(Long patientId) {

        PatientDto patient = new PatientDto(
                1,
                "Amit",
                201
        );

        String url = "http://localhost:8081/doctors/" + patient.getDoctorId();

        DoctorDto doctor = restTemplate.getForObject(
                        url,
                        DoctorDto.class
                );

        PatientResponseDto response = new PatientResponseDto();
        response.setPatientName(patient.getPatientName());
        response.setDoctorName(doctor.getDoctorName());
        response.setSpecialization(doctor.getSpecialization());

        return response;
    }
}
