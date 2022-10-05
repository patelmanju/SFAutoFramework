package com.SFProject.test.tests;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SFProject.test.base.SalesforceBaseScript;
import com.SFProject.test.utility.CommonUtility;

public class CaseScript extends SalesforceBaseScript {


@Test

	public static void T1sf() throws Exception{
	  
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		WebElement username = driver.findElement(By.id("username"));
		waitUntillVisibilityOf(username, "user name");
		username.sendKeys(sfDataFile.getProperty("username"));
		report.logTestInfo("username entered");
		
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("us entered");
		password.clear();

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "login button");

		report.logTestInfo("error message displayed");
		Testcompletted("T1sf");

	}


@Test

	public static void T2sf() throws IOException {
		salesforcelogin();
		report.logTestInfo("TestCase 2 Completed");
		Testcompletted("T2sf");

	}

@Test

	public static void T3sf() {
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		WebElement username = driver.findElement(By.id("username"));
		waitUntillVisibilityOf(username, "user name");
		username.sendKeys(sfDataFile.getProperty("username"));
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(sfDataFile.getProperty("password"));

		driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
		report.logTestInfo("Remember me checked");

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "login button");

		// user menu drop down
		driver.findElement(By.id("userNavLabel")).click();
		report.logTestInfo("user menu button clicked");

		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		report.logTestInfo("logout button clicked");

		Testcompletted("T3sf");

	}
@Test


	public static void T4asf() {

		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		
		WebElement username = driver.findElement(By.id("username"));
		waitUntillVisibilityOf(username, "user name");
		username.sendKeys(sfDataFile.getProperty("username"));

		driver.findElement(By.id("forgot_password_link")).click();
		report.logTestInfo("forgot password clicked");

		WebElement username2 = driver.findElement(By.id("un"));
		username2.sendKeys(sfDataFile.getProperty("username"));
		report.logTestInfo("username entered");

		driver.findElement(By.id("continue")).click();
		report.logTestInfo("continue clicked");

		driver.findElement(By.xpath(" //a[contains(text(),'Return to Login')]")).click();
		report.logTestInfo("return to login clicked");
		Testcompletted("T4asf");

	}

	@Test
	public static void T4bsf() {

		WebElement username = driver.findElement(By.id("username"));
		waitUntillVisibilityOf(username, "user name");
		username.sendKeys("123");
		report.logTestInfo("username entered");

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("22131");
		report.logTestInfo("password entered");

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "login button");
		report.logTestInfo("Please check your username and password. ");
		Testcompletted("T4bsf");

	}
@Test



