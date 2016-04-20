package io.khasang.lightchecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinutesReader {
    public int read() {
        System.out.println("Введите число:");
        int minutes = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            minutes = getMinutes(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return minutes;
    }

    private int getMinutes(BufferedReader reader) {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int value;
        if (isInteger(line)) {
            if (isPositive(Integer.valueOf(line))) {
                value = Integer.valueOf(line);
            } else {
                System.err.println("Введите положительное число!");
                return getMinutes(reader);
            }
        } else {
            System.err.println("Введите число!");
            return getMinutes(reader);
        }
        return value;
    }

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isPositive(int value) {
        return value >= 0;
    }
}
