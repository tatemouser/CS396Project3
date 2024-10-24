// src/test/framework/TestStep.java
package test.framework;

import java.time.LocalDateTime;

public class TestStep {
    private String description;
    private String expectedResult;
    private String actualResult;
    private TestStatus status;
    private LocalDateTime executionTime;

    public TestStep(String description, String expectedResult) {
        this.description = description;
        this.expectedResult = expectedResult;
        this.status = TestStatus.NOT_RUN;
    }

    public void execute() {
        this.executionTime = LocalDateTime.now();
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getActualResult() {
        return actualResult;
    }

    public TestStatus getStatus() {
        return status;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return String.format("Step: %s\nExpected: %s\nActual: %s\nStatus: %s",
            description, expectedResult, actualResult, status.getDisplayName());
    }
}