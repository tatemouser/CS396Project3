// src/main/test/framework/TestCase.java
package test.framework;

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private String id;
    private String name;
    private String description;
    private String category;
    private TestStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;
    private List<String> tags;
    private List<TestStep> steps;

    public TestCase(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.status = TestStatus.NOT_RUN;
        this.createdAt = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
        this.tags = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { 
        this.name = name;
        this.lastModified = LocalDateTime.now();
    }
    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
        this.lastModified = LocalDateTime.now();
    }
    public TestStatus getStatus() { return status; }
    public void setStatus(TestStatus status) {
        this.status = status;
        this.lastModified = LocalDateTime.now();
    }
    public List<String> getTags() { return tags; }
    public List<TestStep> getSteps() { return steps; }

    public void addStep(TestStep step) {
        steps.add(step);
        this.lastModified = LocalDateTime.now();
    }

    public void addTag(String tag) {
        tags.add(tag);
        this.lastModified = LocalDateTime.now();
    }
}