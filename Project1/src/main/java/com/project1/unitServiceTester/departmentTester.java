package com.project1.unitServiceTester;

import com.project1.Services.DepartmentService;
import com.project1.Services.DepartmentServiceImpl;
import com.project1.models.department;
import com.project1.repository.departmentHBRepo;
import com.project1.repository.departmentRepo;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

public class departmentTester {
    departmentRepo dr = new departmentHBRepo();
    DepartmentService ds = new DepartmentServiceImpl(dr);

    department d = new department(1,"math");

    @Test
    public void addDepartment(){
        d = ds.addDepartment(d);
    }

    @Test
    public void getDepartment(){
        d = ds.getDepartment(1);
        assertNotNull(d);
    }

    @Test
    public void deleteDeparment(){
        d = ds.getDepartment(d.getDepartment_id());
        assertNull(d);
    }

    @Test
    public void getAllDepartments()
    {
        List<department> dList = new ArrayList<>();
        dList = ds.getAllDepartments();
        assertNotNull(dList);
    }

    @Test
    public void updateDepartment()
    {
        department s = new department();
        s.setDepartment_name("New Status");
        s = dr.updateDepartment(s);
        assertNotEquals(s,d);

    }

}
