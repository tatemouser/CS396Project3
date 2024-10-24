// src/test/framework/TestManager.java
package test.framework;

import java.util.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class TestManager {
    private static final Logger LOGGER = Logger.getLogger(TestManager.class.getName());
    private Map<String, TestSuite> testSuites;
    private static TestManager instance;
    private LocalDateTime lastExecutionTime;

    private TestManager() {
        this.testSuites = new HashMap<>();
    }

    public static TestManager getInstance() {
        if (instance == null) {
            instance = new TestManager();
        }
        return instance;
    }

    public TestSuite createTestSuite(String name) {
        if (testSuites.containsKey(name)) {
            LOGGER.warning("Test suite '" + name + "' already exists. Returning existing suite.");
            return testSuites.get(name);
        }

        TestSuite suite = new TestSuite(name);
        testSuites.put(name, suite);
        LOGGER.info("Created new test suite: " + name);
        return suite;
    }

    public TestSuite getTestSuite(String name) {
        return testSuites.get(name);
    }

    public void removeTestSuite(String name) {
        testSuites.remove(name);
        LOGGER.info("Removed test suite: " + name);
    }

    public Set<String> getAllTestSuiteNames() {
        return new HashSet<>(testSuites.keySet());
    }

    public Map<String, Map<TestStatus, Integer>> getOverallTestStatus() {
        Map<String, Map<TestStatus, Integer>> overallStatus = new HashMap<>();
        for (Map.Entry<String, TestSuite> entry : testSuites.entrySet()) {
            overallStatus.put(entry.getKey(), entry.getValue().getTestStatusSummary());
        }
        return overallStatus;
    }

    public void executeAllTests() {
        lastExecutionTime = LocalDateTime.now();
        for (TestSuite suite : testSuites.values()) {
            suite.setLastExecutionTime(lastExecutionTime);
            LOGGER.info("Executing test suite: " + suite.getName());
        }
    }

    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test Manager Status:\n");
        sb.append("Total Test Suites: ").append(testSuites.size()).append("\n");
        
        Map<String, Map<TestStatus, Integer>> overallStatus = getOverallTestStatus();
        for (Map.Entry<String, Map<TestStatus, Integer>> entry : overallStatus.entrySet()) {
            sb.append("\nSuite: ").append(entry.getKey()).append("\n");
            for (Map.Entry<TestStatus, Integer> statusEntry : entry.getValue().entrySet()) {
                sb.append(String.format("%s: %d\n", 
                    statusEntry.getKey().getDisplayName(), statusEntry.getValue()));
            }
        }
        return sb.toString();
    }
}