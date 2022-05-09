@newCustomer
Feature: validate the new customer features

  @addNewCustomer
  Scenario: Add new customer by manager
  Given user logged into application succesfully
  When click on "New Customer" tab
  And Fill all the customer details
  Then validate new customer got created
  
  @editCustomer
  Scenario: Edit the customer
  Given user logged into application succesfully
  When click on "Edit Customer" tab
  And search the customer to perform edit
  And edit the address of the customer
  Then validate address got edited