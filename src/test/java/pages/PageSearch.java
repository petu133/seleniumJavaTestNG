package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSearch {
	private final static String SEARCH_FIELD_DOM = "search_query_top";
	private final static String SEARCH_BUTTON_DOM = "submit_search";
	private final static String PROD_NAME_DOM = "product-name";
	private final static String PROD_LIST_DOM = "//*[@id=\"center_column\"]/ul";
	private final static String EMPTY_FIELD_DOM = "//*[@id=\"center_column\"]/p";
	private final static String PRODUCT_LISTDRESS_DOM = "product-count";
	private final static String PRODUCT_NOTFOUND_DOM = "//*[@id=\"center_column\"]/p";
	private final static String PRODUCT_WOMENFOUND_DOM = "#center_column > p";
	private WebDriver driver;
	private By searchField;
	private By searchButton;
	private By prodName;
	private By prodList;
	private By emptyField;
	private By producListDress;
	private By productNFound;
	private List<WebElement> productCount;
	private WebElement women;
	private WebElement xpathSearchEmpty;
	private int cantProd;
	private int cantProdList;
	private String productNotFound;
	private By womenFound;
	private String womenTextParameter;
	
	
	
	public PageSearch (WebDriver driver) {
		this.driver = driver;
		searchField = By.id(SEARCH_FIELD_DOM);
		searchButton = By.name(SEARCH_BUTTON_DOM);
		prodName = By.className(PROD_NAME_DOM);
		prodList = By.xpath(PROD_LIST_DOM);
		emptyField = By.xpath(EMPTY_FIELD_DOM);
		producListDress = By.className(PRODUCT_LISTDRESS_DOM);
		productNFound = By.xpath(PRODUCT_NOTFOUND_DOM);
		womenFound = By.cssSelector(PRODUCT_WOMENFOUND_DOM);
		}
			
			public void search (String searchText){
				String womenTest = "women";
				String dressText = "dress";
				driver.findElement(searchField).sendKeys(searchText);
				driver.findElement(searchButton).click();
				if (womenTest.equalsIgnoreCase(searchText)) {
					women = driver.findElement(womenFound);
					womenTextParameter = searchText;
					}
				if (dressText.equalsIgnoreCase(searchText)) {
				productCount = driver.findElements(producListDress);
				}else{
					productNotFound = driver.findElement(productNFound).getText();
				}
			}
			
			public void search () {
				driver.findElement(searchButton).submit();
				xpathSearchEmpty = driver.findElement(emptyField);
			}
			
			public void searchVerifCant (String searchText, int cantProd){
				driver.findElement(searchField).sendKeys(searchText);
				driver.findElement(searchButton).click();
				this.cantProd = cantProd;
			}
			
			public void productList() {
				WebDriverWait productList = new WebDriverWait(driver,8);
				WebElement productListCont = productList.until(ExpectedConditions.presenceOfElementLocated(prodList));
				List<WebElement> webElementList = productListCont.findElements(prodName);
				cantProdList = webElementList.size();
			}
			
			public List<WebElement> productCountDress () {return productCount;}
			public WebElement women() {return women;}
			public WebElement emptyBoxText() {return xpathSearchEmpty;}
			public int cantProdList(){return cantProdList;}
			public int cantProd() {return cantProd;}
			public String productNotFound() {return productNotFound;}
			public String womenText() {return womenTextParameter;}
}