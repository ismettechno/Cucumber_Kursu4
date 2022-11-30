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

    Then Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element in left nav
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | ismet343434 |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | ismet343434 |

    Then Success message should be displayed


      # TODO :  Create a Fee, delete Fee
  Scenario: Fee Functionality
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | feesSetup  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | ismetfee1 |
      | codeInput       | 1211      |
      | integrationCode | 12112     |
      | priorityCode    | 122       |

    And Click on the element in the Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | ismetfee1 |

    Then Success message should be displayed

      #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
      #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.
