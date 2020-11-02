package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Cart{
	
	
	public WebDriver driver;

	
	@FindBy(xpath = "//*[(text()='Sony vaio i5')]/..//td[4]/a")
	WebElement delete;
	
	
	@FindBy(xpath = "//*[(text()='Total')]/../div/div/h3")
	WebElement CartCost;
	
	@FindBy(xpath = "//button[(text()='Place Order')]")
	WebElement placeOrder;
	
	@FindBy(xpath = "//label[(text()='Name:')]/../input")
	WebElement nameInput;
	
	@FindBy(xpath = "//label[(text()='Country:')]/../input")
	WebElement countryInput;
	
	@FindBy(xpath = "//label[(text()='City:')]/../input")
	WebElement cityInput;
	
	@FindBy(xpath = "//label[(text()='Credit card:')]/../input")
	WebElement creditCardInput;
	
	@FindBy(xpath = "//label[(text()='Month:')]/../input")
	WebElement MonthInput;
	
	@FindBy(xpath = "//label[(text()='Year:')]/../input")
	WebElement yearInput;
	
	@FindBy(xpath = "//button[(text()='Purchase')]")
	WebElement purchaseButton;
	
	@FindBy(xpath = "//p[contains(text(),'Id: ')]")
	WebElement confirmPopUp;
	
	
	@FindBy(xpath = "//button[(text()='OK')]")
	WebElement OKafterPurchase;

	// Initializing the Page Objects:
	public Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void deleteProduct(String productName){
		
		String dynamicProductXpath="//*[(text()='"+productName+"')]/..//td[4]/a";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicProductXpath))).click();
	/*	WebElement deleteBtn=driver.findElement(By.xpath(dynamicProductXpath));	
		
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
	*/}
	
	public void placeOrder() throws InterruptedException{
		Thread.sleep(5000);
		placeOrder.click();		
	}
	
	public void getSucessMessage(){
		confirmPopUp.getText();	
		
		System.out.println(confirmPopUp.getText());
	}
	
	public void FillDetails(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(nameInput));
	
		
		
		nameInput.sendKeys("Demo");
		countryInput.sendKeys("Demo");
		cityInput.sendKeys("Demo");
		creditCardInput.sendKeys("Demo");
		MonthInput.sendKeys("Demo");
		yearInput.sendKeys("Demo");
}
	
	
	public void purchaseButtonClick(){
		purchaseButton.click();		
	}
	
	/*public void NavigateBackToHomePage(){
		driver.navigate().back();		
	}*/
	
	public void click_OK() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("Sucessfully placed the order, details are as follows : "+confirmPopUp.getText());
		OKafterPurchase.click();		
	}
	
	public void AcceptPopUp(){
		driver.switchTo().alert().accept();
		
	}
	
	public String PriceOfCart() throws InterruptedException{
		Thread.sleep(2000);
		return CartCost.getText();
		
	}
	
	public String OrderAmount(){
		
		String message = confirmPopUp.getText();
		String OrderAmount=message.substring(20, 23);
		System.out.println("the Order amount is: "+OrderAmount);
		return OrderAmount;//CartCost.getText();
		
	}
	
	
	

	
	
}
