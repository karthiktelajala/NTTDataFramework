package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects
{
	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}
	
	public void loginOrangeHRM(String username, String password)
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void clickForgotPassword()
	{
		lnkForgotPassword.click();
	}
	
	public String getErrorMessage()
	{
		return msgErrorLogin.getText();
	}
	
	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
}
