package com.example.smarthome.controller;

import com.example.smarthome.exception.ApplianceException;
import com.example.smarthome.model.AirConditioner;
import com.example.smarthome.model.Fan;
import com.example.smarthome.model.Light;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Controller for managing smart home appliances.
 */
@RestController
@RequestMapping("/appliances")
public class ApplianceController {
    private final Light light = new Light();
    private final Fan fan = new Fan();
    private final AirConditioner airConditioner = new AirConditioner();

    /**
     * Retrieves the current status of the light.
     *
     * @return true if the light is on, false otherwise.
     */
    @GetMapping("/light")
    public boolean getLightStatus() {
        return light.isOn();
    }

    /**
     * Toggles the state of the light.
     * If the light is on, it will be turned off and vice versa.
     */
    @PostMapping("/light/toggle")
    public void toggleLight() {
        light.toggleSwitch();
    }

    /**
     * Sets the fan speed.
     *
     * @param speed the desired fan speed (0 = off, 1, 2).
     * @return a response indicating the fan speed has been set.
     * @throws IllegalArgumentException if the provided speed is out of range.
     */
    @PostMapping("/fan/speed/{speed}")
    public ResponseEntity<String> setFanSpeed(@PathVariable int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Invalid fan speed: " + speed);
        }
        fan.setSpeed(speed);
        return ResponseEntity.ok("Fan speed set to " + speed);
    }

    /**
     * Retrieves the current speed of the fan.
     *
     * @return the current fan speed.
     */
    @GetMapping("/fan")
    public int getFanSpeed() {
        return fan.getSpeed();
    }

    /**
     * Sets the air conditioner mode.
     *
     * @param mode the desired mode ("cool" or "off").
     * @return a response indicating the air conditioner mode has been set.
     * @throws ApplianceException if the provided mode is invalid.
     */
    @PostMapping("/airconditioner/{mode}")
    public ResponseEntity<String> setAirConditionerMode(@PathVariable String mode) {
        if (!"cool".equalsIgnoreCase(mode) && !"off".equalsIgnoreCase(mode)) {
            throw new ApplianceException("Invalid mode: " + mode);
        }
        airConditioner.setThermostat(mode);
        return ResponseEntity.ok("Air conditioner set to " + mode);
    }

    /**
     * Retrieves the current status of the air conditioner.
     *
     * @return true if the air conditioner is on, false otherwise.
     */
    @GetMapping("/airconditioner")
    public boolean getAirConditionerStatus() {
        return airConditioner.isOn();
    }

    /**
     * Performs a scheduled update by turning off all devices.
     * This method is intended to be called at 1:00 AM on January 1st UTC.
     *
     * @return a message indicating the result of the update operation.
     */
    @PostMapping("/update")
    public String performUpdate() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        if (now.getMonthValue() == 1 && now.getDayOfMonth() == 1 && now.getHour() == 1) {
            light.turnOff();
            fan.turnOff();
            airConditioner.turnOff();
            return "All devices turned off for update.";
        }
        return "Not time for scheduled update.";
    }
}
