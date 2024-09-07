package com.example.smarthome.controller;

import com.example.smarthome.model.AirConditioner;
import com.example.smarthome.model.Fan;
import com.example.smarthome.model.Light;
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
    public void setFanSpeed(@PathVariable int speed) {
        fan.setSpeed(speed);
    }

    @GetMapping("/fan")
    public int getFanSpeed() {
        return fan.getSpeed();
    }

    @PostMapping("/airconditioner/{mode}")
    public void setAirConditionerMode(@PathVariable String mode) {
        airConditioner.setThermostat(mode);
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
