package org.wsecu.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.wsecu.utilities.ReadYamlFiles;

public class BaseSetup {

	private static WebDriver webDriver;
	protected final ReadYamlFiles environmentVariables;
	public static Logger logger;

	public BaseSetup() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed for Load environment context. check possible file path errors");
			throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());
		}

		logger = Logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);
	}

	public WebDriver getDriver() {
		return webDriver;
	}
	
	public void setupBrowser() {
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
		String url = uiProperties.get("url").toString().toLowerCase();
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperties.get("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				webDriver = new ChromeDriver(options);
			} else {
				webDriver = new ChromeDriver();
			}
			break;
		case "firefox":
			webDriver = new FirefoxDriver();
			break;
		case "edge":
			webDriver = new EdgeDriver();

			break;
		default:
			throw new RuntimeException("Unknown Browser check environment properties");

		}

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.of(30, ChronoUnit.SECONDS));
		webDriver.get(url);
	}

	public void quitBrowser() {
		if (webDriver != null)
			webDriver.quit();
	}

}
