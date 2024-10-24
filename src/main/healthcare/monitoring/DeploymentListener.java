// src/main/healthcare/monitoring/DeploymentListener.java
package main.healthcare.monitoring;

public interface DeploymentListener {
    void onDeploymentUpdate(String status, String details);
}