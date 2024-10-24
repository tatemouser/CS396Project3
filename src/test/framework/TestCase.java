
// src/test/framework/TestCase.java
package test.framework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

public class TestCase {
    private String name;
    private String description;
    private List<TestStep> steps;
    private Set<String> tags;
    private TestStatus status;
    private LocalDateTime lastExecutionTime;

    public TestCase(String name, String description) {
        this.name = name;
        this.description = description;
        this.steps = new ArrayList<>();
        this.tags = new HashSet<>();
        this.status = TestStatus.NOT_RUN;
    }

    public void addStep(TestStep step) {
        steps.add(step);
    }

    public void addTag(String tag) {
        tags.add(tag.toLowerCase());
    }

    public void setStatus(TestStatus status) {
        this.status = status;
        this.lastExecutionTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<TestStep> getSteps() {
        return new ArrayList<>(steps);
    }

    public Set<String> getTags() {
        return new HashSet<>(tags);
    }

    public TestStatus getStatus() {
        return status;
    }

    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }

    public boolean hasTag(String tag) {
        return tags.contains(tag.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Test Case: %s\nDescription: %s\nStatus: %s\nTags: %s",
            name, description, status.getDisplayName(), String.join(", ", tags));
    }
}