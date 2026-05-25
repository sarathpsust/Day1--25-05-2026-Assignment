package org.streamprocessing;

public class Employee {

    private int id;

    private String name;

    private String department;

    private double salary;

    private boolean activeStatus;

    public Employee(int id, String name, String department, double salary, boolean activeStatus) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.activeStatus = activeStatus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean getActiveStatus() {
        return activeStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }
}
