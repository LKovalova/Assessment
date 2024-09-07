package com.example.smarthome.model;

public class Light {
    private boolean isOn;

    public Light() {
        this.isOn = true; // Light is On initially
    }

    public void toggleSwitch() {
        this.isOn = !this.isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff() {
        this.isOn = false;
    }
}
