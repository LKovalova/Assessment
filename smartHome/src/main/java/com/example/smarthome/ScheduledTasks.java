package com.example.smarthome;

import com.example.smarthome.controller.ApplianceController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Component for scheduling tasks, such as annual updates.
 */
@Component
public class ScheduledTasks {
    private final ApplianceController applianceController;

    public ScheduledTasks(ApplianceController applianceController) {

        this.applianceController = applianceController;
    }

    /**
     * Performs the annual update at 1:00 AM on January 1st.
     * Turns off all devices as part of the update.
     */
    @Scheduled(cron = "0 0 1 1 1 ?") // Runs at 1:00 AM on January 1st
    public void performAnnualUpdate() {

        applianceController.performUpdate();
    }
}
