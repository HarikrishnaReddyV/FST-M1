@activity1
  Feature: Activity1
    Scenario: Searching for cheese on Google
      Given User is on the Google webpage
      When User types in cheese and hit enter
      Then User should see how many search results were found
      And The browser should close