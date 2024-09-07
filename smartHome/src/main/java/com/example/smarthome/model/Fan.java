package com.example.smarthome.model;

public class Fan {
    private int speed;

    public Fan() {
        this.speed = 2; // Fan speed is 2 initially
    }

    public void setSpeed(int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Invalid speed");
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void turnOff() {
        this.speed = 0;
    }
}
