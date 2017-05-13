Feature:

  Scenario: Sample scenario
    Given Launch the App
    Then Check/Validate second item in the list is "Chicken and Potatoes"
    And it has 5* Rating
    When Click on the first line Item "Caprese Salad"
    And Change the name to "My Salad"
    And Give 2* rating
    And Click Save
    Then verify that my Salad has 2* rating