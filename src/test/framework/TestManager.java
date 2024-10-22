package test.framework;

import java.util.*;

public class TestManager {
    private Map<String, TestSuite> testSuites;
    private static TestManager instance;

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
        TestSuite suite = new TestSuite(name);
        testSuites.put(name, suite);
        return suite;
    }

    public TestSuite getTestSuite(String name) {
        return testSuites.get(name);
    }

    public void removeTestSuite(String name) {
        testSuites.remove(name);
    }

    public Set<String> getAllTestSuiteNames() {
        return testSuites.keySet();
    }
}