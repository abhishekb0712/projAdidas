package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[(text()='Cart')]")
	WebElement cart;
	
	@FindBy(xpath = "//*[(text()='CATEGORIES')]/..//*[(text()='Phones')]")
	WebElement phonesLink;
	
	@FindBy(xpath = "//*[(text()='CATEGORIES')]/..//*[(text()='Laptops')]")
	WebElement laptopLink;
	
	@FindBy(xpath = "//*[(text()='CATEGORIES')]/..//*[(text()='Monitors')]")
	WebElement monitorLink;
	
	@FindBy(xpath = "//*[(text()='Sony vaio i5')]")
	WebElement laptopSonyVaioI5;
	
	@FindBy(xpath = "//*[(text()='Dell i7 8gb')]")
	WebElement laptopDellI78Gb;
	
	@FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
	WebElement PhoneMobileVerification;
	
	@FindBy(xpath = "//*[(text()='Apple monitor 24')]")
	WebElement AppleMonitor;
	
	
	@FindBy(xpath = "//*[(text()='MacBook air')]")
	WebElement MacBookAirLaptop;
	
	
	
	
	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	


	public boolean phonesLinkNaviation() throws InterruptedException{
		
		phonesLink.click();
		//Thread.sleep(3000);
		if((PhoneMobileVerification.isDisplayed()))
		{
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	public boolean laptopLinkkNaviation() throws InterruptedException{
		laptopLink.click();
		Thread.sleep(3000);
		if((MacBookAirLaptop.isDisplayed()))
		{
			return true;
		}
		else{
			return false;
		}
			
	}
	
	public boolean monitorLinkNaviation() throws InterruptedException{
		
		
		monitorLink.click();
		Thread.sleep(2000);
		
		if((AppleMonitor.isDisplayed()))
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	public void clickOnProduct(String ItemName){
		
		System.out.println("The Price of "+ItemName+" is : "+ driver.findElement(By.xpath("//*[(text()='"+ItemName+"')]/../../h5")).getText());
		driver.findElement(By.xpath("//*[(text()='"+ItemName+"')]")).click();
		
	}
	
	
	
	
	public void CartClick(){
		cart.click();
	}

	
	
	
	
	
	
	

}
