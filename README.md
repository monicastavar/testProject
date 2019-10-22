# testProject

to run tests with reporting, go to desired module and run the following command:  mvn surefire-report:report
Result will be available in target\surefire-reports\emailable-report.html

API tests will all fail due to the fact that the service doesn't work as expected.
UI test from LoginTesta class loginWithRakutenUserID  will fail because login with id seems not to be working as expected

