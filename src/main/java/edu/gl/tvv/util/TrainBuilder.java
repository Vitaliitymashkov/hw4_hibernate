package edu.gl.tvv.util;

import java.util.Arrays;
import java.util.List;

import edu.gl.tvv.model.Carriage;
import edu.gl.tvv.model.Depot;
import edu.gl.tvv.model.Train;
import edu.gl.tvv.model.TrainClass;

public class TrainBuilder {
    public static Train buildTrain1(int routeNumber){
        Carriage carriage1 = new Carriage(2011, 80);
        Carriage carriage2 = new Carriage(2011, 80);
        Carriage carriage3 = new Carriage(2011, 80);
        Carriage carriage4 = new Carriage(2011, 56);
        Carriage carriage5 = new Carriage(2011, 56);
        List<Carriage> carriages = Arrays.asList(carriage1, carriage2, carriage3, carriage4, carriage5);

        Depot depot1 = buildDepot();
        Train train = new Train(160, routeNumber, depot1, TrainClass.INTERCITY, carriages);
        train.setDepotAddress(depot1);

        carriage1.setTrain(train);
        carriage2.setTrain(train);
        carriage3.setTrain(train);
        carriage4.setTrain(train);
        carriage5.setTrain(train);
        return train;
    }

    public static Depot buildDepot() {
        Depot depot1 = new Depot("Kyiv 1st depot");
        return depot1;
    }
}
