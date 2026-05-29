package com.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {

    private Integer employeeId;
    private String employeeName;
    private String departmentName;
    private String location;
    private String managerName;
}
