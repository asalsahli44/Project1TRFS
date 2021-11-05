package com.project1.repository;

import com.project1.models.Employee;
import com.project1.models.ReinForm;
import com.project1.models.gradingFormat;
import com.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class ReinFormHBRepo implements ReinFormRepo{
    @Override
    public ReinForm getReinForm(int id) {
        Session session = HibernateUtil.getSession();
        ReinForm a = null;

        try{
            a = session.get(ReinForm.class, id);
        }catch (HibernateException e){

        }finally {
            session.close();
        }

        return a;
    }


    @Override
    public ReinForm addReinForm(ReinForm a) {
        Session session = HibernateUtil.getSession();

        try{
            session.beginTransaction();

            a.setForm_id((int)session.save(a));

            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return a;
    }

    @Override
    public ReinForm deleteReinForm(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        ReinForm a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(ReinForm.class, id);
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
    public ReinForm updateReinForm(ReinForm change) {

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
    public List<ReinForm> getAllForms() {
        Session session = HibernateUtil.getSession();
        List<ReinForm> reinForms = null;
        try {
            reinForms = session.createQuery("FROM ReinForm").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return reinForms;
    }

//    @Override
//    public List<ReinForm> getAllFormsbyE(Employee id) {
//        Session session = HibernateUtil.getSession();
//        List<ReinForm> results = null;
//
//        try{
//            String hql = "FROM ReinForm WHERE employee_id = :id";
//            Query q = session.createQuery(hql);
//            q.setParameter("id", id);
//            results = q.list();
//
//        }catch (HibernateException e){
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//
//
//        return results;
//    }


//    @Override
//    public ReinForm getAllFormsbyE(Employee id) {
//        Session session = HibernateUtil.getSession();
//        ReinForm a = null;
//
//        try{
//            a = session.get(ReinForm.class, (Serializable) id);
//        }catch (HibernateException e){
//
//        }finally {
//            session.close();
//        }
//
//        return a;
//    }
}



