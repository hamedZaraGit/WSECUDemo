package org.wsecu.test.base;

import org.wsecu.test.pages.POMFactory;
import org.wsecu.utilities.CommonUtility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class BaseUITest extends CommonUtility {

	@Before
	public void setupTests() {
		super.setupBrowser();
	}

	@After
	public void closeTests(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenShot = takeScreenShotAsBytes();
			scenario.attach(screenShot, "image/png", scenario.getName() + "scenario Failed");

		}
		super.quitBrowser();
	}

	 @AfterStep
	public void afterStep(Scenario scenario) throws InterruptedException {
		 // Fluent wait is utilized here for an issue regarding taking screenshots in each step
		 fluentwait(POMFactory.getPomFactory().getDemoPage().homePageLogo);
		byte[] screenShot = takeScreenShotAsBytes();
		scenario.attach(screenShot, "image/png", scenario.getName() + "scenario step");

	}

}
