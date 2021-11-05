package com.project1.repository;

import com.project1.models.department;
import com.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class departmentHBRepo implements departmentRepo{


    @Override
    public department getDepartment(int id) {
        Session session = HibernateUtil.getSession();
        department a = null;

        try{
            a = session.get(department.class, id);
        }catch (HibernateException e){

        }finally {
            session.close();
        }
        return a;
    }

    @Override
    public department deleteDepartment(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        department a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(department.class, id);
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
    public department updateDepartment(department change) {
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
    public List<department> getAllDepartments() {
        Session session = HibernateUtil.getSession();
        List<department> departments = null;

        try{
            departments = session.createQuery("From department").list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return departments;
    }

    @Override
    public department addDepartment(department d) {

        Session session = HibernateUtil.getSession();

        try{
            session.beginTransaction();

            d.setDepartment_id((int)session.save(d));

            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return d;
    }
}
