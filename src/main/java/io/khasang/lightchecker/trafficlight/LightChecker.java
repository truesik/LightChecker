package io.khasang.lightchecker.trafficlight;

import io.khasang.lightchecker.light.Color;
import io.khasang.lightchecker.light.Light;

public class LightChecker {
    private TrafficLight trafficLight;

    public LightChecker(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Color getLightColor(int minutes) {
        Color color = null;
        int cycleDuration = getSumOfLightsDuration(trafficLight.getGreenLight(), trafficLight.getYellowLight(), trafficLight.getRedLight());
        for (int i = 0; i <= minutes; i += cycleDuration) {
            if (isValid(trafficLight.getGreenLight(), minutes, i)) {
                color = trafficLight.getGreenLight().getColor();
            }
            if (isValid(trafficLight.getYellowLight(), minutes, i)) {
                color = trafficLight.getYellowLight().getColor();
            }
            if (isValid(trafficLight.getRedLight(), minutes, i)) {
                color = trafficLight.getRedLight().getColor();
            }
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

    private boolean isValid(Light light, int minutes, int indexOfCycle) {
        return minutes >= light.getBeginIndex() + indexOfCycle && minutes <= light.getEndIndex() + indexOfCycle;
    }
}
