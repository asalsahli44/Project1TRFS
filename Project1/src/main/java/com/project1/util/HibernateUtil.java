package com.project1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //abstract a way creating our SessionFactory and the process of creating sessions
    // from that SessionFactory

    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

    public static Session getSession(){
        return sf.openSession();
    }
}
