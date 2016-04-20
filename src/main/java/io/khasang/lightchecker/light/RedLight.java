package io.khasang.lightchecker.light;

public class RedLight extends Light {
    public RedLight(int duration) {
        this.duration = duration;
        beginIndex = YellowLight.index;
        endIndex = beginIndex + duration;
    }

    @Override
    public Color getColor() {
        return Color.Red;
    }
}
