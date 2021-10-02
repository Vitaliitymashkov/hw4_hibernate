package edu.gl.tvv.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import edu.gl.tvv.model.Train;

public class RailwaysEntityManager {

    private static EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private static EntityManager entityManager;

    public static void insertEntity() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public static void persistEntity(Train train) {
        entityManager.persist(train);
    }

    public static void closeEntity() {
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public static List retrieveTrain(String routeNumber) {
        String hql = "FROM Train T WHERE T. = :routeNumber";
        final Query query = entityManager.createQuery(hql);
        query.setParameter( "routeNumber",routeNumber);
        return query.getResultList();
    }
}
