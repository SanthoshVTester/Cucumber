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

public class MobilePurchaseSteps {
	
	static WebDriver driver;
	@Given("user Launches Amazon Application")
	public void user_Launches_Amazon_Application() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Launched");
		
		
	}
	
	@When("user Search mobile")
	public void user_Search_mobile() {
		String name="redmi";
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys((name),Keys.ENTER);
		
		
	}
	static String mob1;
	@When("user click on MobileName")
	public void user_click_on_MobileName() {
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
	@Then("user click on BuyNow option")
	public void user_click_on_BuyNow_option() {
		WebElement buyNow =driver.findElement(By.xpath("//input[@id='buy-now-button']"));
	    boolean b=buyNow.isDisplayed();
	    System.out.println(b);
	    buyNow.click();
	    driver.quit();
	   System.out.println("End");
	}
	
	@When("user Search mobile by one dim list")
	public void user_Search_mobile_by_one_dim_list(io.cucumber.datatable.DataTable dataTable) {
	  List<String> data=dataTable.asList(String.class);
	  String name=data.get(0);
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys((name),Keys.ENTER);
	
	}
	 static String name;
	@When("user Search mobile by one dim map")
	public void user_Search_mobile_by_one_dim_map(io.cucumber.datatable.DataTable dataTable) {
	    Map<String,String> data=dataTable.asMap(String.class, String.class);
	 
	    name=data.get("iphone");
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name,Keys.ENTER);
	
	}


	@When("user Search mobile {string}")
	public void user_Search_mobile(String phName) {
		     name=phName;
		    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name,Keys.ENTER);
		
	}
}