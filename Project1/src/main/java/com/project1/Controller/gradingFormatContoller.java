package com.project1.Controller;

import com.google.gson.Gson;

import com.project1.Services.GradingFormatService;

import com.project1.models.gradingFormat;
import io.javalin.http.Handler;

import java.util.List;

public class gradingFormatContoller {
    GradingFormatService gf;

    Gson gson = new Gson();

    public gradingFormatContoller(GradingFormatService gf){
        this.gf = gf;
    }
    public Handler getAllGF = (ctx) -> {
        List<gradingFormat> gfList = gf.getAllFormats();


        ctx.result(gson.toJson(gfList));
    };

    public Handler getGFbyId = (context) -> {
        String input = context.pathParam("id");
        int id;

        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e) {
            id = -1;
        }
        gradingFormat m = gf.getGradingFormat(id);
        if(m != null){

            context.result(gson.toJson(m));
        }else {

            context.status(400);
        }
    };

    public Handler addGF = (context) -> {
        gradingFormat m = gson.fromJson(context.body(), gradingFormat.class);

        m = gf.addGradingFormat(m);

        context.result((m != null) ? gson.toJson(m) : "{}");
    };

    public Handler updateGF = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        gradingFormat m = gson.fromJson(context.body(), gradingFormat.class);

        //Should probably validate
        m.setGrade_id(id);

        m = gf.updateGradingFormat(m);

        context.result((m != null) ? gson.toJson(m) : "{}");
    };

    public Handler deleteGF = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        gradingFormat m = gf.deleteGradingFormat(id);
        ctx.result((m!= null) ? gson.toJson(m) : "{}");
    };





}
