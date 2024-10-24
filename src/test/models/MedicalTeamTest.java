// src/test/models/MedicalTeamTest.java
package test.models;

import main.models.MedicalTeam;
import org.junit.Before;
import org.junit.Test;
import test.framework.TestCase;
import test.framework.TestSuite;
import test.framework.TestManager;

import static org.junit.Assert.*;

public class MedicalTeamTest {
    private TestSuite teamTestSuite;
    private MedicalTeam team;

    @Before
    public void setUp() {
        TestManager testManager = TestManager.getInstance();
        teamTestSuite = testManager.createTestSuite("Medical Team Tests");
        team = new MedicalTeam("T001", "Emergency Response", "Emergency Medicine");
    }

    @Test
    public void testTeamCreation() {
        TestCase creationTest = new TestCase(
            "Medical Team Creation",
            "Verify medical team creation with correct initial values"
        );
        teamTestSuite.addTestCase(creationTest, "team");

        try {
            assertEquals("T001", team.getTeamId());
            assertEquals("Emergency Response", team.getTeamName());
            assertEquals("Emergency Medicine", team.getSpecialty());
            assertFalse(team.isOnCall());
            assertTrue(team.getMemberIds().isEmpty());
            
            creationTest.setStatus(test.framework.TestStatus.PASSED);
        } catch (AssertionError e) {
            creationTest.setStatus(test.framework.TestStatus.FAILED);
            throw e;
        }
    }
}