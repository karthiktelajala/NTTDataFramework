package genericActions;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot 
{
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try
		{
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File srcImage = screenshot.getScreenshotAs(OutputType.FILE);
			Files.copy(srcImage, new File(".\\Screenshots\\"+screenshotName+".jpeg"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
