package models;

public class DisasterEvent {
    private String eventType;
    private String location;

    public DisasterEvent(String eventType, String location) {
        this.eventType = eventType;
        this.location = location;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "DisasterEvent{" +
                "eventType='" + eventType + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
