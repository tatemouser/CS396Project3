// src/test/models/PatientTest.java
package test.models;

import main.models.Patient;
import org.junit.Before;
import org.junit.Test;
import test.framework.TestCase;
import test.framework.TestSuite;
import test.framework.TestManager;

import static org.junit.Assert.*;

public class PatientTest {
    private TestSuite patientTestSuite;
    private Patient patient;

    @Before
    public void setUp() {
        TestManager testManager = TestManager.getInstance();
        patientTestSuite = testManager.createTestSuite("Patient Management Tests");
        patient = new Patient("P001", "John Doe", "1980-01-01");
    }

    @Test
    public void testPatientCreation() {
        TestCase creationTest = new TestCase(
            "Patient Creation",
            "Verify patient creation with correct initial values"
        );
        patientTestSuite.addTestCase(creationTest, "patient");

        try {
            assertEquals("P001", patient.getPatientId());
            assertEquals("John Doe", patient.getName());
            assertEquals("1980-01-01", patient.getDateOfBirth());
            
            creationTest.setStatus(test.framework.TestStatus.PASSED);
        } catch (AssertionError e) {
            creationTest.setStatus(test.framework.TestStatus.FAILED);
            throw e;
        }
    }
}
