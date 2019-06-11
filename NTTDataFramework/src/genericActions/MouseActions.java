package genericActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	public static Actions act;
	 public static void mouseHover(WebDriver driver, WebElement element)
	 {
		act = new Actions(driver);
		act.moveToElement(element).perform();
	 }
 
	 public static void rightMouseClick(WebDriver driver, WebElement element)
	 {
		 act = new Actions(driver); 
//		 act.moveToElement(element).contextClick().build().perform();
		 //or
		 act.contextClick(element).perform();
	 }
 
	 public static void dragAndDrop(WebDriver driver, WebElement dragElement, WebElement dropElement)
	 {
		 act = new Actions(driver);
		 act.dragAndDrop(dragElement, dropElement).perform();
		 //or
//		 act.moveToElement(dragElement).clickAndHold().moveToElement(dropElement).release().build().perform();
		 //or
//		 act.clickAndHold(dragElement).release(dropElement).build().perform();
	 }
}
