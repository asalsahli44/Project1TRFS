package com.project1.unitServiceTester;

import com.project1.Services.DepartmentService;
import com.project1.Services.DepartmentServiceImpl;
import com.project1.Services.GradingFormatService;
import com.project1.Services.GradingFormatServiceImpl;
import com.project1.models.department;
import com.project1.models.gradingFormat;
import com.project1.repository.GradingFormatHBRepo;
import com.project1.repository.departmentHBRepo;
import com.project1.repository.departmentRepo;
import com.project1.repository.gradingFormatRepo;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

public class gradeFormatTester {
    gradingFormatRepo dr = new GradingFormatHBRepo();
    GradingFormatService ds = new GradingFormatServiceImpl(dr);

    gradingFormat d = new gradingFormat(5,"letter");

    @Test
    public void addGf(){
        d = ds.addGradingFormat(d);
    }

    @Test
    public void getGF(){
        d = ds.getGradingFormat(1);
        assertNotNull(d);
    }

    @Test
    public void deleteGF(){
        d = ds.getGradingFormat(d.getGrade_id());
        assertNull(d);
    }

    @Test
    public void getAllDepartments()
    {
        List<gradingFormat> dList = new ArrayList<>();
        dList = ds.getAllFormats();
        assertNotNull(dList);
    }

    @Test
    public void updateDepartment()
    {
        gradingFormat s = new gradingFormat();
        s.setGrade_id(1);
        s.setPresentation("letter");
        s = dr.updateGradingFormat(s);
        assertNotEquals(s,d);

    }
}
