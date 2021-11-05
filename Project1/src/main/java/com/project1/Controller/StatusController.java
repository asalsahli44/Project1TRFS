package com.project1.Controller;

import com.google.gson.Gson;
import com.project1.Services.StatusService;
import com.project1.models.status;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class StatusController {
    StatusService ss;

    Gson gson = new Gson();

    public StatusController(StatusService ss) {
        this.ss = ss;
    }

    public Handler getAllStatuses = (ctx) -> {
        List<status> statusList = ss.getAllStatus();
        //ctx.result(movieList.toString());
        ctx.result(gson.toJson(statusList));
    };

    public Handler statusID = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        status m = ss.getStatus(id);
        if (m != null) {

            context.result(gson.toJson(m));
        } else {
            context.status(400);
        }
    };

    public Handler addStatus = (context) -> {
        status m = gson.fromJson(context.body(), status.class);

        m = ss.addStatus(m);

        if (m != null) {
            context.result(gson.toJson(m));
        } else {
            context.status(400);
        }
    };

    public Handler updateStatus = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        status m = gson.fromJson(context.body(), status.class);

        //Should probably validate
        m.setStatus_id(id);

        m = ss.updateStatus(m);
        if (m != null) {
            context.result(gson.toJson(m));
        } else {
            context.status(400);
        }
    };

    public Handler deleteStatus = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        status m = ss.deleteStatus(id);
        if (m != null) {
            ctx.result(gson.toJson(m));
        } else {
            ctx.status(400);
        }
    };


    public Handler requestStatus = (context) ->
    {
        int statusID = Integer.parseInt(context.pathParam("id"));
        int rank = Integer.parseInt(context.pathParam("id2"));
        System.out.println(statusID + " " + rank);
        status temp = new status();
        temp.setStatus_id(statusID);
        temp = ss.getStatus(statusID);

        if (rank == 3) {
            temp.setSupApprove(true);
        }
        if (rank == 2) {
            temp.setDepHeadApprove(true);
        }
        if (rank == 1) {
            temp.setBencoApprove(true);
        }
        System.out.println(temp.toString());


        List<status> statusList = new ArrayList<status>();
        statusList = ss.getAllStatus();
        List<status> requestList = ss.getAllStatus();

        System.out.println("before look " + (statusID));

        for (status c : statusList) {
            System.out.println(c + "before look2 " + (temp));

            System.out.println(ss.getStatus(c.getStatus_id()));
            {
                System.out.println(c + "before look#3 " + (temp));
                System.out.println(ss.getStatus((statusID)));

                ss.updateStatus(temp);

            }
        }

    };

}
