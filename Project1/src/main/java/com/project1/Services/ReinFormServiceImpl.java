package com.project1.Services;

import com.project1.models.Employee;
import com.project1.models.ReinForm;
import com.project1.repository.*;

import java.util.ArrayList;
import java.util.List;




public class ReinFormServiceImpl implements ReinFormService{

    ReinFormRepo rf;
    EmployeeRepo ef;
    statusRepo s;
    depHeadRepo d;
    departmentRepo f;



//    public ReinFormServiceImpl(ReinFormRepo rf){
//        this.rf = rf;
//    }
    public ReinFormServiceImpl(ReinFormRepo rf) {
        this.rf = rf;
//        this.ef = ef;
//        this.s = s;
    }



    @Override
    public List<ReinForm> approveForms(int id){
//        List<ReinForm> R = rf.getAllForms();
//        List<ReinForm> newForms = new ArrayList<>();
//
//        for(ReinForm r : R){
//            if(r.getEmployee_id().getSupervisor_id() == id && )
//        }
//














        // if he is benco
            // change status to approved
        // if he is a department head
            // change status to needs approval by department
        // if he is a direct supervisor
            // change status to needs department head approval
//        List<ReinForm> R = rf.getAllForms();
//        List<ReinForm> newForms = new ArrayList<>();
//        for(ReinForm a : R){
//            if (a.getEmployee_id().isBenco() == true) {
//                newForms.add(a);
//            } else if (a.getEmployee_id().getDepartment_id().getDepartment_id() == ) {
//                newForms.add(a);
//            } else if (a.getEmployee_id().getSupervisor_id() == id) {
//                newForms.add(a);
//            }
//        }
//    }
//
//
//
//        }
























//
//                ReinForm r = rf.getReinForm(formID);
//                Employee f = ef.getEmployee(EmployeeId);
//
//
//                Employee owner = r.getEmployee_id();
//                if(f.equals(owner)) {
//                int a = r.getStat_id().getStatus_id();
//                switch (a){
//                    case 1: {
//                        if (owner.getSupervisor_id() == f.getId()){
//                            rf.updateReinForm(r).setStat_id(s);
//
//
//                        }
//                    case 2:
//                    case 3:
//                    case 4:
//                    case 5:
//                    case 6:
//                    case 7:
//                    case 8:
//                    case 9:
//                    case 10:
//                    case 11:
//                    case 12:
//                    case 13:
//                    case 14:
//                    case 15:
//                    case 16:
//                    case 17:
//
//
//                }





        return null;
    }






//
//       public List<ReinForm> approveForm(int id){
////         get forms for the employee
//           List<ReinForm> R = rf.getAllForms();
//           List<ReinForm> newR = new ArrayList<>();
//           for(ReinForm a : R) {
////           //System.out.println(R);
//               if (a.getEmployee_id().isBenco() == true) {
//                   newR.add(a);
//               }
//           }
////
////       }
//       for(ReinForm b : newR){
//           if(b.getEmployee_id().getSupervisor_id() == id){
//               if(b.getEmployee_id().getDepartment_id().== id){
//                   if(b.getEmployee_id().isBenco() == true)
//                   {
//                       b.getStat_id().setStatus_id(1);
//
//                   }
//               }
//           }
//       }
//        // check if the employee is a b
//        // check if the employee is a department head
//       // check if the employee is a benenfits coordinator
//
//        return null;
//   }






    @Override
    public List<ReinForm> getAllFormsbyE(int id) {
        // get all the forms
        //
        // create an empty list
        // if the employee id is the one i need i insert it into the list
        List<ReinForm> R = rf.getAllForms();
        List<ReinForm> newR = new ArrayList<>();
        for(ReinForm a : R){
            //System.out.println(R);
            if(a.getEmployee_id().getId() == id){
                newR.add(a);
            }

        }

        return newR;
    }




    @Override
    public ReinForm getReinForm(int id) {
        return rf.getReinForm(id);
    }

    @Override
    public ReinForm addReinForm(ReinForm RF) {
        return rf.addReinForm(RF);
    }

    @Override
    public ReinForm deleteReinForm(int id) {
        return rf.deleteReinForm(id);
    }

    @Override
    public ReinForm updateReinForm(ReinForm change) {
        return rf.updateReinForm(change);
    }

    @Override
    public List<ReinForm> getAllForms() {
        return rf.getAllForms();
    }



}
