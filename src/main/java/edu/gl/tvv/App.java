package edu.gl.tvv;

import java.util.List;

import edu.gl.tvv.service.Railways;

public class App {
    public static void main(String[] args) {
        App.start();
    }

    private static void start() {
        Railways.createAndSaveTrain();
        List retrievedTrain = Railways.retrieveTrain();
        System.out.println("Retrieved train = " + retrievedTrain);
    }
}
