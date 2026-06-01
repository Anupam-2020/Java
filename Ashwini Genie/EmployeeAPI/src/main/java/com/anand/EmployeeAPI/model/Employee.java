package com.anand.EmployeeAPI.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.salary = salary;
    }
}
