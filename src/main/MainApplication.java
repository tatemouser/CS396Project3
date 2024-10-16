package main;

import models.DisasterEvent;
import models.ResponseTeam;
import services.DispatchService;
import services.NotificationService;

public class MainApplication {
    public static void main(String[] args) {
        // Create a disaster event
        DisasterEvent event = new DisasterEvent("Flood", "New Orleans");

        // Create a response team
        ResponseTeam team = new ResponseTeam("Rescue Squad", "Water Rescue");

        // Use services
        NotificationService notificationService = new NotificationService();
        DispatchService dispatchService = new DispatchService();

        // Simulate sending a notification
        notificationService.sendNotification(event);

        // Simulate dispatching a team
        dispatchService.dispatchTeam(team, event);
    }
}
