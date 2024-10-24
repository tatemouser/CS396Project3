// src/main/healthcare/security/SecurityManager.java
package main.healthcare.security;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SecurityManager {
    private static final Logger LOGGER = Logger.getLogger(SecurityManager.class.getName());
    private static final SecurityManager instance = new SecurityManager();
    private Map<String, String> userRoles;

    private SecurityManager() {
        this.userRoles = new HashMap<>();
    }

    public static SecurityManager getInstance() {
        return instance;
    }

    public String encryptSensitiveData(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            LOGGER.severe("Encryption failed: " + e.getMessage());
            throw new RuntimeException("Encryption failed", e);
        }
    }

    public void assignUserRole(String userId, String role) {
        userRoles.put(userId, role);
        LOGGER.info("Assigned role " + role + " to user " + userId);
    }

    public boolean validateAccess(String userId, String resource) {
        String userRole = userRoles.get(userId);
        if (userRole == null) {
            LOGGER.warning("Access denied: User " + userId + " has no assigned role");
            return false;
        }
        
        // Implement role-based access control logic here
        boolean hasAccess = checkResourceAccess(userRole, resource);
        
        if (!hasAccess) {
            LOGGER.warning("Access denied: User " + userId + " with role " + userRole + 
                          " attempted to access " + resource);
        }
        
        return hasAccess;
    }

    private boolean checkResourceAccess(String role, String resource) {
        // Implement your access control matrix here
        return true; // Placeholder implementation
    }
}