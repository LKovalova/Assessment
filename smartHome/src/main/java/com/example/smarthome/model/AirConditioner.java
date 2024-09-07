package com.example.smarthome.model;

/**
 * Represents an air conditioner in the smart home system.
 */
public class AirConditioner {
    private boolean isOn;

    public AirConditioner() {
        this.isOn = true; // AirConditioner is On initially
    }

    /**
     * Sets the air conditioner thermostat mode.
     *
     * @param mode the desired mode ("off" or other).
     */
    public void setThermostat(String mode) {
        if ("off".equalsIgnoreCase(mode)) {
            this.isOn = false;
        } else {
            this.isOn = true;
        }
    }

    /**
     * Checks if the air conditioner is on.
     *
     * @return true if the air conditioner is on, false otherwise.
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Turns off the air conditioner.
     */
    public void turnOff() {
        this.isOn = false;
    }
}
