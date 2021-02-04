package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {
	private WebDriver driver;
	private By singInButton;
	private By userField;
	private By passField;
	private By loginButton;
	
	public PageLogin (WebDriver driver) {
		this.driver = driver;
		singInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
		userField = By.xpath("//*[@id=\"email\"]");
		passField = By.xpath("//*[@id=\"passwd\"]");
		loginButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");
	}
	
	public void setLogin (String user, String pass) {
		//driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		//dos alternativas posibles: la linea arriba permite que el driver directamente a la pagina de login, la linea de abajo llega a la misma pero atraves del boton singIn en pageIndex
		driver.findElement(singInButton).click();
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginButton).click();
		
	}
	
}
