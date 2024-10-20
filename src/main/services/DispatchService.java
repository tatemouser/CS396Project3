package main.services;

import main.models.DisasterEvent;
import main.models.ResponseTeam;

public class DispatchService {
    public void dispatchTeam(ResponseTeam team, DisasterEvent event) {
        System.out.println("Dispatching " + team.getTeamName() + " to " + event.getLocation() + " for " + event.getEventType());
    }
}
