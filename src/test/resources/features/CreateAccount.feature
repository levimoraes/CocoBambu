#language: en
#encoding: UTF-8
@TestAutomationDemo
Feature: Create Account

  Background:
    Given are on the application's login page

  @login
  Scenario: Happy Path
    And click on button Cadastre-se
    And complete Name field
    And complete Mail field
    And type "L&vi1234" on Passwordfield
    And type "L&vi1234" on ConfirmPasswordfield
    And select Distrito Federal on State
    And checkbox Terms and Conditions
    And click on Cadastrar
    Then should appear confirmation message

  @login
  Scenario Outline: Invalid Fields
    And click on button Cadastre-se
    And type <name> on CompleteNamefield
    And type <email> on Emailfield
    And type <password> on Passwordfield
    And type <repeat_password> on ConfirmPasswordfield
    Then should appear <msg> message

    Examples:
      |name                     |email                            |password  |repeat_password|msg                                         |
      |"1234 56789"             |"bcljjywyaeinlybzyr1@tpwlb.com"  |"L&vi1234"|"L&vi1234"     |"Nome completo possui caracteres inválidos."|
      |"Levi Moraes"            |"bcljjywyaeinlybzyr@tpwlb.com"   |"L&vi1234"|"L&vi1234"     |"E-mail já cadastrado."                      |
      |"Levi Moraes"            |"bcljjywyaeinlybzyr3@tpwlb.com"  |"L"       |"L"            |"Senha deve conter no mínimo 6 caracteres." |
      |"Levi Moraes"            |"bcljjywyaeinlybzyr4@tpwlb.com"  |"123456"  |"123456"       |"Sua senha deve conter no mínimo 1 caractere maiúsculo." |
