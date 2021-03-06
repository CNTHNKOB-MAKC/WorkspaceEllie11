package core.Selenium_ADV_Day_01;

//package inclass.wk02;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

	public class ManageReviews {
	  private WebDriver driver;
	  private String baseUrl;

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://hrm.seleniumminutes.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testCheckRowStyles() throws Exception {
	    driver.get(baseUrl + "/symfony/web/index.php/auth/login");
	    WebElement username_field = driver.findElement(By.id("txtUsername"));
	    type(username_field, "admin");
	    WebElement password_field = driver.findElement(By.id("txtPassword"));
	    type(password_field, "Password");
		driver.findElement(By.id("btnLogin")).click();
		
		
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// this is the action chain when the element has to appear before to be chosen and selected
		Actions action = new Actions(driver);
		WebElement performance = driver.findElement(By.id("menu__Performance"));
		WebElement manage_reviews_menu = driver.findElement(By.id("menu_performance_ManageReviews"));
		WebElement manage_reviews_submenu = driver.findElement(By.id("menu_performance_searchPerformancReview"));
		action.moveToElement(performance).moveToElement(manage_reviews_menu).click(manage_reviews_submenu);
		action.perform();
		
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// scrall into view using Java Script
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('resultTable').scrollIntoView()");
		Thread.sleep(2000);
		
	  }
	  
		@After
		public void tearDown() throws Exception {
			driver.quit();
		}
		
		private void type(WebElement element, String str) {
		    element.clear();
		    element.sendKeys(str);
		}

}
