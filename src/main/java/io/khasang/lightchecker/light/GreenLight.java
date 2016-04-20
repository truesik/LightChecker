package io.khasang.lightchecker.light;

public class GreenLight extends Light {
    public GreenLight(int duration) {
        this.duration = duration;
        beginIndex = 0;
        endIndex = duration;
        index = duration;
    }

    @Override
    public Color getColor() {
        return Color.Green;
    }
}
