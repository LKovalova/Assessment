package com.example.smarthome.model;

/**
 * Represents a fan in the smart home system.
 */
public class Fan {
    private int speed;

    public Fan() {
        this.speed = 2; // Fan speed is 2 initially
    }

    /**
     * Sets the speed of the fan.
     *
     * @param speed the desired fan speed (0 = off, 1, 2).
     * @throws IllegalArgumentException if the provided speed is out of range.
     */
    public void setSpeed(int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Invalid speed");
        }
        this.speed = speed;
    }

    /**
     * Retrieves the current speed of the fan.
     *
     * @return the current fan speed.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Turns off the fan by setting its speed to 0.
     */
    public void turnOff() {
        this.speed = 0;
    }
}
