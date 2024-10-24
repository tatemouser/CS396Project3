// src/main/healthcare/HealthcareApplication.java
package main.healthcare;
/* 
import java.util.HashMap;
import java.util.Map;

import main.healthcare.monitoring.DeploymentMonitor;

import java.time.LocalDateTime; */

public class HealthcareApplication {
    /* private String version;
    private Map<String, String> configurations;
    private LocalDateTime deploymentTime;
    private static HealthcareApplication currentInstance;
    private static HealthcareApplication previousInstance;

    public HealthcareApplication(String version) {
        this.version = version;
        this.configurations = new HashMap<>();
        this.deploymentTime = LocalDateTime.now();
    } */

    public static void main(String[] args) {
        try {
            while (true) {
                Thread.sleep(10000);
                System.out.println("Hello world!");
            }
        } catch (InterruptedException e) {
            ;
        }finally {
            ;
        }
    }
/* 
    public static void deploy(HealthcareApplication newInstance) {
        previousInstance = currentInstance;
        currentInstance = newInstance;
        DeploymentMonitor.getInstance().notifyDeploymentStatus(
            "DEPLOYED",
            "Version " + newInstance.getVersion() + " deployed successfully"
        );
    }

    public static void rollback() {
        if (previousInstance != null) {
            currentInstance = previousInstance;
            DeploymentMonitor.getInstance().notifyDeploymentStatus(
                "ROLLBACK",
                "Rolled back to version: " + previousInstance.getVersion()
            );
        }
    }

    public String getVersion() {
        return version;
    }

    public void setConfiguration(String key, String value) {
        configurations.put(key, value);
    }

    public String getConfiguration(String key) {
        return configurations.get(key);
    }

    public LocalDateTime getDeploymentTime() {
        return deploymentTime;
    }
        */
}