package edu.gl.tvv.model;

public enum TrainClass {
    INTERCITY("Intercity"),
    NIGHT("Night"),
    LOCAL("Local");

    private String name;

    TrainClass(String name) {
        this.name = name;
    }
}
