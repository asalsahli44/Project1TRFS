package com.project1.repository;
//package com.project1.repository;

import com.project1.models.department;
import com.project1.models.departmenthead;
import com.project1.repository.depHeadRepo;
import com.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentHeadHBRepo implements depHeadRepo {


    @Override
    public departmenthead getDepartmentHead(int id) {
        Session session = HibernateUtil.getSession();
        departmenthead a = null;

        try{
            a = session.get(departmenthead.class, id);
        }catch (HibernateException e){

        }finally {
            session.close();
        }

        return a;

    }



    @Override
    public departmenthead deleteDepartmentHead(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        departmenthead a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(departmenthead.class, id);
            session.delete(a);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            a = null;
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public departmenthead updateDepartmentHead(departmenthead change) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();

        }catch (HibernateException e){
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        }finally {
            session.close();
        }
        return change;
    }

    @Override
    public List<departmenthead> getAllDepartmentHeads() {
        Session session = HibernateUtil.getSession();
        List<departmenthead> dh = null;

        try{
            dh = session.createQuery("From departmenthead").list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return dh;
    }
}

