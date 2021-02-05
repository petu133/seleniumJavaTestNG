package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageDetails {

	private WebDriver driver;
	private By xpathProduct;
	private By idColor;
	private WebElement idProduct;
	private Boolean selectedProduct;
	private String productRgb;
	private String expectedColor;;

	public PageDetails (WebDriver driver){
		this.driver = driver;
		xpathProduct = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a");
		idColor = By.id("color_13");
	}
	
	public void productDetailColor(String expectedColor){
		this.expectedColor=expectedColor;
		driver.findElement(xpathProduct).click();
		WebDriverWait wait = new WebDriverWait (driver, 6);
		WebElement idProduct = wait.until(ExpectedConditions.elementToBeClickable(idColor));
		this.idProduct = idProduct;
		this.productRgb = idProduct.getCssValue("background-color");
	}
	
		
	public WebElement idProduct(){return idProduct;}
	public Boolean selectedProduct(){return selectedProduct;}
	public String productRgb(){return productRgb;}
	public String expectedColor(){return expectedColor;}
}
