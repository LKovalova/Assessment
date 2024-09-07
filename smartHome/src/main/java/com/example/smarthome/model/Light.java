package com.example.smarthome.model;

/**
 * Represents a light in the smart home system.
 */
public class Light {
    private boolean isOn;

    public Light() {
        this.isOn = true; // Light is On initially
    }

    /**
     * Toggles the state of the light.
     * If the light is on, it will be turned off, and vice versa.
     */
    public void toggleSwitch() {
        this.isOn = !this.isOn;
    }

    /**
     * Checks if the light is on.
     *
     * @return true if the light is on, false otherwise.
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Turns off the light.
     */
    public void turnOff() {
        this.isOn = false;
    }
}
