// src/test/healthcare/IntegrationTest.java
package test.healthcare;

import main.healthcare.HealthcareApplication;
import main.healthcare.monitoring.DeploymentMonitor;
import main.healthcare.monitoring.DeploymentListener;
import main.models.Patient;
import main.models.MedicalTeam;
import org.junit.Before;
import org.junit.Test;
import test.framework.TestCase;
import test.framework.TestSuite;
import test.framework.TestManager;

import static org.junit.Assert.*;

public class IntegrationTest {
    private TestSuite integrationTestSuite;
    private HealthcareApplication application;
    private boolean deploymentNotified = false;

    @Before
    public void setUp() {
        TestManager testManager = TestManager.getInstance();
        integrationTestSuite = testManager.createTestSuite("Healthcare Integration Tests");
        application = new HealthcareApplication("1.0.0");

        // Add deployment listener
        DeploymentMonitor.getInstance().addListener(new DeploymentListener() {
            @Override
            public void onDeploymentUpdate(String status, String details) {
                deploymentNotified = true;
            }
        });
    }

    @Test
    public void testEndToEndDeployment() {
        TestCase deploymentTest = new TestCase(
            "End-to-End Deployment",
            "Verify deployment process including rollback capability"
        );
        integrationTestSuite.addTestCase(deploymentTest, "deployment");

        try {
            // Deploy new version
            HealthcareApplication.deploy(application);
            assertTrue("Deployment notification should be sent", deploymentNotified);
            assertEquals("1.0.0", application.getVersion());

            // Test rollback
            HealthcareApplication.rollback();
            deploymentTest.setStatus(test.framework.TestStatus.PASSED);
        } catch (Exception e) {
            deploymentTest.setStatus(test.framework.TestStatus.FAILED);
            throw e;
        }
    }
}