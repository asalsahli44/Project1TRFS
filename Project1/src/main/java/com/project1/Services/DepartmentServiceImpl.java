package com.project1.Services;

import com.project1.models.department;
import com.project1.repository.departmentHBRepo;
import com.project1.repository.departmentRepo;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{

    departmentRepo dr;

    public DepartmentServiceImpl(departmentRepo dr) {
        this.dr = dr;
    }

    @Override
    public department getDepartment(int id) {
        return dr.getDepartment(id);
    }

    @Override
    public department deleteDepartment(int id) {
        return dr.deleteDepartment(id);
    }

    @Override
    public department updateDepartment(department change) {
        return dr.updateDepartment(change);
    }

    @Override
    public List<department> getAllDepartments() {
        return dr.getAllDepartments();
    }

    @Override
    public department addDepartment(department d) {
        return dr.addDepartment(d);
    }
}
