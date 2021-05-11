package com.ssu.archive.PL;

import  com.ssu.archive.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Temp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.ssu.archive");
        EntityManager em = entityManagerFactory.createEntityManager();

        User client = new User();
        client.setFirstName("Boy");
        client.setLastName("Next door");
        client.setLogin("123");
        client.setHashPassword(new byte[] {1,4,3});

        em.getTransaction().begin();

        em.persist(client);

        em.getTransaction().commit();

        em.close();
        entityManagerFactory.close();
    }
}
