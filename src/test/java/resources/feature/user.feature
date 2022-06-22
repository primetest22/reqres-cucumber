Feature: Testing different request on reqres application

  Scenario: check reqres application accessed by user
    When User send GET request to user endpoint
    Then User must get a valid status code 200

  Scenario: check i can access single user
    When User send GET request to get single user with id 12
    Then User should validate status code 200

  Scenario Outline: Check user can create new user
    When User send POST request with email "<email>" firstname "<first_name>" lastname "<last_name>" avatar "<avatar>"
    Then User must get a valid status code 201
  Examples:
            |        email          |  first_name  |  last_name  |             avatar                          |
            |mahendradhoni@gmail.com|  Mahendra    |  Dhoni      |https://reqres.in/img/faces/1-image.jpg      |

  Scenario Outline: Check user can login successfully
    When User send POST request with email"<email>" password "<password>"
    Then User should validate status code 200
  Examples:
            |      email             |   password |
            |      eve.holt@reqres.in|  cityslicka|