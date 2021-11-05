package com.project1.repository;

import com.project1.models.Employee;
import com.project1.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeHBRepo implements EmployeeRepo {

    @Override
    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Employee E = null;

        try{
              E = session.get(Employee.class, id);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return E;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSession();

        List<Employee> employees = null;

        try {
            employees = session.createQuery("From Employee").list();
        }catch(HibernateException e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        return employees;
    }

    @Override
    public Employee addEmployee(Employee e) {

        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();

            e.setId((int)session.save(e));
            session.getTransaction().rollback();
        }catch (HibernateException a){
            a.printStackTrace();
        }
        finally {
            session.close();
        }


        return e;
    }

    @Override
    public Employee updateEmployee(Employee change) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            return null;
        }finally {
            session.close();
        }
        return change;
    }

    @Override
    public Employee deleteEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        Employee E = null;
        try{
            tx = session.beginTransaction();
            E = session.get(Employee.class, id);
            session.delete(E);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx != null) tx.rollback();
            E = null;

        }finally {
            session.close();
        }
        return E;
    }

    @Override
    public Employee getEmployeeLogin(String username, String password) {
        Session session = HibernateUtil.getSession();
        Employee E = null;

        String hql = "FROM Employee WHERE username = :username AND password = :e_password";


        try{
            Query q = session.createQuery(hql);
            q.setParameter("username",username);
            q.setParameter("e_password",password);

            List list = q.list();
            if(list.size() > 0)
            {
                E = (Employee)list.get(0);
            }
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return E;

    }


}
