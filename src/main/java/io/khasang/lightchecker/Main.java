package io.khasang.lightchecker;

import io.khasang.lightchecker.light.GreenLight;
import io.khasang.lightchecker.light.RedLight;
import io.khasang.lightchecker.light.YellowLight;
import io.khasang.lightchecker.trafficlight.LightChecker;
import io.khasang.lightchecker.trafficlight.MinutesReader;
import io.khasang.lightchecker.trafficlight.TrafficLight;

public class Main {
    public static void main(String[] args) {
        LightChecker lightChecker = new LightChecker(new TrafficLight(new GreenLight(2), new YellowLight(3), new RedLight(5)));
        System.out.println(lightChecker.getLightColor(new MinutesReader().read()));
    }
}
