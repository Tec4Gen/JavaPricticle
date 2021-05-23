package com.ssu.archive.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.ssu.archive.entity.*;
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AbstractPrintedProducts.class);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Newspaper.class);
                configuration.addAnnotatedClass(Patent.class);
                configuration.addAnnotatedClass(UserAccount.class);
                configuration.addAnnotatedClass(Article.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            }
            catch (Exception e) {
                throw new HibernateException("Exception: " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}