package io.khasang.lightchecker.trafficlight;

import io.khasang.lightchecker.light.Color;
import io.khasang.lightchecker.light.Light;

public class LightChecker {
    private TrafficLight trafficLight;

    public LightChecker(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Color getLightColor(double minutes) {
        Color color = null;
        int cycleDuration = getSumOfLightsDuration(trafficLight.getGreenLight(), trafficLight.getYellowLight(), trafficLight.getRedLight());
        int primeMinute = (int) (((minutes / cycleDuration) % 1) * cycleDuration);
        if (isValid(trafficLight.getGreenLight(), primeMinute)) {
            color = trafficLight.getGreenLight().getColor();
        }
        if (isValid(trafficLight.getYellowLight(), primeMinute)) {
            color = trafficLight.getYellowLight().getColor();
        }
        if (isValid(trafficLight.getRedLight(), primeMinute)) {
            color = trafficLight.getRedLight().getColor();
        }
        return color;
    }

    private int getSumOfLightsDuration(Light... lights) {
        int sum = 0;
        for (Light light : lights) {
            sum = sum + light.getDuration();
        }
        return sum;
    }

    private boolean isValid(Light light, int minutes) {
        return minutes >= light.getBeginIndex() && minutes <= light.getEndIndex();
    }
}
