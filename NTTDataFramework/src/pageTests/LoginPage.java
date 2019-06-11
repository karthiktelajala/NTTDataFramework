package pageTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.TestBase;
import genericActions.ExcelFile;
import genericActions.Screenshot;
import pageActions.LoginPageActions;

public class LoginPage extends TestBase
{
	String filePath = "./TestData/Credentials.xlsx";
	LoginPageActions loginPageActions;
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	@BeforeMethod
	public void startTest()
	{		log.info("Initializing the new Test Execution.");
			initializeTest();	
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials()
	{
			loginPageActions = new LoginPageActions(driver);
			Screenshot.captureScreenshot(driver, "LoginPage");
			
			String username = ExcelFile.readExcel(filePath, 0, 1, 0);
			String password = ExcelFile.readExcel(filePath, 0, 1, 1);
			loginPageActions.loginOrangeHRM(username, password);
			Screenshot.captureScreenshot(driver, "HomePage");
			
			String expTitle = "OrangeHRM";
			String actTitle = driver.getTitle();
			log.info("Comparing the actual Title - "+actTitle+" wtih expected Title - "+expTitle);
			Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		String username = ExcelFile.readExcel(filePath, 0, 2, 0);
		String password = ExcelFile.readExcel(filePath, 0, 2, 1);
		loginPageActions.loginOrangeHRM(username, password);
		Screenshot.captureScreenshot(driver, "ErrorLoginPage");
		
		String expError = "Invalid credentials";
		String actError = loginPageActions.getErrorMessage();
		log.info("Comparing the actual Error - "+actError+" wtih expected Error - "+expError);
		Assert.assertEquals(actError, expError);	
	}
	
	@AfterMethod
	public void endTest()
	{
		closeBrowser();
	}
}
