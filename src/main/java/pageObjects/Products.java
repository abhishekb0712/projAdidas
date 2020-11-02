package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Products {
	
	
	public WebDriver driver;
	
	
	@FindBy(xpath = "//*[(text()='Add to cart')]")
	WebElement addToCart;
	
	@FindBy(xpath = "//a[(text()='Home ')]")
	WebElement home;
	
	@FindBy(xpath = "//a[(text()='Cart')]")
	WebElement cart;
	
	
	
	@FindBy(xpath = "//h3[(contains(text(),'$'))]")
	WebElement priceOnProductPage;
	

	// Initializing the Page Objects:
	public Products(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickAddToCart(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
	}
	
	/*public void NavigateBackToHomePage(){
		driver.navigate().back();		
	}*/
	
	public void AcceptPopUp(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
			}
	
	
	public void HomeClick(){
		home.click();
		
	}
	
	public void CartClick(){
		cart.click();
		
	}

	
	
}
