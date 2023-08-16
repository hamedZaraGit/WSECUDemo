Feature: WSECU QA Engineer Homework

	@test
  Scenario: Veriy user can not login with incorrect Credential
    Given User is on wsecu website
    When User enter incorrect username 'thisuserwillnotwork'
    And User click on 'Homepage' signIn button
    And User verify redirected to the WSECU Online Banking website
    And User enter incorrect password 'thispasswillfailforsure'
    And User click on 'OnlineBanking' signIn button
    Then User verifies that an error message appears 'Sorry, incorrect username.'
