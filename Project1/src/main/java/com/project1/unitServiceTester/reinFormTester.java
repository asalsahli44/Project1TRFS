package com.project1.unitServiceTester;

import com.project1.Services.ReinFormService;
import com.project1.Services.ReinFormServiceImpl;
import com.project1.models.*;
import com.project1.repository.ReinFormHBRepo;
import com.project1.repository.ReinFormRepo;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

public class reinFormTester {
    ReinFormRepo dr = new ReinFormHBRepo();
    ReinFormService ds = new ReinFormServiceImpl(dr);

    department q = new department("test");
    status s = new status();
    gradingFormat g = new gradingFormat("letter grade");
    Employee f = new Employee("ryan",1,"ryan@gmail.com", true, q, "ryan", "password");
    ReinForm d = new ReinForm(12, "new address", "need approve", 1600, "60", 2, g,s, f);



    @Test
    public void addForm(){
        d = ds.addReinForm(d);
    }

    @Test
    public void getForm(){
        d = ds.getReinForm(1);
        assertNotNull(d);
    }

    @Test
    public void deleteForm(){
        d = ds.getReinForm(d.getForm_id());
        assertNull(d);
    }

    @Test
    public void getAllDepartments()
    {
        List<ReinForm> dList = new ArrayList<>();
        dList = ds.getAllForms();
        assertNotNull(dList);
    }

    @Test
    public void updateDepartment()
    {
        ReinForm s = new ReinForm();
        s.setDate(12);
        s.setLocation("canada");
        s.setDescription("new address");
        s.setCosts(1200);
        s.setGrade("A+");
        s.setEvent_type(3);
        status m = new status();
        s.setStat_id(m);
        gradingFormat g = new gradingFormat("letter grade");
        s.setGrade_format(g);
        Employee f = new Employee("winny",1,"winny@gmail.com", true, q, "winny", "password");
        s.setEmployee_id(f);
        s = dr.updateReinForm(s);
        assertNotEquals(s,d);

    }


}
