package com.lanou3g.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by dllo on 17/11/13.
 */
public class HibernateUtil {
    private static final SessionFactory SF;
    static {
        try {
            SF = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Hibernate配置文件错了");
        }
    }

    public static Session openSession(){
        Session session = SF.getCurrentSession();

        session.beginTransaction();
        return session;
    }

    public static void commit(){
        SF.getCurrentSession().getTransaction().commit();

    }
}
