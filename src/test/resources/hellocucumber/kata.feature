Feature: kata
  I want to know how much I will pay for theses books

  Scenario: Discount of 0% for 1 book
    Given A cart
    When I add a book to the cart
    Then The cart price is 8 euros

  Scenario: Discount of 5% for 2 different books
    Given A cart
    When I add a book of volume 1 to the cart
      And I add a book of volume 2 to the cart
    Then The cart price is 15.2 euros

  Scenario:  Discount of 10% for 3 different books
    Given A cart
    When I add a book of volume 1 to the cart
      And I add a book of volume 2 to the cart
      And I add a book of volume 3 to the cart
    Then The cart price is 21.60 euros

  Scenario: Discount of 20% for 4 different books
    Given A cart
    When I add a book of volume 1 to the cart
      And I add a book of volume 2 to the cart
      And I add a book of volume 3 to the cart
      And I add a book of volume 4 to the cart
    Then The basket price is 25.60 euros

  Scenario: Discount of 25% for 5 different books
    Given A cart
    When I add a book of volume 1 to the cart
      And I add a book of volume 2 to the cart
      And I add a book of volume 3 to the cart
      And I add a book of volume 4 to the cart
      And I add a book of volume 5 to the cart
    Then The cart price is 30 euros

  Scenario: Discount of 1 set of 2 books and 1 set of 1 book
    Given A cart
    When I add 2 books of volume 1 to the cart
      And I add 1 book of volume 2 to the cart
    Then The cart price is 23.20 euros

  Scenario: Discount of 1 set of 2 books and 2 sets of 1 book
    Given A cart
    When I add 2 books of volume 1 to the cart
    And I add 1 book of volume 2 to the cart
    And I add 1 book of volume 3 to the cart
    Then The cart price is 29.60 euros

  Scenario: Discount of 3 sets of 2 books and 2 sets of 1 book
    Given A cart
    When I add 2 books of volume 1 to the cart
      And I add 2 books of volume 2 to the cart
      And I add 2 books of volume 3 to the cart
      And I add 1 book of volume 4 to the cart
      And I add 1 book of volume 5 to the cart
    Then The cart price is 51.20 euros
