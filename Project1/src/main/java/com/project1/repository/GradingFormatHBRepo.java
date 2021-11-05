package com.project1.repository;

import com.project1.models.gradingFormat;
import com.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GradingFormatHBRepo implements gradingFormatRepo{
    @Override
    public gradingFormat getGradingFormat(int id) {
        Session session = HibernateUtil.getSession();
        gradingFormat a = null;

        try{
            a = session.get(gradingFormat.class, id);
        }catch (HibernateException e){

        }finally {
            session.close();
        }

        return a;
    }

    @Override
    public gradingFormat addGradingFormat(gradingFormat GF) {
        Session session = HibernateUtil.getSession();

        try{
            session.beginTransaction();

            GF.setGrade_id((int)session.save(GF));

            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return GF;
    }

    @Override
    public gradingFormat deleteGradingFormat(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        gradingFormat a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(gradingFormat.class, id);
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
    public gradingFormat updateGradingFormat(gradingFormat change) {
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
    public List<gradingFormat> getAllFormats() {
        Session session = HibernateUtil.getSession();
        List<gradingFormat> gradingFormats = null;
        try {
            gradingFormats = session.createQuery("FROM gradingFormat").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return gradingFormats;
    }
}
