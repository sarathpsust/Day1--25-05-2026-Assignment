package com.employee_service.service;

import com.employee_service.dto.DepartmentDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.dto.EmployeeResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    private final RestTemplate restTemplate;

    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmployeeResponseDto getEmployee(Long employeeId) {

        EmployeeDto employee = new EmployeeDto(
                1,
                "Rahul",
                101
        );

        String url = "http://localhost:8081/departments/" + employee.getDepartmentId();

        DepartmentDto department =
                restTemplate.getForObject(
                        url,
                        DepartmentDto.class
                );

        EmployeeResponseDto response = new EmployeeResponseDto();

        response.setEmployeeId(employee.getEmployeeId());
        response.setEmployeeName(employee.getEmployeeName());
        response.setDepartmentName(
                department.getDepartmentName());
        response.setLocation(
                department.getLocation());
        response.setManagerName(
                department.getManagerName());

        return response;
    }
}
