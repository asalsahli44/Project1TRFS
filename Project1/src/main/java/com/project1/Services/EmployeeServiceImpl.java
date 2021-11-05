package com.project1.Services;

import com.project1.models.Employee;
import com.project1.repository.EmployeeRepo;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepo er;

    public EmployeeServiceImpl(EmployeeRepo er) {this.er =er;
    }

    @Override
    public Employee getEmployee(int id) {
        return er.getEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return er.getAllEmployees();
    }

    @Override
    public Employee addEmployee(Employee e) {
        return er.addEmployee(e);
    }

    @Override
    public Employee updateEmployee(Employee change) {
        return er.updateEmployee(change);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return er.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeLogin(String username, String password) {
        return er.getEmployeeLogin(username,password);
    }
}
