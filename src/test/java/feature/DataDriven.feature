Feature: data driven testing

  Scenario Outline: user mentions current address and permanet address
    When user enter address home number "<homeNo>" and postal pin "<postalPin>" and "<City>"

    Examples: 
      | homeNo | postalPin | City     |
      |     72 |    573201 | Hassan   |
      |     44 |    785412 | Benglore |
      |     66 |     12345 | Goa      |
      
   
