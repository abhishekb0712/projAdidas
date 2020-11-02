
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import pageObjects.Cart;
import pageObjects.HomePage;
import pageObjects.Products;

import Generic_Functions.Test_Browser;

public class ECommerceTest extends Test_Browser {

	WebDriver driver;
	HomePage homePage;
	Cart cartPage;
	Products productsPage;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = getDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
	}

	/*------------------------------------------------------------------------------
	Use: To check Navigation of
	SHOP: https://www.demoblaze.com/index.html
	• Customer navigation through product categories: Phones, Laptops and Monitors
	• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up
	confirmation.
	• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up
	confirmation.
	• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
	• Click on "Place order".
	• Fill in all web form fields.
	• Click on "Purchase"
	• Capture and log purchase Id and Amount.
	• Assert purchase amount equals expected.
	• Click on "Ok". 
	Develop By: 			Abhishek Bisht
	Developed Date: 		Oct-20
	Modified By:			
	Modified Date:		
	///----------------------------------------------------------------------------------------------------------*/
	@Test(priority = 0)
	public void Demo_Ecommerce() throws Exception {
		try {

			HomePage homePage = new HomePage(driver);
			// Check navigation to catogories -
			boolean MobileVisible = homePage.phonesLinkNaviation();
			Assert.assertTrue(MobileVisible);

			boolean MonitorVisible = homePage.monitorLinkNaviation();
			Assert.assertTrue(MonitorVisible);

			boolean LaptopVisible = homePage.laptopLinkkNaviation();
			Assert.assertTrue(LaptopVisible);
			// Navigation Check completed -

			// Buy Product
			homePage.clickOnProduct("Sony vaio i5");
			productsPage = new Products(driver);
			productsPage.ClickAddToCart();
			productsPage.AcceptPopUp();
			productsPage.HomeClick();
			homePage.laptopLinkkNaviation();
			homePage.clickOnProduct("Dell i7 8gb");
			productsPage.ClickAddToCart();
			productsPage.AcceptPopUp();
			productsPage.CartClick();
			cartPage = new Cart(driver);
			cartPage.deleteProduct("Dell i7 8gb");
			String CartCost=cartPage.PriceOfCart();
			cartPage.placeOrder();
			cartPage.FillDetails();
			cartPage.purchaseButtonClick();
			String OrderAmount=cartPage.OrderAmount();
			cartPage.click_OK();
			Assert.assertEquals(OrderAmount, CartCost);
			System.out.println("The cost of cart is equal to the amount of order!!!");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
}