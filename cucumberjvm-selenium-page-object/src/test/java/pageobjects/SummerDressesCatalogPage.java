package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SummerDressesCatalogPage extends BaseClass {
	
	public SummerDressesCatalogPage(WebDriver driver){
		super(driver);
	}  
	
	@FindBy(how=How.CLASS_NAME, using="cat-name")
	public static WebElement category_name;
	
	@FindBy(how=How.ID, using="layered_id_attribute_group_1")
	public static WebElement size_short;
	
	@FindBy(how=How.ID, using="layered_id_attribute_group_2")
	public static WebElement size_medium;
	@FindBy(how=How.ID, using="layered_id_attribute_group_8")
	public static WebElement color_white;
	
	public static class PrintedSummerDress1 
	{
		@FindBy(how=How.XPATH, using="//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
		public static WebElement img_dress1;
		@FindBy(how=How.XPATH, using="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]")
		public static WebElement add_cart_dress1;
		@FindBy(how=How.CLASS_NAME, using="product-price")
		public static WebElement product_price;
		
	}
	
	public static class CartPopup
	{
		
		@FindBy(how=How.XPATH, using="//*a[@title='Continue shopping']")
		public static WebElement continue_shopping;
		
		@FindBy(how=How.XPATH, using="//a[@title='Proceed to checkout']")
		public static WebElement proceed_to_checkout;
		
	}
	

}
