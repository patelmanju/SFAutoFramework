package com.SFProject.test.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.SFProject.test.utility.CommonUtility;
import com.SFProject.test.utility.GenerateReports;
import com.SFProject.test.utility.constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceBaseScript {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static WebElement usermenu = null;
	public static Logger logger = LogManager.getLogger(SalesforceBaseScript.class);
	public static GenerateReports report=null;

	@BeforeTest
	public static void setupBeforeTest() {
		report = GenerateReports.getInstance();
		report.startExtentReport();
	}

	@Parameters({ "browserName" })
	@BeforeMethod
		
	public static void setUp(String browserName, Method m) {

		report.startSingleTestReport(m.getName());
		setDriver(browserName);
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		String url = CU.getApplicationProperty("URL", sfDataFile);
		gotoUrl(url);
		waitUntilPageLoads();
		//report.logTestInfo("Before method execution is started");
	}

	@AfterMethod
	public static void tearDown() {
		report.logTestInfo("after method execution is started");
		closeAllbrowser();
	}

@AfterTest
	public static void teardownAfterTest() {
		report.endReport();
	}

	public static void setDriver(String browser) {
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			report.logTestInfo("Enter correct browser name");
			break;

		}
	}

	public static void salesforcelogin() throws IOException {
		waitUntilPageLoads();
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		WebElement username = driver.findElement(By.id("username"));
		waitUntillVisibilityOf(username, "user name");
		username.sendKeys(sfDataFile.getProperty("username"));
		report.logTestInfo("username entered");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(sfDataFile.getProperty("password"));
		report.logTestInfo("password entered");
		WebElement loginbutton = driver.findElement(By.id("Login"));
		loginbutton.click();
		report.logTestInfo("login button clicked");
		driver.manage().window().maximize();
	}

	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static WebDriver getDriverInstense() {
		return driver;
	}

	public static void gotoUrl(String url) {
		driver.get(url);
	}

	public static String readText(WebElement element, String objectName) {
		waitUntilVisible(element, objectName);
		String hometab = element.getText();
		return hometab;
	}

	public static String captureWebElementScreenshot(WebElement elementLogo, String filename) {

		File src = elementLogo.getScreenshotAs(OutputType.FILE);
		File dest = new File(constants.SCREENSHOT_PATH + "/" + filename + ".jpg");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException exception) {
			report.logTestFailedWithException(exception);
		}
		return dest.getAbsolutePath();
	}

	public static String captureWebElementScreenshot1(WebElement elementLogo) {
		SimpleDateFormat df = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
		Date date = new Date();
		String curDataAndTime = df.format(date);
		File src = elementLogo.getScreenshotAs(OutputType.FILE);
		report.logTestInfo("web element screenshot captured");
		File dest = new File(constants.SCREENSHOT_PATH + "/" + curDataAndTime + ".jpg");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	public static String GetTextFromHomeElement(WebElement WebElement, String String) {
		String label = readText(WebElement , String);
		String path = captureWebElementScreenshot(WebElement, String );
		try {
			report.attachScreeshot(path);
		} catch (IOException e) {
			report.logTestFailedWithException(e);
		}
		return label;
	}

	public static void entertext(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			report.logTestInfo("text entered in " + objName + "field");
		} else {
			report.logTestFailed("fail" + objName + "element not displayed");

		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {

			element.clear();
			report.logTestInfo("pass " + objName + "is cleared");

		} else {
			report.logTestInfo("fail" + objName + "element not displayed");

		}
	}

	public static void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {

			element.click();
			report.logTestInfo("pass " + objName + " element clicked");

		} else {
			report.logTestInfo("fail" + objName + "element not clicked");
		}
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllbrowser() {
		driver.quit();
	}

	public static void waitUntillVisibilityOf(WebElement locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public static void waitUntilVisible(WebElement element, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitByLocator(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void waitUntillclickable(WebElement locator) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// presenceOfElementLocated condition chaged to this
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waituntillclickable(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waituntillclickable(WebElement element, String objname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitUntilVisibilityOf(By locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void switchToWindowOpned(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
		System.out.println("switched to new window");
	}

	public static void moveToElement(WebElement element, String objectName) {
		waitUntilVisible(element, objectName);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		report.logTestInfo("moved to " + objectName);

	}

	public static void selectOptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;

			}
		}

	}

	public static void Testcompletted(String testname) {
		testname = null;
		report.logTestInfo(testname + "completed");

	}
}
