package com.project1.repository;

import com.project1.models.department;

import java.util.List;

public interface departmentRepo {
    public department getDepartment(int id);
    public department deleteDepartment(int id);
    public department updateDepartment(department change);
    public List<department> getAllDepartments();
    public department addDepartment(department d);
}
