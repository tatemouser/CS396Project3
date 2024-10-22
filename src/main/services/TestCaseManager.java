package main.services;

import java.util.ArrayList;
import java.util.List;

public class TestCaseManager {
    private List<TestCase> testCases;

    public TestCaseManager() {
        this.testCases = new ArrayList<>();
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void removeTestCase(TestCase testCase) {
        testCases.remove(testCase);
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public TestCase findTestCaseByName(String name) {
        for (TestCase testCase : testCases) {
            if (testCase.getName().equals(name)) {
                return testCase;
            }
        }
        return null; // Or throw an exception
    }
}
