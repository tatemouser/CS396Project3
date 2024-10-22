package main;

import main.models.DisasterEvent;
import main.models.ResponseTeam;
import main.services.DispatchService;
import main.services.NotificationService;
import main.services.TestCaseManager;
import main.services.TestCase;

public class MainApplication {
    public static void main(String[] args) {
        // Create a disaster event
        DisasterEvent event = new DisasterEvent("Flood", "New Orleans");

        // Create a response team
        ResponseTeam team = new ResponseTeam("Rescue Squad", "Water Rescue");

        // Use services
        NotificationService notificationService = new NotificationService();
        DispatchService dispatchService = new DispatchService();
        
        // Simulate sending a notification
        notificationService.sendNotification(event);

        // Simulate dispatching a team
        dispatchService.dispatchTeam(team, event);

        // Test Case Management
        TestCaseManager testCaseManager = new TestCaseManager();
        
        // Create and add test cases
        TestCase test1 = new TestCase("DisasterEventTest", "Tests for DisasterEvent class");
        TestCase test2 = new TestCase("ResponseTeamTest", "Tests for ResponseTeam class");

        testCaseManager.addTestCase(test1);
        testCaseManager.addTestCase(test2);

        // Display all test cases
        System.out.println("Test Cases:");
        for (TestCase testCase : testCaseManager.getTestCases()) {
            System.out.println(testCase);
        }
    }
}
