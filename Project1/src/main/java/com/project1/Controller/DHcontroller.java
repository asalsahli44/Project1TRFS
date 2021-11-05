package com.project1.Controller;

import com.google.gson.Gson;
import com.project1.Services.DepartmentHeadService;
import com.project1.Services.ReinFormService;
import com.project1.models.ReinForm;
import com.project1.models.departmenthead;
import io.javalin.http.Handler;

import java.util.List;

public class DHcontroller {
}

//    DepartmentHeadService ds;
//
//    Gson gson = new Gson();
//
//    public DHcontroller(DepartmentHeadService ds){
//        this.ds = ds;
//    }
//    public Handler getAllDep = (ctx) -> {
//        List<departmenthead>DHlist = ds.getAllDepartmentHeads();
//
//        ctx.result(gson.toJson(DHlist));
//    };
//
//    public Handler getDep = (context) -> {
//        String input = context.pathParam("id");
//        int id;
//
//        try{
//            id = Integer.parseInt(input);
//        }catch (NumberFormatException e) {
//            id = -1;
//        }
//        departmenthead m = ds.getDepartmentHead(id);
//        if(m != null){
//            context.result(gson.toJson(m));
//        }else {
//            context.status(400);
//        }
//    };
////
////    public Handler addDep = (context) -> {
////        departmenthead m = gson.fromJson(context.body(), departmenthead.class);
////
////        m = ds.addDepartmentHead(m);
////
////        context.result((m != null) ? gson.toJson(m) : "{}");
////    };
////
////
////
////    public Handler deleteDep = (ctx) -> {
////        int id = Integer.parseInt(ctx.pathParam("id"));
////
////        departmenthead m = ds.deleteDepartmentHead(id);
////        ctx.result((m!= null) ? gson.toJson(m) : "{}");
////    };
////}
