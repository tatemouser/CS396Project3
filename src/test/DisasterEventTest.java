// src/main/test/DisasterEventTest.java
package test;

import main.models.DisasterEvent;
import org.junit.Before;
import org.junit.Test;
import test.framework.*;
import static org.junit.Assert.*;

public class DisasterEventTest {
    private DisasterEvent event;
    private TestSuite disasterTestSuite;

    @Before
    public void setUp() {
        event = new DisasterEvent("Flood", "New Orleans");
        
        // Initialize test suite
        TestManager testManager = TestManager.getInstance();
        disasterTestSuite = testManager.createTestSuite("Disaster Management Tests");
        
        // Create and organize test cases
        setupTestCases();
    }

    private void setupTestCases() {
        // Create test case for event creation
        TestCase creationTest = new TestCase(
            "Disaster Event Creation",
            "Verify that a disaster event is created with correct initial values"
        );
        creationTest.addTag("creation");
        creationTest.addTag("basic");
        
        TestStep step1 = new TestStep(
            "Create new DisasterEvent with type 'Flood' and location 'New Orleans'",
            "Event should be created with specified values"
        );
        creationTest.addStep(step1);
        
        // Create test case for event modification
        TestCase modificationTest = new TestCase(
            "Disaster Event Modification",
            "Verify that disaster event properties can be modified"
        );
        modificationTest.addTag("modification");
        modificationTest.addTag("basic");
        
        TestStep step2 = new TestStep(
            "Modify event type to 'Hurricane'",
            "Event type should be updated to 'Hurricane'"
        );
        modificationTest.addStep(step2);
        
        // Add test cases to suite
        disasterTestSuite.addTestCase(creationTest, "basic");
        disasterTestSuite.addTestCase(modificationTest, "basic");
    }

    @Test
    public void testDisasterEventCreation() {
        TestCase testCase = disasterTestSuite.getTestCasesByTag("creation").get(0);
        
        try {
            assertEquals("Flood", event.getEventType());
            assertEquals("New Orleans", event.getLocation());
            testCase.setStatus(TestStatus.PASSED);
        } catch (AssertionError e) {
            testCase.setStatus(TestStatus.FAILED);
            throw e;
        }
    }

    @Test
    public void testSetEventType() {
        TestCase testCase = disasterTestSuite.getTestCasesByTag("modification").get(0);
        
        try {
            event.setEventType("Hurricane");
            assertEquals("Hurricane", event.getEventType());
            testCase.setStatus(TestStatus.PASSED);
        } catch (AssertionError e) {
            testCase.setStatus(TestStatus.FAILED);
            throw e;
        }
    }

    // ... other test methods ...
}