public static void T5sf() throws IOException, InterruptedException {
	salesforcelogin();
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	WebElement homebutton = driver.findElement(By.xpath("//li[@id='home_Tab']"));
	waitByLocator(By.xpath("//li[@id='home_Tab']"));

	String expected = "Home";
	String actual = GetTextFromHomeElement(homebutton, "home button");
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	Assert.assertEquals(actual, expected);
	System.out.println("asert execute");
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	WebElement usermenu = driver.findElement(By.id("userNavLabel"));
	clickElement(usermenu, "user menu btn");
	report.logTestInfo("user menu button clicked");
	Testcompletted("T5sf");

}
@Test
	public static void T6sf() throws IOException, InterruptedException {
		salesforcelogin();
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "user menu btn");

		WebElement myprofile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		clickElement(myprofile, "my profile");
		report.logTestInfo("My Profile clicked");

		WebElement editbutton=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]"));
		clickElement(editbutton, "edit button");
		report.logTestInfo("edit button clicked");

		waitByLocator(By.xpath("//a[contains(text(),'About')]"));

		driver.switchTo().frame("contactInfoContentId");
		waitByLocator(By.xpath("//a[contains(text(),'About')]"));
		WebElement About = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		//waituntillclickable(About, "SaveAll btn");
		waitByLocator(By.xpath("//a[contains(text(),'About')]"));
		clickElement(About, "About Tab");
		report.logTestInfo("About button clicked");
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		waitByLocator(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));;
		entertext(lastname, "Nayak", "Last Name");
		waitUntillVisibilityOf(lastname, "SaveAll btn");
		WebElement SaveAll = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		clickElement(SaveAll, "SaveAll button");
	
		Thread.sleep(4000);
		//waituntillclickable(SaveAll, "SaveAll button");
		//waitUntillVisibilityOf(SaveAll, "SaveAll button");
		//waitByLocator(By.xpath("//a[@id='publisherAttachTextPost']"));
		
		WebElement Post = driver.findElement(By.xpath("//a[@id=\"publisherAttachTextPost\"]"));
		//waitUntillVisibilityOf(Post, "post");
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));
		Thread.sleep(3000);
		clickElement(Post, "Post link");
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.xpath(
				"//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(button);
		driver.switchTo().frame(
				"//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/iframe[1]");
		waitByLocator(By.xpath("//body"));
		driver.findElement(By.xpath("//input[@itemprop = 'query-input']")).sendKeys("Selenium Jobs");

		WebElement PostBody = driver.findElement(By.xpath("//body"));
		
		waitByLocator(By.xpath("//input[@id='publishersharebutton']"));
		entertext(PostBody, "Do Your Best", "post share");
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));
		driver.switchTo().defaultContent();
		WebElement Share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		clickElement(Share, "Share button");

		waitByLocator(By.xpath("//a[@id='chatterUploadFileAction']"));
		WebElement File = driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		clickElement(File, "file");
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement UploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		clickElement(UploadFile, "upload");
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));

		WebElement Browse = driver.findElement(By.cssSelector("#chatterFile"));
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));
		Browse.sendKeys("C:\\Users\\Narendra\\Downloads\\LoginHistory1663529355141.csv");
		WebElement Shareb = driver.findElement(By.cssSelector("#publishersharebutton"));
		clickElement(Shareb, "share btn");

		// Actions class with moveToElement()

		WebElement Mousehover = driver.findElement(By.id("photoSection"));
		// Actions class with moveToElement()
		Actions a = new Actions(driver);
		a.moveToElement(Mousehover).perform();

		// Click on Add photo link
		WebElement Uploadpic = driver.findElement(By.id("uploadLink"));
		clickElement(Uploadpic, "upload");
		driver.switchTo().frame("uploadPhotoContentId");
		report.logTestInfo("enttered in frame");
		waitByLocator(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		WebElement upimg = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		report.logTestInfo("finding file");
		//waitByLocator(By.xpath("//li[@id='home_Tab']"));
		upimg.sendKeys("C:\\Users\\Narendra\\Downloads\\LoginHistory1663529355141.csv");

	//	waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement saveimg = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:save']"));
		clickElement(saveimg, "savebtn");
		driver.switchTo().defaultContent();
		Testcompletted("T6sf");
		

	}
@Test

public static void T7sf() throws IOException, InterruptedException {
	salesforcelogin();
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	WebElement usermenu = driver.findElement(By.id("userNavLabel"));
	clickElement(usermenu, "user menu btn");

	WebElement MySettings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
	clickElement(MySettings, "My settings clicked");
	waitByLocator(By.xpath("//span[@id='PersonalInfo_font']"));
	WebElement PersonalLink = driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
	clickElement(PersonalLink, "Personal clicked");

	WebElement LoginHistory = driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
	clickElement(LoginHistory, "Login History clicked");
	waitByLocator(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
	WebElement DownLoadLoginHistory = driver
			.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
	clickElement(DownLoadLoginHistory, "Download clicked");

	Testcompletted("T7sf");

}
@Test

	public static void T8sf() throws IOException, InterruptedException {
		salesforcelogin();
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "user menu btn");

		// store instance of main window first using below code
		String winHandleBefore = driver.getWindowHandle();

		WebElement DeveloperConsole = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		clickElement(DeveloperConsole, "Devloper console");

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Perform the actions on new window
		// this will close new opened window
		driver.close();
		// switch back to main window using this code
		driver.switchTo().window(winHandleBefore);
		// perform operation then close and quit
		Testcompletted("T8sf");

	}
@Test

	public static void T9sf() throws IOException, InterruptedException {
		salesforcelogin();
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "user menu btn");
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		report.logTestInfo("logout button clicked");
		Testcompletted("T9sf");
	}
