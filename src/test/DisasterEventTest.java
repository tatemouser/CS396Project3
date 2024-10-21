package test;

import main.models.DisasterEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisasterEventTest {
    private DisasterEvent event;

    @Before
    public void setUp() {
        event = new DisasterEvent("Flood", "New Orleans");
    }

    @Test
    public void testDisasterEventCreation() {
        assertEquals("Flood", event.getEventType());
        assertEquals("New Orleans", event.getLocation());
    }

    @Test
    public void testSetEventType() {
        event.setEventType("Hurricane");
        assertEquals("Hurricane", event.getEventType());
    }

    @Test
    public void testSetLocation() {
        event.setLocation("Miami");
        assertEquals("Miami", event.getLocation());
    }

    @Test
    public void testToString() {
        String expected = "DisasterEvent{eventType='Flood', location='New Orleans'}";
        assertEquals(expected, event.toString());
    }

    @Test
    public void testNullValues() {
        DisasterEvent nullEvent = new DisasterEvent(null, null);
        assertNull(nullEvent.getEventType());
        assertNull(nullEvent.getLocation());
    }
}