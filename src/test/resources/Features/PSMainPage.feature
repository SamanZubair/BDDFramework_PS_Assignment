Feature: Contact Us Form

  Background:
    Given Publicis Sapient mainpage is opened

  Scenario: Submit the contact us form with valid details
    When Scroll down to the "Contact Us" section
    And Fill in the contact form with valid details
    And Submit the form
    Then Should see a success message after form submission

  Scenario: Navigate to Contact Us section and verify all the footer links
    When Scroll down to the footer section
    Then Should see 18 links in the Contact Us footer section
