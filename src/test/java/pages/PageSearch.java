package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSearch {
	private WebDriver driver;
	private By searchField;
	private By searchButton;
	private By prodName;
	private By prodList;
	private By shirtField;
	private By emptyField;
	private int cantProd;
	private int cantProdList;
	private WebElement xpathSearchEmpty;
	private WebElement shirtSearch;
	
	
	
	
	public PageSearch (WebDriver driver) {
		this.driver = driver;
		searchField= By.id("search_query_top");
		searchButton= By.name("submit_search");
		prodName= By.className("product-name");
		prodList= By.xpath("//*[@id=\"center_column\"]/ul");
		shirtField=By.className("lighter");
		emptyField=By.xpath("//*[@id=\"center_column\"]/p");
		}
			
			public void search (String searchText){
				driver.findElement(searchField).sendKeys(searchText);
				driver.findElement(searchButton).click();
					if (searchText =="shirt") {
						shirtSearch= driver.findElement(shirtField);
					}
			}
			
			
			public WebElement shirtSearch() {return shirtSearch;}
		
			public void search () {
				driver.findElement(searchButton).submit();
				xpathSearchEmpty = driver.findElement(emptyField);
			}
			
			public WebElement emptyBoxText() {return xpathSearchEmpty;}
			
			public void searchVerifCant (String searchText, int cantProd){
				driver.findElement(searchField).sendKeys(searchText);
				driver.findElement(searchButton).click();
				this.cantProd = cantProd;
			}
			
			public int cantProd() {return cantProd;}
		
			public void productList() {
				WebDriverWait productList = new WebDriverWait(driver,4);
				WebElement productListCont = productList.until(ExpectedConditions.presenceOfElementLocated(prodList));
				List<WebElement> webElementList = productListCont.findElements(prodName);
				cantProdList = webElementList.size();
			}
			
			public int cantProdList(){return cantProdList;}
}