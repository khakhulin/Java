package com.netcracker.hibernateForCornar.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by Taras on 24.10.2016.
 */
public class HibernateSessionFactory {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addResource("UsersEntity.hbm.xml");
        final ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        System.out.println("Hibernate Java Config serviceRegistry created");
        try {
            sessionFactory = configuration.buildSessionFactory(registry);
        }
        catch (HibernateException e){
            StandardServiceRegistryBuilder.destroy(registry);
            throw (new ExceptionInInitializerError("Initial Session Factory" + e.getStackTrace()));
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
