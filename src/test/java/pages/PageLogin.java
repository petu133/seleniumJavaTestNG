package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin {
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
		singInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
		userField = By.xpath("//*[@id=\"email\"]");
		passField = By.xpath("//*[@id=\"passwd\"]");
		loginButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");
		invalidMailXpath = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
		requireMailXpath = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
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
