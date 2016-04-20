package io.khasang.lightchecker.light;

public class YellowLight extends Light {
    public YellowLight(int duration) {
        this.duration = duration;
        beginIndex = GreenLight.index;
        endIndex = beginIndex + duration;
        index = endIndex;
    }

    @Override
    public Color getColor() {
        return Color.Yellow;
    }
}
