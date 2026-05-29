package com.department.controller;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Long id) {

        return new DepartmentDto(
                101,
                "Engineering",
                "Bangalore",
                "Amit"
        );
    }
}
