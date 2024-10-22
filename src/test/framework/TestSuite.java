package test.framework;

import java.util.*;
import java.util.stream.Collectors;

public class TestSuite {
    private String name;
    private List<TestCase> testCases;
    private Map<String, List<TestCase>> categorizedTests;

    public TestSuite(String name) {
        this.name = name;
        this.testCases = new ArrayList<>();
        this.categorizedTests = new HashMap<>();
    }

    public void addTestCase(TestCase testCase, String category) {
        testCases.add(testCase);
        categorizedTests.computeIfAbsent(category, k -> new ArrayList<>()).add(testCase);
    }

    public List<TestCase> getTestCasesByCategory(String category) {
        return categorizedTests.getOrDefault(category, new ArrayList<>());
    }

    public List<TestCase> getTestCasesByTag(String tag) {
        return testCases.stream()
            .filter(test -> test.getTags().contains(tag))
            .collect(Collectors.toList());  // Changed from toList() to collect(Collectors.toList())
    }

    public List<TestCase> getAllTestCases() {
        return new ArrayList<>(testCases);
    }
}