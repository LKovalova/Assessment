package com.example.smarthome.model;

public class AirConditioner {
    private boolean isOn;

    public AirConditioner() {
        this.isOn = true; // AirConditioner is On initially
    }

    public void setThermostat(String mode) {
        if ("off".equalsIgnoreCase(mode)) {
            this.isOn = false;
        } else {
            this.isOn = true;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff() {
        this.isOn = false;
    }
}
