package org.wsecu.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wsecu.base.BaseSetup;

public class CommonUtility extends BaseSetup {

	public WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	}

	public WebElement waitTillClickable(WebElement element) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitTillClickable(By by) {
		return this.getWait().until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement waitTillPresence(WebElement element) {
		return this.getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public Boolean waitforURL(String expectedURL) {
		return this.getWait().until(ExpectedConditions.urlContains(expectedURL));

	}

	public WebElement waitTillPresence(By by) {
		return this.getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void click(WebElement element) {
		this.waitTillClickable(element).click();
	}

	public void click(By by) {
		this.waitTillClickable(by).click();
	}

	public void sendText(WebElement element, String value) {
		this.waitTillPresence(element).sendKeys(value);

	}

	public String getElementText(WebElement element) {
		return this.waitTillPresence(element).getText();
	}

	public byte[] takeScreenShotAsBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public void sendText(By by, String value) {
		this.waitTillPresence(by).sendKeys(value);
	}

	public String getElementText(By by) {
		return this.waitTillPresence(by).getText();
	}

	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}

	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}

	public String getAttribute(WebElement ele, String Value) {
		String attribute = ele.getAttribute(Value);
		return attribute;
	}

	public String getTagname(WebElement ele) {
		return ele.getTagName();
	}

	public String getText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public boolean isElementDisplayed(WebElement ele) {
		if (ele.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementEnabled(WebElement ele) {
		if (ele.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementSelected(WebElement ele) {
		if (ele.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public void fluentwait(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(300)).ignoring(ElementNotInteractableException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
