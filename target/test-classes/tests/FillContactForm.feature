Feature: Contact us form

 Scenario: Fill details on the Contact us form

  Given I am at the Contact us page of the SecurePay Website
  When I enter details for all the fields
  Then I should be able to see the data I entered
  
 Scenario: Fill details on the Contact us form by navigating from google search

  Given I am at the Contact us page of the SecurePay Website from a google search
  When I enter details for all the fields
  Then I should be able to see the data I entered