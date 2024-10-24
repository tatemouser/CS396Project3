// src/test/framework/TestSuite.java
package test.framework;

import java.util.*;
import java.time.LocalDateTime;

public class TestSuite {
    private String name;
    private Map<String, List<TestCase>> categorizedTests;
    private LocalDateTime creationTime;
    private LocalDateTime lastExecutionTime;

    public TestSuite(String name) {
        this.name = name;
        this.categorizedTests = new HashMap<>();
        this.creationTime = LocalDateTime.now();
    }

    public void addTestCase(TestCase testCase, String category) {
        categorizedTests.computeIfAbsent(category, k -> new ArrayList<>())
                       .add(testCase);
    }

    public List<TestCase> getTestCasesByCategory(String category) {
        return new ArrayList<>(categorizedTests.getOrDefault(category, new ArrayList<>()));
    }

    public List<TestCase> getTestCasesByTag(String tag) {
        List<TestCase> matchingTests = new ArrayList<>();
        for (List<TestCase> categoryTests : categorizedTests.values()) {
            for (TestCase test : categoryTests) {
                if (test.hasTag(tag)) {
                    matchingTests.add(test);
                }
            }
        }
        return matchingTests;
    }

    public String getName() {
        return name;
    }

    public Set<String> getCategories() {
        return new HashSet<>(categorizedTests.keySet());
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }

    public void setLastExecutionTime(LocalDateTime time) {
        this.lastExecutionTime = time;
    }

    public Map<TestStatus, Integer> getTestStatusSummary() {
        Map<TestStatus, Integer> summary = new EnumMap<>(TestStatus.class);
        for (TestStatus status : TestStatus.values()) {
            summary.put(status, 0);
        }

        for (List<TestCase> categoryTests : categorizedTests.values()) {
            for (TestCase test : categoryTests) {
                summary.put(test.getStatus(), summary.get(test.getStatus()) + 1);
            }
        }
        return summary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test Suite: ").append(name).append("\n");
        sb.append("Categories: ").append(String.join(", ", getCategories())).append("\n");
        Map<TestStatus, Integer> summary = getTestStatusSummary();
        sb.append("Status Summary:\n");
        for (Map.Entry<TestStatus, Integer> entry : summary.entrySet()) {
            sb.append(String.format("%s: %d\n", entry.getKey().getDisplayName(), entry.getValue()));
        }
        return sb.toString();
    }
}
