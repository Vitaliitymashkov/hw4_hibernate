package edu.gl.tvv.service;

import java.util.List;

import edu.gl.tvv.model.Carriage;
import edu.gl.tvv.model.Train;
import edu.gl.tvv.util.TrainBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Railways {

    public static void createAndSaveTrain2(int routeNumber)  {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        saveTrain(routeNumber, session);
        extractTrainByRouteAndPrint(routeNumber, session);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void saveTrain(int routeNumber, Session session) {
        if (getTrainsByRouteNumber(routeNumber, session).isEmpty()) {
            Train train1 = TrainBuilder.buildTrain1(routeNumber);
            session.persist(train1);
            session.persist(train1.getDepotAddress());
        }
    }


    public static void retrieveTrain2(int routeNumber) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();


        extractTrainByRouteAndPrint(routeNumber, session);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private static void extractTrainByRouteAndPrint(int routeNumber, Session session) {
        List resultList = getTrainsByRouteNumber(routeNumber, session);
        if (resultList.size() != 0) {
            for (Object elem : resultList) {
                if (elem instanceof Train) {
                    System.out.println("TRAIN: " + ((Train) elem).getRouteNumber() + ", " + ((Train) elem).getTrainClass().toString().toLowerCase() + ", "
                            + ((Train) elem).getMaxSpeed() + " km/h, " + ((Train) elem).getDepotAddress() + ", Carriages: " + print(((Train) elem).getCarriages()));
                }
            }
        } else {
            System.out.println("EMPTY RESULT LIST!");
        }
    }

    private static List getTrainsByRouteNumber(int routeNumber, Session session) {
        String sql = "From Train T where T.routeNumber=:routeNumber";
        Query query = session.createQuery(sql);
        query.setParameter("routeNumber", routeNumber);
        List resultList = query.getResultList();
        return resultList;
    }

    private static String print(List<Carriage> car) {
        String result = "";
        for (Carriage elem : car) {
            result += "{" + "Release year - " + elem.getReleaseYear() + ", Max pax - " + elem.getPaxCapacity() + "}";
        }
        return result;
    }
}
