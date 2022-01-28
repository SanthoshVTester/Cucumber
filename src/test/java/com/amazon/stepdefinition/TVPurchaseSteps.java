package com.amazon.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TVPurchaseSteps {


	static WebDriver driver;
	@Given("user Launches Amazon Applications")
	public void user_Launches_Amazon_Application() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Launched");
		
		
	}

	
	
	@When("user Search Tv")
	public void user_Search_Tv() {
		String name="Sony";
		
		WebElement search=driver.findElement(By.xpath("//input[@type='text']"));
			search.sendKeys((name),Keys.ENTER);
			}

	static String mob1;
	@When("user click on TVName")
	public void user_click_on_TVName() {
		WebElement mobName=driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color')])[1]"));
		mob1=mobName.getText();
		System.out.println(mob1);
		mobName.click();
		
		String CWin=driver.getWindowHandle();
		
		Set<String> allWin=driver.getWindowHandles();
		for(String x:allWin) {
			if(!x.equals(CWin)) {
				driver.switchTo().window(x);
				System.out.println("Window Switched");
			}
		}
		
	}
	@Then("user click on BuyNow")
	public void user_click_on_BuyNow() {
		WebElement buyNow =driver.findElement(By.xpath("//input[@id='buy-now-button']"));
	    boolean b=buyNow.isDisplayed();
	    System.out.println(b);
	    buyNow.click();
	    driver.quit();
	   System.out.println("End");
	}
}

