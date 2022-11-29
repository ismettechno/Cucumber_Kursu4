Feature: Datatable Functionality

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

  Scenario: Create Country
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | ismet343434 |
      | codeInput | i43434      |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | ismet343434 |


    Scenario: Create a Nationality
      And Click on the element in left nav
        | setupOne   |
        | parameters |
        | nationalities  |

      And Click on the element in the Dialog
        | addButton |

      And User sending the keys in Dialog content
        | nameInput | ismet343434 |

      And Click on the element in the Dialog
        | saveButton |

      And Success message should be displayed

      And User delete item from Dialog
        | ismet343434 |