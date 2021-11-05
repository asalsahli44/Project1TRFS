package com.project1.Controller;

import com.google.gson.Gson;
import com.project1.Services.ReinFormService;
//import com.project1.logger.myLogger;
//import com.project1.logger.MyLogger;
import com.project1.models.Employee;
import com.project1.models.ReinForm;
import com.project1.repository.EmployeeRepo;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class ReinController {
    ReinFormService re;


    Gson gson = new Gson();

    public ReinController(ReinFormService re) {
        this.re = re;
    }


    public Handler getAllGF = (ctx) -> {
        List<ReinForm> RList = re.getAllForms();

        ctx.result(gson.toJson(RList));
    };







    public Handler getByE = (context) -> {
        String input = context.pathParam("id");
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        List<ReinForm> RList = re.getAllFormsbyE(id);

        context.result(gson.toJson(RList));

    };


    public Handler getFormById = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        ReinForm m = re.getReinForm(id);
        if (m != null) {

            context.status(200);
            context.result(gson.toJson(m));
        } else {

            context.status(400);
        }
    };


    public Handler addForm = (context) -> {
        ReinForm m = gson.fromJson(context.body(), ReinForm.class);

        m = re.addReinForm(m);

        context.result((m != null) ? gson.toJson(m) : "{}");
    };

    public Handler updateForm = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        ReinForm m = gson.fromJson(context.body(), ReinForm.class);

        //Should probably validate
        m.setForm_id(id);

        m = re.updateReinForm(m);
        if (m != null) {
            context.status(200);

            context.result(gson.toJson(m));
        } else {

            context.status(404);
        }
    };


        public Handler deleteForm = (ctx) -> {
            int id = Integer.parseInt(ctx.pathParam("id"));

            ReinForm m = re.deleteReinForm(id);
            if (m != null) {
                ctx.status(200);

                ctx.result(gson.toJson(m));
            } else {

                ctx.status(404);
            }
        };

}