@Test

	public static void T10sf() throws IOException, InterruptedException {
		salesforcelogin();
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement Accounts = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waituntillclickable(Accounts, "account tab");
		clickElement(Accounts, "Account Tab");

		// store instance of main window first using below code
		String winHandleBefore = driver.getWindowHandle();
		WebElement popupclose = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		if (popupclose.isDisplayed()) {
			clickElement(popupclose, "popup window closed");
		}

		// Switch to new window opened
		// Perform the actions on new window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// switch back to main window using this code
		driver.switchTo().window(winHandleBefore);
		WebElement New = driver.findElement(By.name("new"));
		clickElement(New, "new btn");
		waitByLocator(By.xpath("//input[@id='acc2']"));
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='acc2']"));
		AccountName.sendKeys("salesforce pvt ltd");

		WebElement SelectType = driver.findElement(By.xpath("//select[@id='acc6']"));
		Select select = new Select(SelectType);
		select.selectByVisibleText("Technology Partner ");
		report.logTestInfo("tp selected");
		waitByLocator(By.xpath("//select[@id='00N4x00000WIIXq']"));

		WebElement Selectpriority = driver.findElement(By.xpath("//select[@id='00N4x00000WIIXq']"));
		Select selectp = new Select(Selectpriority);
		selectp.selectByVisibleText("High ");
		report.logTestInfo("priority selected");

		WebElement save = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickElement(save, "save btn");
		Testcompletted("T10sf");
		
	}
@Test

	public static void T11sf() throws IOException, InterruptedException {
		salesforcelogin();
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement Accounts = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waituntillclickable(Accounts, "account tab");
		clickElement(Accounts, "Account Tab");
		// store instance of main window first using below code
		String winHandleBefore = driver.getWindowHandle();
		WebElement popupclose = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		if (popupclose.isDisplayed()) {
			clickElement(popupclose, "popup window closed");
		}

		// Switch to new window opened
		// Perform the actions on new window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// switch back to main window using this code
		driver.switchTo().window(winHandleBefore);

		WebElement CreateNewAc = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickElement(CreateNewAc, "Create New Account clicked");
		waitByLocator(By.xpath("//input[@id='fname']"));
		WebElement view = driver.findElement(By.xpath("//input[@id='fname']"));
		entertext(view, "Bysecondcharactor", "view name ");
		waitByLocator(By.cssSelector("#devname"));
		WebElement viewUniqueName = driver.findElement(By.cssSelector("#devname"));
		entertext(viewUniqueName, "By2ndchar", "viewUN");
		waitByLocator(By.xpath("//li[@id='home_Tab']"));

		WebElement SaveView = driver.findElement(By.xpath(
				"//body[@class='hasMotif accountTab filterEdit FilterEditPage sfdcBody brandQuaternaryBgr']/div[@id='contentWrapper']/div[@class='bodyDiv brdPalette brandPrimaryBrd']/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/div[@class='bPageBlock brandSecondaryBrd bEditBlock secondaryPalette']/form[@id='editPage']/div[@class='pbHeader']/table/tbody/tr/td[@class='pbButtonb']/input[1]"));
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		clickElement(SaveView, "Savebtn");

		Testcompletted("T11sf");
	

	}
@Test

	public static void T12sf() throws IOException, InterruptedException {
		salesforcelogin();
		waitByLocator(By.xpath("//li[@id='home_Tab']"));
		WebElement Accounts = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waituntillclickable(Accounts, "account tab");
		clickElement(Accounts, "Account Tab");
		// store instance of main window first using below code
		String winHandleBefore = driver.getWindowHandle();
		WebElement popupclose = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		if (popupclose.isDisplayed()) {
			clickElement(popupclose, "popup window closed");
		}
		// Switch to new window opened
		// Perform the actions on new window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// switch back to main window using this code
		driver.switchTo().window(winHandleBefore);
		//Thread.sleep(3000);
		report.logTestInfo("switched to main window");
		 waitUntilVisibilityOf((By.cssSelector("#fcf")),"viewdropdown");
		WebElement viewDropDown = driver.findElement(By.cssSelector("#fcf"));
		//Thread.sleep(4000);
		selectOptionFromDropDown(viewDropDown, "My Accounts");
		report.logTestInfo(viewDropDown + " clicked");
		//Thread.sleep(6000);
		waitByLocator(By.linkText("Edit"));
		WebElement Editviewbtn = driver.findElement(By.linkText("Edit"));
		clickElement(Editviewbtn, "Edit button");

		WebElement Editviewnametxt = driver.findElement(By.xpath("//input[@id='fname']"));
		Editviewnametxt.sendKeys("My Accounts view");
		report.logTestInfo("Text entered");
		WebElement EditviewUniqnametxt = driver.findElement(By.xpath("//input[@id='devname']"));
		EditviewUniqnametxt.clear();
		EditviewUniqnametxt.sendKeys("MyAccountsview1");
		report.logTestInfo("Text Entered");
		WebElement saveview = driver.findElement(By.xpath(
				"//body[@class='hasMotif accountTab filterEdit FilterEditPage sfdcBody brandQuaternaryBgr']/div[@id='contentWrapper']/div[@class='bodyDiv brdPalette brandPrimaryBrd']/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/div[@class='bPageBlock brandSecondaryBrd bEditBlock secondaryPalette']/form[@id='editPage']/div[@class='pbHeader']/table/tbody/tr/td[@class='pbButtonb']/input[1]"));
		clickElement(saveview, "save btn");
		Testcompletted("T12sf");

	}
