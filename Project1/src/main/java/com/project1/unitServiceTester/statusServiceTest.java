package com.project1.unitServiceTester;

import com.project1.Services.StatusService;
import com.project1.Services.StatusServiceImpl;
import com.project1.models.status;
import com.project1.repository.StatusRepoHBImpl;
import com.project1.repository.statusRepo;
import org.testng.annotations.Test;

//import java.util.ArrayList;
//import java.util.List;
//
//import static org.testng.Assert.assertNotEquals;
//import static org.testng.AssertJUnit.assertNotNull;
//import static org.testng.AssertJUnit.assertNull;
//
//public class statusServiceTest {
//    statusRepo d = new StatusRepoHBImpl();
//    StatusService ds = new StatusServiceImpl(d);
//
//    status dr = new status(1,"approved");
//
//    @Test
//    public void addStatus(){
//        dr = ds.addStatus(dr);
//    }
//
//    @Test
//    public void getStatus(){
//        dr = ds.getStatus(1);
//        assertNotNull(dr);
//    }
//
//    @Test
//    public void deleteDeparment(){
//        dr = ds.getStatus(dr.getStatus_id());
//        assertNull(dr);
//    }
//
//    @Test
//    public void getStatuses()
//    {
//        List<status> dList = new ArrayList<>();
//        dList = ds.getAllStatus();
//        assertNotNull(dList);
//    }
//
//    @Test
//    public void updateStatus()
//    {
//        status s = new status();
//        s.setStatus_id(1);
//        s.setStatus_name("New Status");
//        s = d.updateStatus(s);
//        assertNotEquals(s,dr);
//
//    }
//}
