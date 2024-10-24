// src/test/healthcare/SecurityTest.java
package test.healthcare;

import main.healthcare.security.SecurityManager;
import org.junit.Before;
import org.junit.Test;
import test.framework.TestCase;
import test.framework.TestSuite;
import test.framework.TestManager;

import static org.junit.Assert.*;

public class SecurityTest {
    private TestSuite securityTestSuite;
    private SecurityManager securityManager;

    @Before
    public void setUp() {
        TestManager testManager = TestManager.getInstance();
        securityTestSuite = testManager.createTestSuite("Security Tests");
        securityManager = SecurityManager.getInstance();
    }

    @Test
    public void testDataEncryption() {
        TestCase encryptionTest = new TestCase(
            "Data Encryption",
            "Verify sensitive data encryption functionality"
        );
        securityTestSuite.addTestCase(encryptionTest, "security");

        try {
            String sensitiveData = "Patient medical record";
            String encrypted = securityManager.encryptSensitiveData(sensitiveData);
            
            assertNotNull("Encrypted data should not be null", encrypted);
            assertNotEquals("Encrypted data should be different from original", 
                          sensitiveData, encrypted);
            
            encryptionTest.setStatus(test.framework.TestStatus.PASSED);
        } catch (Exception e) {
            encryptionTest.setStatus(test.framework.TestStatus.FAILED);
            throw e;
        }
    }
}