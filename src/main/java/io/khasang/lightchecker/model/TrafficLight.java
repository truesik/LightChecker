package io.khasang.lightchecker.model;

import io.khasang.lightchecker.light.Light;

public class TrafficLight {
    private final Light greenLight;
    private final Light yellowLight;
    private final Light redLight;

    public TrafficLight(Light greenLight, Light yellowLight, Light redLight) {
        this.greenLight = greenLight;
        this.yellowLight = yellowLight;
        this.redLight = redLight;
    }

    public Light getGreenLight() {
        return greenLight;
    }

    public Light getYellowLight() {
        return yellowLight;
    }

    public Light getRedLight() {
        return redLight;
    }
}
