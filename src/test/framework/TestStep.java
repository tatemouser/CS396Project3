// src/main/test/framework/TestStep.java
package test.framework;

public class TestStep {
    private String description;
    private String expectedResult;
    private String actualResult;
    private TestStatus status;

    public TestStep(String description, String expectedResult) {
        this.description = description;
        this.expectedResult = expectedResult;
        this.status = TestStatus.NOT_RUN;
    }

    // Getters and setters
    public String getDescription() { return description; }
    public String getExpectedResult() { return expectedResult; }
    public String getActualResult() { return actualResult; }
    public void setActualResult(String actualResult) { this.actualResult = actualResult; }
    public TestStatus getStatus() { return status; }
    public void setStatus(TestStatus status) { this.status = status; }
}

