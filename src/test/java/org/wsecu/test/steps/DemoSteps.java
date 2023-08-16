package org.wsecu.test.steps;

import java.util.HashMap;

import org.junit.Assert;
import org.wsecu.test.pages.POMFactory;
import org.wsecu.utilities.CommonUtility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps extends CommonUtility {

	HashMap uiProperties = environmentVariables.getYamlProperty("ui");
//	environmentVariables method is used here to read our Yaml files in my steps
//	The reason I used is for assertion between getCurrentURL with what I have in my setup environment
	
	@Given("User is on wsecu website")
	public void userIsOnWsecuWebsite() {

		Assert.assertEquals(getCurrentURL(), uiProperties.get("url").toString().toLowerCase());
		Assert.assertEquals(getTitle(), "The Credit Union for Washington: Join Us Today | WSECU");
		Assert.assertTrue(isElementDisplayed(POMFactory.getPomFactory().getDemoPage().homePageLogo));
		logger.info("user is on wsecu website");

	}

	@When("User enter incorrect username {string}")
	public void userEnterIncorrectUsername(String userNameValue) {
		sendText(POMFactory.getPomFactory().getDemoPage().homePageUserNameField, userNameValue);
		logger.info("User enter incorrect username  " + userNameValue);

	}

	@When("User click on {string} signIn button")
	public void userClickOnSignInButton(String pageName) {
		if (pageName.equalsIgnoreCase("homepage")) {
			click(POMFactory.getPomFactory().getDemoPage().homePageSignInBtn);
			logger.info("User click on " + pageName + " signIn button");
		} else if (pageName.equalsIgnoreCase("onlinebanking")) {
			click(POMFactory.getPomFactory().getDemoPage().OnlineBankingSignInBtn);
			logger.info("User click on " + pageName + " signIn button");
		}
		
		Assert.assertTrue(isElementDisplayed(POMFactory.getPomFactory().getDemoPage().userNameFIeld));
		Assert.assertTrue(isElementDisplayed(POMFactory.getPomFactory().getDemoPage().passwordField));
		Assert.assertTrue(isElementDisplayed(POMFactory.getPomFactory().getDemoPage().OnlineBankingSignInBtn));

	}

	@When("User verify redirected to the WSECU Online Banking website")
	public void userVerifyRedirectedtoTheWSECUOnlineBankingWebsite()  {
		Assert.assertTrue(waitforURL(uiProperties.get("expectedDigitalUrl").toString().toLowerCase()));
		Assert.assertEquals(getTitle(), "Sign in to Online Banking");
		waitTillPresence(POMFactory.getPomFactory().getDemoPage().onlineBankingLogo);
		Assert.assertTrue(isElementDisplayed(POMFactory.getPomFactory().getDemoPage().onlineBankingLogo));
		logger.info("User verified redirected to the WSECU Online Banking website");

	}

	@When("User enter incorrect password {string}")
	public void userEnterIncorrectPassword(String passwordValue) {
		sendText(POMFactory.getPomFactory().getDemoPage().passwordField, passwordValue);
		logger.info("User enter incorrect password  " + passwordValue);

	}

	@Then("User verifies that an error message appears {string}")
	public void userVerifiesThatAnErrorMessageAppears(String message) {
		waitTillPresence(POMFactory.getPomFactory().getDemoPage().SignInErrorMessage);
		Assert.assertEquals(getElementText(POMFactory.getPomFactory().getDemoPage().SignInErrorMessage), message);
		logger.info("User verifies that an error message appears" + message);

	}

}
