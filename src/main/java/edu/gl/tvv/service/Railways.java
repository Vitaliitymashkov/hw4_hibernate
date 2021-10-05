package edu.gl.tvv.service;

import java.util.List;

import edu.gl.tvv.persistence.RailwaysEntityManager;
import edu.gl.tvv.model.Train;
import edu.gl.tvv.util.TrainBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Railways {

    public static void createAndSaveTrain() {
        RailwaysEntityManager.insertEntity();
        Train train1 = TrainBuilder.buildTrain1();
        RailwaysEntityManager.persistEntity(train1);
        RailwaysEntityManager.closeEntity();
    }
    public static void createAndSaveTrain2() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Train train1 = TrainBuilder.buildTrain1();
        session.persist(train1);
        session.persist(train1.getDepotAddress());
        session.persist(train1.getCarriages());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

//    public static List<Train> retrieveTrain() {
    public static List retrieveTrain() {
        RailwaysEntityManager.insertEntity();
        List results = RailwaysEntityManager.retrieveTrain("705");
        RailwaysEntityManager.closeEntity();
        return results;
    }
}
