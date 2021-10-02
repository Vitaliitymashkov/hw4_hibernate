package edu.gl.tvv.service;

import java.util.List;

import edu.gl.tvv.persistence.RailwaysEntityManager;
import edu.gl.tvv.model.Train;
import edu.gl.tvv.util.TrainBuilder;

public class Railways {

    public static void createAndSaveTrain() {
        RailwaysEntityManager.insertEntity();
        Train train1 = TrainBuilder.buildTrain1();
        RailwaysEntityManager.persistEntity(train1);
        RailwaysEntityManager.closeEntity();
    }

//    public static List<Train> retrieveTrain() {
    public static List retrieveTrain() {
        RailwaysEntityManager.insertEntity();
        List results = RailwaysEntityManager.retrieveTrain("705");
        RailwaysEntityManager.closeEntity();
        return results;
    }
}
