package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 
{
	@FindBy(name="txtUsername")
	public WebElement txtUsername;
	
	@FindBy(id="txtPassword")
	public WebElement txtPassword;
	
	@FindBy(className="button")
	public WebElement btnLogin;
	
	@FindBy(linkText="Forgot your password?")
	public WebElement lnkForgotPassword;
	
	@FindBy(id="spanMessage")
	public WebElement msgErrorLogin;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
