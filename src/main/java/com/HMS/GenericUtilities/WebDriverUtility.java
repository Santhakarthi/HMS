package com.HMS.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of all the re usable methods related to web driver actions
 * @author user
 *
 */
public class WebDriverUtility {
   /**
    * This method will maximize the window
    * @param driver
    */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait until the page gets loaded
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver,int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	/**
	 * This method will wait until the url of the page get loaded
	 * @param driver
	 * @param duration
	 * @param expectedurl
	 */
	public void waitUntilUrl(WebDriver driver, int duration,String expectedurl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
	}
	
	/**
	 * This method will wait until the title of the page get loaded
	 * @param driver
	 * @param duration
	 * @param expectedtitle
	 */
	 public void witUntilTitle(WebDriver driver,int duration,String expectedtitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedtitle));	 
	 }
	
	 /**
	  * This method will until the element to be clickable
	  * @param driver
	  * @param duration
	  * @param element
	  */
     public void waitUntilElementToBeClickable(WebDriver driver,int duration,WebElement element) {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
     }
     
     /**
      * This method will ignores the NoSuchElementException and continuous execution
      * @param driver
      * @param duration
      */
     public void ignoreNoSuchElementException(WebDriver driver,int duration) {
    	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
    	 wait.ignoring(NoSuchElementException.class);
     }
     
     /**
      * 
      * @param element
      * @throws InterruptedException
      */
     public void customWait(WebElement element) throws InterruptedException {
    	 int count =0;
    	 while(count<20)
    	 {
    		 try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
    	 }  		 
     }
     
     /**
      * This method will select WebElement based on index values
      * @param element
      * @param index
      */
   public void dropDownHandling(WebElement element,int index)  {
	 
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
     
   /**
    * This method will select the WebElement based on value
    * @param element
    * @param value
    */
   public void dropDownHandling(WebElement element,String value)  {
	   Select sel=new Select(element);
	   sel.selectByValue(value);
   }
    
   /**
    * This method will select the WebElement based on Visible Text
    * @param text
    * @param element
    */
   public void dropDownHandling(String text,WebElement element)  {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
   }
     
   /**
    * This method will take mouse cursor to a particular element  
    * @param driver
    * @param element
    */
   public void moveToElement(WebDriver driver,WebElement element)  {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();;
   }
     
   /**
    * This method will perform right click operation on webpage
    * @param driver
    * @param element
    */
   public void rightClickOperation(WebDriver driver)  {
	   Actions act =new Actions(driver);
	   act.contextClick().perform();;
   }
   
   /**
    * This method will perform enter operation
    * @param driver
    */
   public void enterKey1(WebDriver driver) {
	   Actions act=new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();;
   }
   
   public void doubleClick(WebDriver driver) {
	   Actions act=new Actions(driver);
	   act.doubleClick().perform();
   }
   
   /**
    * This method will drag the source element to the target element
    * @param driver
    * @param srcElement
    * @param targetElement
    */
   public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement targetElement) {
	   Actions act=new Actions(driver);
	   act.dragAndDrop(srcElement, targetElement).perform();
   }
   
   /**
    * This method is used to move the cursor anywhere on the web page based on offset value
    * @param driver
    * @param xOffset
    * @param yOffset
    */
   public void dragAndDrop(WebDriver driver,int xOffset,int yOffset) {
	   Actions act=new Actions(driver);
	   act.moveByOffset(xOffset, yOffset).perform();
   }
   
   /**
    * This method will switch to one frame to another frame using index
    * @param driver
    * @param index
    */
   public void switchFrame(WebDriver driver,int index) {
	   driver.switchTo().frame(index);
   }
   
   /**
    * This method will switch to one frame to another frame using WebElement
    * @param driver
    * @param element
    */
   public void switchFrame(WebDriver driver,WebElement element) {
	   driver.switchTo().frame(element);
   }
    
   /**
    * This method will switch to Parent frame
    * @param driver
    */
   public void switchToParentFrame(WebDriver driver) {
	  driver.switchTo().parentFrame();
   }
   
   /**
    * This method will help to switch the control back to current page
    * @param driver
    */
   public void switchToDefaultPage(WebDriver driver) {
	   driver.switchTo().defaultContent();
   }
   
   /**
    * This method will help to accept the Alert popup
    * @param driver
    */
   public void acceptAlert(WebDriver driver) {
	   Alert alt=driver.switchTo().alert();
	   alt.accept();
   }
   
   /**
    * This method will help to cancel the Alert popup
    * @param driver
    */
   public void cancelAlert(WebDriver driver) {
	   Alert alt=driver.switchTo().alert();
	   alt.dismiss();
   }
   
   /**
    * This method will help to capture the Alert message
    * @param driver
    */
   public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
   
   /**
    * This method will switch window based on title
    * @param driver
    * @param expectedTitle
    */
   public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle) {
	   Set<String> set = driver.getWindowHandles();
	   for (String str : set)
	   {
	   driver.switchTo().window(str);
	   String title = driver.getTitle();
	   if (title.contains(expectedTitle))
	   {
		break;
	}
  }
 }
   
   /**
    * This method will switch window based on url
    * @param driver
    * @param expectedUrl
    */
   public void switchToWindowBasedOnUrl(WebDriver driver,String expectedUrl) {
	  Set<String> set = driver.getWindowHandles();
	  Iterator<String> itr = set.iterator();
	  while(itr.hasNext()) {
		  String wid = itr.next();
		  driver.switchTo().window(wid);
		  String url = driver.getCurrentUrl();
		  if (url.contains(expectedUrl)) {
			break;
		}
	  }
	   
   }
   
   /**
    * This method is used to Scroll to a particular Element
    * @param driver
    * @param element
    */
   public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");", element);
		
		//js.executeScript("arguments[0].scrollIntoView();", element);
	}
   
   /**
    * This method will take screen shot and return the absolute path of it
    * @param driver
    * @param screenshotName
    * @return
    * @throws IOException
    */
   public static  String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
   {
	  TakesScreenshot ts= (TakesScreenshot)driver;
	  File src=  ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File(".\\Screenshot\\"+screenshotName+".png");
	  Files.copy(src, dest);  //this class from commons IO tool
	  return dest.getAbsolutePath();  //attach the screen shot to extent reports
	  
   }
  
   
   /**
    * This method will perform right click operation on particular webElement
    * @param driver
    * @param element
    */
   public void rightClick(WebDriver driver,WebElement element) {
	   Actions act=new Actions(driver);
	   act.contextClick(element);
   }
   
   /**
    * This method will perfrom press Enter
    * @param driver
    * @throws Throwable
    */
   public void enterKey(WebDriver driver) throws Throwable {
	   Robot rb=new Robot();
	   rb.keyPress(KeyEvent.VK_ENTER);;
	   
   }
   
   /**
    * This method will perfrom release Enter
    * @param driver
    * @throws Throwable
    */
   public void enterRelease(WebDriver driver) throws Throwable {
	   Robot rb=new Robot();
	   
	   rb.keyRelease(KeyEvent.VK_ENTER);
	   
   }
}



