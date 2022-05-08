@loginTestCase
Feature: To test the login scenarioes

@loginValid
Scenario: validate login with valid credentials
Given user should validate the title of the page
When  enter the username
And  enter the password
And click on login button
Then validate user logged into application succesfully

