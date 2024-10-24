package main.healthcare.monitoring;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class DeploymentMonitor {
    private static final Logger LOGGER = Logger.getLogger(DeploymentMonitor.class.getName());
    private List<DeploymentListener> listeners = new ArrayList<>();
    private static final DeploymentMonitor instance = new DeploymentMonitor();

    private DeploymentMonitor() {}

    public static DeploymentMonitor getInstance() {
        return instance;
    }

    public void addListener(DeploymentListener listener) {
        listeners.add(listener);
    }

    public void notifyDeploymentStatus(String status, String details) {
        String timestamp = LocalDateTime.now().toString();
        String logMessage = String.format("[%s] %s: %s", timestamp, status, details);
        
        LOGGER.info(logMessage);
        
        for (DeploymentListener listener : listeners) {
            listener.onDeploymentUpdate(status, details);
        }
    }
}