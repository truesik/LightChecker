package io.khasang.lightchecker.light;

public abstract class Light {
    protected int duration;
    public static int index;
    protected int beginIndex;
    protected int endIndex;

    public abstract Color getColor();

    public int getDuration() {
        return duration;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}