package com.project1.App;

import com.project1.Controller.*;
import com.project1.Services.*;
import com.project1.repository.*;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        //establish the route/endpoint that javalin will manage
        establishedRoutes(app);

        EmployeeRepo er = new EmployeeHBRepo();
        EmployeeService es = new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);
        app.get("/login",ec.login);

        //er.getEmployeeLogin("ahmed","ase");

        //run javalin
        app.start(7000);


    }
    private static void establishedRoutes(Javalin app) {

        //tell javalin which routes or endpoints java will manage
        app.get("/hello", (ctx) -> ctx.result("Hello World!") );
        app.get("/", (ctx) -> ctx.result("Welcome to our movie app"));






//
        addStatusRoutes(app);
//
        addGfRoute(app);
//
          addDepartmentRoute(app);
//
        addEmployeeRoute(app);
//
        addReinFormRoute(app);


    }

    private static void addReinFormRoute(Javalin app) {
        ReinFormRepo rr = new ReinFormHBRepo();
        ReinFormService rs = new ReinFormServiceImpl(rr);
        ReinController rc = new ReinController(rs);
        app.get("/reinForm/:id",rc.getFormById);
        app.get("/reinForm",rc.getAllGF);
        app.put("/reinForm/:id",rc.updateForm);
        app.post("/reinForm",rc.addForm);
        app.delete("/reinForm/:id",rc.deleteForm);
        app.get("/reinFormE/:id",rc.getByE);
    }

    private static void addEmployeeRoute(Javalin app) {
        EmployeeRepo er = new EmployeeHBRepo();
        EmployeeService es = new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);
        app.get("/employee/:id", ec.getEmployeeById);
        app.get("/employee", ec.getAllEmployees);
        app.post("/employee", ec.addEmployee);
        app.put("/employee/:id", ec.updateEmployee);
        app.delete("/employee/:id", ec.deleteEmployee);
    }

    private static void addDepartmentRoute(Javalin app) {
        departmentRepo dr = new departmentHBRepo();
        DepartmentService ds = new DepartmentServiceImpl(dr);
        DepartmentController dc = new DepartmentController(ds);
        app.get("/department/:id",dc.getDbyId);
        app.get("/department",dc.getAllD);
        app.post("/department",dc.addDepartment);
        app.put("/department/:id",dc.udpateD);
        app.delete("/department/:id",dc.deleteGF);
    }

    private static void addGfRoute(Javalin app) {
        gradingFormatRepo gr = new GradingFormatHBRepo();
        GradingFormatService gs = new GradingFormatServiceImpl(gr);
        gradingFormatContoller gc = new gradingFormatContoller(gs);
        app.get("/gradingFormat", gc.getAllGF);
        app.get("/gradingFormat/:id", gc.getGFbyId);
        app.post("/gradingFormat", gc.addGF);
        app.put("/gradingFormat/:id", gc.updateGF);
        app.delete("/gradingFormat/:id", gc.deleteGF);
    }

    private static void addStatusRoutes(Javalin app) {
        statusRepo sr = new StatusRepoHBImpl();
        StatusService ss = new StatusServiceImpl(sr);
        StatusController sc = new StatusController(ss);


        app.get("/status", sc.getAllStatuses);
        app.get("/status/:id", sc.statusID);
        app.post("/status", sc.addStatus);
        app.put("/status/:id", sc.updateStatus);
        app.delete("status/:id", sc.deleteStatus);
        app.patch("/status/:id/rank/:id2", sc.requestStatus);
    }

}
