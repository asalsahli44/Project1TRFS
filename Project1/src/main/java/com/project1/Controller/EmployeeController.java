package com.project1.Controller;

import com.google.gson.Gson;

import com.project1.Services.EmployeeService;
//import com.project1.logger.myLogger;
import com.project1.logger.MyLogger;
import com.project1.models.Employee;
import com.project1.models.status;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeController {
    EmployeeService es;

    Gson gson = new Gson();

    public EmployeeController(EmployeeService es){
        this.es = es;
    }
    public Handler getAllEmployees = (ctx) -> {
        List<Employee> EList =es.getAllEmployees();

        ctx.result(gson.toJson(EList));
    };

    public Handler getEmployeeById = (context) -> {
        String input = context.pathParam("id");
        int id;

        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e) {
            id = -1;
        }
        Employee m = es.getEmployee(id);
        if(m != null){
            context.status(200);
            MyLogger.logger.info("Employee gotten successfully");
            context.result(gson.toJson(m));
        }else {
            MyLogger.logger.info("Employee not gotten successfully");
            context.status(400);
        }
    };






    public Handler addEmployee = (context) -> {
        Employee m = gson.fromJson(context.body(), Employee.class);

        m = es.addEmployee(m);

        if(m != null) {
            context.result(gson.toJson(m));
            MyLogger.logger.info("employee created successfully");
            context.status(201);
        }
        else{
            MyLogger.logger.info("employee not created successfully");
            context.result("{}");
        }
    };

    public Handler updateEmployee = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Employee m = gson.fromJson(context.body(), Employee.class);

        //Should probably validate
        m.setId(id);


        m = es.updateEmployee(m);

        if(m != null) {
            context.result(gson.toJson(m));
            MyLogger.logger.info("Employee Updated");
            context.status(200);
        }
        else{
            context.status(404);
            MyLogger.logger.info("Employee not updated");
            context.result("{}");
        }


    };

    public Handler deleteEmployee = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        Employee m = es.deleteEmployee(id);
        if(m != null) {
            MyLogger.logger.info("Employee deleted successfully");
            ctx.result(gson.toJson(m));
            ctx.status(204);
        }
        else{
            MyLogger.logger.info("Employee delete unsuccessful");
            ctx.status(404);
        }
        ctx.result((m!= null) ? gson.toJson(m) : "{}");
    };

    public Handler login = (ctx) -> {
        String str = ctx.header("Authorization");
        String[] name = str.split(":", 2);
        Employee E = new Employee();
        E.setUsername(name[0]);
        E.setPassword(name[1]);
        Employee F = null;
        E = es.getEmployeeLogin(E.getUsername(),E.getPassword());

        if(E != null){
            ctx.status(200);
            MyLogger.logger.info("Login successful");
            ctx.result(gson.toJson(E));
        }else {
            ctx.status(205);
            MyLogger.logger.info("Login unsuccessful");
        }

    };

}
