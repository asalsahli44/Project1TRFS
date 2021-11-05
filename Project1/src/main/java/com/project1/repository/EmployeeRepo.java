package com.project1.repository;

import com.project1.models.Employee;

import java.util.List;

public interface EmployeeRepo {
    public Employee getEmployee(int id);
    public List<Employee> getAllEmployees();
    public Employee addEmployee(Employee e);
    public Employee updateEmployee(Employee change);
    public Employee deleteEmployee(int id);
    public Employee getEmployeeLogin(String username, String password);
}
