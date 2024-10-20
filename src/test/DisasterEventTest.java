package test;

import main.models.DisasterEvent;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisasterEventTest {
    @Test
    public void testDisasterEventCreation() {
        DisasterEvent event = new DisasterEvent("Flood", "New Orleans");
        assertEquals("Flood", event.getEventType());
        assertEquals("New Orleans", event.getLocation());
    }

    @Test
    public void testToString() {
        DisasterEvent event = new DisasterEvent("Hurricane", "Miami");
        String expected = "Disaster Event - Type: Hurricane, Location: Miami";
        assertEquals(expected, event.toString());
    }
}