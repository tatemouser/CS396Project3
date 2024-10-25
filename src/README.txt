Checklist!
    Github Actions 
    JUnit Library added with simple test implemented into actions on commits
    Jacoco Library added with simple report implemented into actions on commits
        Creates report under details on github actions for that actions, under artificats
        Can extract folder and open index file to see web report

RUNNING JUST BASIC HOSPITAL APPLICATION COMMANDS
    javac -d bin src/models/*.java src/services/*.java src/main/*.java
    java -cp bin main.MainApplication

    Add JUNIT --> Ctrl-Shift-P, add library to two jar files in libs folder.
        Simple test to check JUNIT install
        javac -cp "libs/junit-4.13.2.jar;libs/hamcrest-core-1.3.jar;." test/DisasterEventTest.java
        java -cp "libs/junit-4.13.2.jar;libs/hamcrest-core-1.3.jar;." org.junit.runner.JUnitCore test.DisasterEventTest


Test automation framework to enahance code quality.
    For disaster response coordination system. 
    * automated unit, integration, system tests to itdentify defects early in development process
        Improve software reliability and reduce time to deployment
    
    Functional -
        * support creation and execution of automated unit tests for individual componenets
            within disaster response coordination application to ensure each unit functions correctly in isolation
        * Framework to faciliate automated integration testing to verify different componenets of application
            work together as indended, data flows correctly between modules
        * System must provide mechanisim for managing test cases
            allowing developes to create, modify, and organize test cases 
        * Seamlessly integrate with existing CI/CD pipeline to enable auto-matic trigger of test execution
            upon code commits and pull requests, immediate feedback
        * Must generate detailed reports on test results 
            (pass/fail rates, code coverage metrics, historical trneds, allowing team to identify areas of imporvement)
        
1. Build java application
    src/
        models/ (e.g., DisasterEvent.java, ResponseTeam.java)
        services/ (e.g., NotificationService.java, DispatchService.java)
        main/ (e.g., MainApplication.java)

2. Set up devops
    CI/CD Pipeline - Github Actions
    Automated Testing Framework 
        JUnit (unit testing) (could use TestNG for more complex testing)
        Selenium (integration and system testing)
    Test Execution and Reporting
        Add test to CI/CD pipeline to automattically run test on commits
        Could use pluggins like Jacoco or Allure for detailed test result reporting