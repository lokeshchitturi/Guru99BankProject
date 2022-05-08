@loginTestCase
Feature: To test the login scenarioes

  @loginValid
  Scenario: validate login with valid credentials
    Given user should validate the title of the page
    When enter the username
    And enter the password
    And click on login button
    Then user logged into application succesfully

  @passwordErrorValidaion
  Scenario: Validate password error message
    Given user should validate the title of the page
    Then validate error message by submitting only username
    
    
  @logout
  Scenario: Logout of the application
  When user logged into application succesfully
  And click on "Log out" tab
  Then user logout from application succcesfully
