package com.objis.demomaven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DemoJpa {

    public static void main(String[] args) {

        // 1 : Ouverture unité de travail JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        // 2 : Ouverture transaction
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        // 3 : Instanciation Objet métier
        Formation formation = new Formation("Hibernate");

        // 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
        em.persist(formation);

        // 5 : Fermeture transaction
        tx.commit();

        // 6 : Fermeture unité de travail JPA
        em.close();
        emf.close();
    }
}
