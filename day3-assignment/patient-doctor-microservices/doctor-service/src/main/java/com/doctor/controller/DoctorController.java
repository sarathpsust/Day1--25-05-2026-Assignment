package com.doctor.controller;

import com.doctor.dto.DoctorDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @GetMapping("/{id}")
    public DoctorDto getDoctorById(@PathVariable Long id) {

        return new DoctorDto(
                201,
                "Dr. Rajesh",
                "Cardiologist"
        );
    }
}
