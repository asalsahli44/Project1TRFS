package com.project1.Controller;

import com.google.gson.Gson;
import com.project1.Services.DepartmentService;

import com.project1.logger.MyLogger;
import com.project1.models.department;
import io.javalin.http.Handler;

import java.util.List;

public class DepartmentController {
    DepartmentService ds;

    Gson gson = new Gson();

    public DepartmentController(DepartmentService ds){
        this.ds = ds;
    }
    public Handler getAllD = (ctx) -> {
        List<department> dList =ds.getAllDepartments();
        MyLogger.logger.info("All departments gotten successfully");
        ctx.result(gson.toJson(dList));
    };

    public Handler getDbyId = (context) -> {
        String input = context.pathParam("id");
        int id;

        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e) {
            id = -1;
        }
        department m = ds.getDepartment(id);
        if(m != null){

            context.result(gson.toJson(m));
            MyLogger.logger.info("Department gotten successfully");
        }else {
            context.status(404);
        }
    };

    public Handler addDepartment = (context) -> {
        department m = gson.fromJson(context.body(), department.class);

        m = ds.addDepartment(m);

        if(m != null){

            context.status(201);
            MyLogger.logger.info("Department added");
            context.result(gson.toJson(m));
        }else {
            context.status(404);
        }
    };

    public Handler udpateD = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        department m = gson.fromJson(context.body(), department.class);

        //Should probably validate
        m.setDepartment_id(id);

        m = ds.updateDepartment(m);

        if(m != null){

            context.status(200);
            context.result(gson.toJson(m));
            MyLogger.logger.info(("Department updated"));
        }else {
            context.status(404);
        }
    };

    public Handler deleteGF = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        department m = ds.deleteDepartment(id);
        if(m != null){

            ctx.status(204);
            ctx.result(gson.toJson(m));
            MyLogger.logger.info("Department deleted");
        }else {
            ctx.status(404);
        }
    };


}
