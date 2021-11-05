package com.project1.repository;

import com.project1.models.status;
import com.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusRepoHBImpl implements statusRepo{
    @Override
    public status getStatus(int id) {
        Session session = HibernateUtil.getSession();
        status a = null;

        try{
            a = session.get(status.class, id);
        }catch (HibernateException e){

        }finally {
            session.close();
        }

        return a;
    }

    @Override
    public status deleteStatus(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        status a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(status.class, id);
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
    public status addStatus(status a) {
        Session session = HibernateUtil.getSession();

        try{
            session.beginTransaction();

            a.setStatus_id((int)session.save(a));

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
    public status updateStatus(status change) {
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
    public List<status> getAllStatus() {
        Session session = HibernateUtil.getSession();
        List<status> s = null;

        try {
            s = session.createQuery("FROM status").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return s;
    }
    }

