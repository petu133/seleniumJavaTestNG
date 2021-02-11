package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin {
	private final static String SINGIN_BUTTON_DOM = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a";
	private final static String USER_FIELD_DOM = "//*[@id=\"email\"]";
	private final static String PASS_FIELD_DOM = "//*[@id=\"passwd\"]";
	private final static String LOGGIN_BUTTON_DOM = "//*[@id=\"SubmitLogin\"]/span";
	private final static String INVALID_MAIL_DOM = "//*[@id=\"center_column\"]/div[1]/ol/li";
	private final static String REQUIRE_MAIL_DOM = "//*[@id=\"center_column\"]/div[1]/ol/li";
	private WebDriver driver;
	private By singInButton;
	private By userField;
	private By passField;
	private By loginButton;
	private By invalidMailXpath;
	private By requireMailXpath;
	private WebElement invalidMail;
	private WebElement requireMail;
	
	
	public PageLogin (WebDriver driver) {
		this.driver = driver;
		singInButton = By.xpath(SINGIN_BUTTON_DOM);
		userField = By.xpath(USER_FIELD_DOM);
		passField = By.xpath(PASS_FIELD_DOM);
		loginButton = By.xpath(LOGGIN_BUTTON_DOM);
		invalidMailXpath = By.xpath(INVALID_MAIL_DOM);
		requireMailXpath = By.xpath(REQUIRE_MAIL_DOM);
	}
	
	public void setLogin (String user, String pass) {
		driver.findElement(singInButton).click();
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginButton).click();
		if (user!="" && pass!="") {
			invalidMail = driver.findElement(invalidMailXpath);
		}
		if (user=="" && pass=="") {
			requireMail = driver.findElement(requireMailXpath);
		}
		
	}
	
	public WebElement invalidMail() {return invalidMail;}
	public WebElement requiereMail() {return requireMail;}
}
