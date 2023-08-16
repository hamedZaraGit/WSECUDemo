package org.wsecu.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.wsecu.base.BaseSetup;

public class wsecuPages extends BaseSetup {

	public wsecuPages() {
		PageFactory.initElements(getDriver(), this);
	}

	// HomePage UI Elements
	
	@FindBy(css = ".header-logo")
	public WebElement homePageLogo;

	@FindBy(id = "digital-banking-username")
	public WebElement homePageUserNameField;

	@FindBy(xpath = "//input[@class = 'button']")
	public WebElement homePageSignInBtn;

	// Online Banking UI Elements
	
	@FindBy(xpath = "//h1[text() = 'Online Banking']")
	public WebElement onlineBankingLogo;

	@FindBy(xpath = "//input[@name='username']")
	public WebElement userNameFIeld;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordField;

	@FindBy(xpath = "//button[text() = ' Sign In ']")
	public WebElement OnlineBankingSignInBtn;

	@FindBy(xpath = "//div[text() = 'Sorry, incorrect username.']")
	public WebElement SignInErrorMessage;
}
