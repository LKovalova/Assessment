package com.example.smarthome.controller;

import com.example.smarthome.exception.ApplianceException;
import com.example.smarthome.model.AirConditioner;
import com.example.smarthome.model.Fan;
import com.example.smarthome.model.Light;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/appliances")
public class ApplianceController {
    private final Light light = new Light();
    private final Fan fan = new Fan();
    private final AirConditioner airConditioner = new AirConditioner();

    @GetMapping("/light")
    public boolean getLightStatus() {
        return light.isOn();
    }

    @PostMapping("/light/toggle")
    public void toggleLight() {
        light.toggleSwitch();
    }

    @PostMapping("/fan/speed/{speed}")
    public ResponseEntity<String> setFanSpeed(@PathVariable int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Invalid fan speed: " + speed);
        }
        fan.setSpeed(speed);
        return ResponseEntity.ok("Fan speed set to " + speed);
    }

    @GetMapping("/fan")
    public int getFanSpeed() {
        return fan.getSpeed();
    }

    @PostMapping("/airconditioner/{mode}")
    public ResponseEntity<String> setAirConditionerMode(@PathVariable String mode) {
        if (!"cool".equalsIgnoreCase(mode) && !"off".equalsIgnoreCase(mode)) {
            throw new ApplianceException("Invalid mode: " + mode);
        }
        airConditioner.setThermostat(mode);
        return ResponseEntity.ok("Air conditioner set to " + mode);
    }

    @GetMapping("/airconditioner")
    public boolean getAirConditionerStatus() {
        return airConditioner.isOn();
    }

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
