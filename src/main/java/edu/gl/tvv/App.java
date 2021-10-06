package edu.gl.tvv;

import edu.gl.tvv.service.Railways;

public class App {

    private static final int ROUTE_NUMBER = 705;

    public static void main(String[] args) {
//        App.start();
        Railways.createAndSaveTrain2(ROUTE_NUMBER);
    }

    private static void start() {

//        Railways.retrieveTrain2(ROUTE_NUMBER);
    }
}
