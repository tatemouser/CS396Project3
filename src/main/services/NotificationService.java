package main.services;

import main.models.DisasterEvent;

public class NotificationService {
    public void sendNotification(DisasterEvent event) {
        System.out.println("Notification sent: " + event.toString());
    }
}
