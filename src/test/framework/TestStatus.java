// src/test/framework/TestStatus.java
package test.framework;

public enum TestStatus {
    NOT_RUN("Not Run"),
    PASSED("Passed"),
    FAILED("Failed"),
    BLOCKED("Blocked"),
    SKIPPED("Skipped");

    private final String displayName;

    TestStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}