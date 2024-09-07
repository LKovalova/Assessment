package com.example.smarthome;

import com.example.smarthome.controller.ApplianceController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final ApplianceController applianceController;

    public ScheduledTasks(ApplianceController applianceController) {
        this.applianceController = applianceController;
    }

    @Scheduled(cron = "0 0 1 1 1 ?") // Runs at 1:00 AM on January 1st
    public void performAnnualUpdate() {

        applianceController.performUpdate();
    }
}