public static void T15sf() throws IOException, InterruptedException {
	salesforcelogin();
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	WebElement opportunities = driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
	waituntillclickable(opportunities, "opportunities tab");
	clickElement(opportunities, "opportunities Tab");
	// store instance of main window first using below code
	String winHandleBefore = driver.getWindowHandle();
	WebElement popupclose = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
	if (popupclose.isDisplayed()) {
		clickElement(popupclose, "popup window closed");
	}
	// Switch to new window opened
	// Perform the actions on new window
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

	// switch back to main window using this code
	driver.switchTo().window(winHandleBefore);
	WebElement oppertunitydropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
	waitUntillVisibilityOf(oppertunitydropdown, "opportunitie drop down");
	Select select = new Select(oppertunitydropdown);
	waitUntillVisibilityOf(oppertunitydropdown, "opportunitie drop down");
	int count = 0;
	String[] expecteddroplist = { "All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities",
			"New This Week", "Recently Viewed Opportunities", "Won" };
	List<WebElement> options = select.getOptions();
	for (WebElement we : options) {
		for (int i = 0; i < expecteddroplist.length; i++) {
			if (we.getText().equals(expecteddroplist[i])) {
				count++;
			}
		}
	}
	if (count == expecteddroplist.length) {
		System.out.println("matched");
	} else {
		System.out.println("not matched");
	}
	Testcompletted("T15sf");
}

public static void T24sf() throws IOException, InterruptedException {

	salesforcelogin();
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	WebElement Leads = driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
	waituntillclickable(Leads, "lead tab");
	clickElement(Leads, "lead Tab");
	// store instance of main window first using below code
	String winHandleBefore = driver.getWindowHandle();
	WebElement popupclose = driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
	if (popupclose.isDisplayed()) {
		clickElement(popupclose, "popup window closed");
	}
	// Switch to new window opened
	// Perform the actions on new window
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

	// switch back to main window using this code
	driver.switchTo().window(winHandleBefore);
	waitByLocator(By.xpath("//td[@class='pbButton']//input[@type='button']"));

	WebElement New = driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']"));
	waituntillclickable(New, "new btn");
	clickElement(New, "new btn");
	WebElement LastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
	LastName.sendKeys("ABCD");
	WebElement Company = driver.findElement(By.xpath("//input[@id='lea3']"));
	Company.sendKeys("ABCD");
	Thread.sleep(3000);
	WebElement Savebtn = driver.findElement(By.xpath(
			"//body[contains(@class,'ext-gecko ext-gecko3 sfdcBody brandQuaternaryBgr')]/div[@id='contentWrapper']/div[contains(@class,'bodyDiv brdPalette brandPrimaryBrd')]/table[@id='bodyTable']/tbody/tr/td[@id='bodyCell']/form[@id='editPage']/div[@id='ep']/div[contains(@class,'pbHeader')]/table[contains(@cellspacing,'0')]/tbody/tr/td[@id='topButtonRow']/input[1]"));
	clickElement(Savebtn, "Save button");

	String winHandleBefore1 = driver.getWindowHandle();

	// Switch to new window opened
	// Perform the actions on new window
	for (String winHandle1 : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle1);
	}
	String expected = "ABCD";
	WebElement leadlabel = driver.findElement(By.xpath("//h2[@class='topName']"));
	String actual = GetTextFromHomeElement(leadlabel, "ABCD");
	waitByLocator(By.xpath("//li[@id='home_Tab']"));
	Assert.assertEquals(actual, expected);

	// switch back to main window using this code
	driver.switchTo().window(winHandleBefore1);
	
			
}

}
	


	
		
