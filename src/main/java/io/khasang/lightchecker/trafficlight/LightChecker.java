package io.khasang.lightchecker.trafficlight;

import io.khasang.lightchecker.light.Color;
import io.khasang.lightchecker.light.Light;

public class LightChecker {
    private TrafficLight trafficLight;

    public LightChecker(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Color getLightColor(double minutes) {
        int cycleDuration = getSumOfLightsDurations(trafficLight.getGreenLight(), trafficLight.getYellowLight(), trafficLight.getRedLight());
        int primeMinute = (int) (((minutes / cycleDuration) % 1) * cycleDuration);
        return getColor(primeMinute, trafficLight.getGreenLight(), trafficLight.getYellowLight(), trafficLight.getRedLight());
    }

    private int getSumOfLightsDurations(Light... lights) {
        int sum = 0;
        for (Light light : lights) {
            sum = sum + light.getDuration();
        }
        return sum;
    }

    private Color getColor(int minute, Light... lights) {
        Color color = null;
        for (Light light : lights) {
            if (isLightTurnsOnThisMinute(light, minute)) {
                color = light.getColor();
            }
        }
        return color;
    }

    private boolean isLightTurnsOnThisMinute(Light light, int minute) {
        return minute >= light.getBeginIndex() && minute <= light.getEndIndex();
    }
}
