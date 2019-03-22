@API
Feature: apiJSONPlaceholder

  Scenario: User calls webservice and gets chosen email in response
    Given Webservice is up and running
    When  GET call is performed on /comments endpoint
    Then  Response is received with status code 200
    And   Response is not empty
    And   Response contains the following fields
      | email | Jayne_Kuhic@sydney.com |

  Scenario Outline: User is able to get filtered response
    Given Webservice is up and running
    When  GET call is performed on /comments endpoint
    Then  Response is received with status code 200
    And   Response is filtered by <postId> and 'body' that contains <text>
    And   User should see only data that matches filter parameters <postId> amd 'body' that contains <text>

    Examples:
      | postId | text  |
      | 1      | non   |
      | 20     | culpa |