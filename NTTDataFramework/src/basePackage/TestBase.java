package basePackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{
		public FileInputStream fis;
		public WebDriver driver;
		public Properties properties = new Properties();
		public String log4jPath = "Log4jProperties";
		public static final Logger log = Logger.getLogger(TestBase.class.getName());
		
		public void initializeTest()
		{
			try
			{
				PropertyConfigurator.configure(log4jPath);
				fis = new FileInputStream("./config");
				properties.load(fis);
				
				String browser = properties.getProperty("browser");
				String url = properties.getProperty("url");
				
				openBrowser(browser);
				log.info(browser+" browser is launched.");
				getURL(url);
				log.info("Navigated to the URL: "+url);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public void openBrowser(String browser)
		{
			if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			log.info("Browser is maximized.");
			
			//Implicit Wait
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		
		public void getURL(String url)
		{
			driver.get(url);
		}
		
		public void closeBrowser() 
		{
			driver.close();
			log.info("Browser Closed.");
		}
}
