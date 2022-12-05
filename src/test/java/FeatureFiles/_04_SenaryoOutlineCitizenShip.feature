#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız.
#Daha sonra Bilgileri siliniz
#Yukarıdaki işlemleri Parameter yöntemi ile yapınız.

Feature: Citizenship with scenario Outline

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly
    And Navigate to CitizenShip page

    @Regression
  Scenario Outline: CitizenShip Create
    When User a CitizenShip name as "<Name>" short name as "<ShortName>"
    Then Success message should be displayed

    When User a CitizenShip name as "<Name>" short name as "<ShortName>"
    Then Already exist message should be displayed

    When User delete the "<Name>"
    Then Success message should be displayed

    Examples:
      | Name    | ShortName |
      | vatIs11 | isVat11   |
      | vatIs21 | isVat12   |
      | vatIs31 | isVat13   |
      | vatIs41 | isVat14   |
