package org.streamprocessing;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

    private static List<Employee> fetchEmployeesWithSalaryGreaterThan60K(List<Employee> list) {
        return list.stream()
                .filter(e -> e.getSalary() > 60000)
                .toList();
    }

    private static List<Employee> convertEmployeeNamesToUppercase(List<Employee> list) {
        return list.stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getName().toUpperCase(),
                        emp.getDepartment(),
                        emp.getSalary(),
                        emp.getActiveStatus()
                )).toList();
    }

    private static List<Employee> sortEmployeesBySalaryDesc(List<Employee> list) {
        return list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
    }

    private static Long findCountOfActiveEmployees(List<Employee> list) {
        return list.stream()
                .filter(Employee::getActiveStatus)
                .count();
    }

    private static Map<String, List<Employee>> groupEmployeesDeptWise(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
    }

    private static String findHighestSalaryEmployee(List<Employee> list) {
        return list.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .orElse("Nothing to return");
    }

    private static String findSecondHighestSalaryEmployee(List<Employee> list) {
        return list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .map(Employee::getName)
                .findFirst()
                .orElse("Nothing to return");
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Arun", "HR", 60000.0, true),
                new Employee(2, "Priya", "Finance", 75000.0, false),
                new Employee(3, "Karthik", "IT", 5000.0, true),
                new Employee(4, "Meena", "HR", 58000.0, true),
                new Employee(5, "Ravi", "Finance", 82000.0, false),
                new Employee(6, "Divya", "IT", 90000.0, true)
        );

        fetchEmployeesWithSalaryGreaterThan60K(employees).forEach(System.out::println);
        System.out.println();

        convertEmployeeNamesToUppercase(employees).forEach(System.out::println);
        System.out.println();

        sortEmployeesBySalaryDesc(employees).forEach(System.out::println);
        System.out.println();

        System.out.println("Count of all active employees: " + findCountOfActiveEmployees(employees));
        System.out.println();

        groupEmployeesDeptWise(employees).forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();

        System.out.println("The top highest salary employee is: " + findHighestSalaryEmployee(employees));
        System.out.println();

        System.out.println("The second highest salary employee is: " + findSecondHighestSalaryEmployee(employees));
        System.out.println();

    }
}
