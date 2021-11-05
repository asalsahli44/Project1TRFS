package com.project1.unitServiceTester;

import com.project1.Services.DepartmentService;
import com.project1.Services.DepartmentServiceImpl;
import com.project1.Services.EmployeeService;
import com.project1.Services.EmployeeServiceImpl;
import com.project1.models.Employee;
import com.project1.models.department;
import com.project1.repository.EmployeeHBRepo;
import com.project1.repository.EmployeeRepo;
import com.project1.repository.departmentHBRepo;
import com.project1.repository.departmentRepo;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

public class EmployeeTest {
    EmployeeRepo dr = new EmployeeHBRepo();
    EmployeeService ds = new EmployeeServiceImpl(dr);

    department e = new department("test");
    Employee d = new Employee("ryan",1,"ryan@gmail.com", true, e, "ryan", "password");

    @Test
    public void addEmployee(){
        d = ds.addEmployee(d);
    }

    @Test
    public void getEmployee(){
        d = ds.getEmployee(1);
        assertNotNull(d);
    }

    @Test
    public void deleteEmployee(){
        d = ds.getEmployee(d.getId());
        assertNull(d);
    }

    @Test
    public void getAllEmployee()
    {
        List<Employee> dList = new ArrayList<>();
        dList = ds.getAllEmployees();
        assertNotNull(dList);
    }

    @Test
    public void updateEmployee()
    {
        Employee s = new Employee();
        s.setName("Nick");
        s.setSupervisor_id(1);
        s.setEmail("nick@gmail.com");
        s.setBenco(false);
        department f = new department(2, "test2");
        s.setDepartment_id(f);
        s.setUsername("nick");
        s.setPassword("newPassword");
        s = dr.updateEmployee(s);
        assertNotEquals(s,d);

    }
}
