#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.

Feature: Fee Functionality (DataTable - Scenario Outline)

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

  Scenario Outline: Fee Functionality
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | feesSetup  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in the Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name       | code    | intCode   | priority |
      | IsmetFee11 | 0100111 | paypal1    | 9421      |
      | IsmetFee21 | 0100220 | applePay1  | 9651      |
      | IsmetFee31 | 0233331 | googlePay1 | 9531     |
