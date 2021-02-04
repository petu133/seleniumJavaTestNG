package tests;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.PageHome;
import pages.PageLogin;
import pages.PageSearch;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test(description="Login con usuario y password incorrectos debe devolver texto email invalido	",enabled=false)
	public void loginInvalidMail() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.setLogin("user", "user");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Invalid email address.")," Usuario y password ingresados no pueden ser nulos y sin registro ");
	}	
	
	@Test(description="Login fallido sin ingreso de usuario y password devuelve como texto el requerimiento de mail en la cuenta ",enabled=false)
	public void loginMailRequire() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.setLogin("","");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("An email address required.")," Usuario y password ingresados deben ser nulos ");
	}
	
	@Test(description="Busqueda sin resultado dentro del listado de producto, parametro asignado -women-",enabled=false)
	public void searchWomen() {
		PageSearch women  = new PageSearch(driver);
		women.search("women");
		WebDriverWait wait = new WebDriverWait(driver, 4);
		WebElement womenWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#center_column > p")));
		Assert.assertEquals(womenWait.getText(), "No results were found for your search \"women\"", " El texto ingresado debe ser -women- " );
		}
		
	@Test(description="Verificar que el resultado de la busqueda (dress) muestra una cantidad de producto en lista igual a siete (7) ",enabled=false, priority=1)
	public void searchDress() {
		PageSearch dress  = new PageSearch(driver);
		dress.search("dress");
		WebDriverWait wait = new WebDriverWait(driver,4);
		List<WebElement> dressCantFields = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("product-count")));
		//System.out.println(dressCantFields.get(0).getText());
		//System.out.println(dressCantFields.get(1).getText());
		Assert.assertEquals(dressCantFields.get(0).getText(), dressCantFields.get(1).getText(),"Los textos tanto superior como inferior de la lista de productos deben ser iguales");
		Assert.assertEquals(dressCantFields.get(0).getText(), "Showing 1 - 7 of 7 items", " El texto resultado debe ser \"Showing 1 - 7 of 7 items\" ");
	}	
	
	@Test(description="Verificar que el resultado de la busqueda del producto devuelve el texto \"SHIRT\"",enabled=false)
	public void searchShirt() {
		PageSearch shirt = new PageSearch(driver);
		shirt.search("shirt");
		Assert.assertEquals(driver.findElement(By.className("lighter")).getText(), "\"SHIRT\"", "El texto debe ser SHIRT");
	}
	
	@Test(description="Verificar que la busqueda sin dar un parametro retorna el texto \"Please enter a search keyword\" ",enabled=false)
	public void searchEmpty() {
		PageSearch pressEnter = new PageSearch(driver);
		pressEnter.search();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText(), "Please enter a search keyword","No se debe ingresar texto de busqueda");
	}	
	
	@Test(description="Verificar que el resultado de la busqueda de X producto devuelve la cantidad en lista igual al numero ingresado (n) esperable",enabled=false)
	public void searchCantDress() {
		PageSearch cantDress = new PageSearch(driver);
		cantDress.searchVerifCant("dress",7);
		cantDress.productList();
		Assert.assertEquals(cantDress.cantProdList(), cantDress.cantProd(),"La cantidad de productos debe concidir con el numero ingresado");
	}
	
	@Test(description="Verificar que el resultado de la busqueda de X producto devuelve la cantidad en lista igual al numero ingresado (n) esperable",enabled=false)
	public void searchCantShirt() {
		PageSearch cantShirt = new PageSearch(driver);
		cantShirt.searchVerifCant("shirt",1);
		cantShirt.productList();
		Assert.assertEquals(cantShirt.cantProdList(), cantShirt.cantProd(),"La cantidad de productos debe concidir con el numero ingresado");
	}
	
	
	@Test(description="Verificar que los precios en oferta en la pagina Home se muestran en un recuadro color determinado",enabled=false)
	public void verifColor(){
		List<WebElement> capture = (List<WebElement>) driver.findElements(By.className("price-percent-reduction"));
		String setColor="rgba(241, 51, 64, 1)";
		for (int i = 0; i<capture.size();i++) {
		Assert.assertEquals(capture.get(i).getCssValue("background-color").toString(), setColor, " Color ingresado y color del cuadro deben ser iguales");
		}
	}
	
	@Test(description="Verificacion del color que muestra, por defecto,  el producto en su detalle",enabled=false)
	public void productDet(){
		PageDetails product = new PageDetails(driver);
		product.productDetailColor("rgba(243, 156, 17, 1)");
		//System.out.println(product.idProduct().getCssValue("background"));
		Assert.assertEquals(product.productRgb(), product.expectedColor(), " Color ingresado y color de producto deben coincidir");
	}
	
	@Test(description="Verificando formato de elementos en el bloque inferior de informacion CMS", timeOut=5000, enabled=false)
	public void bloqueInf() {
		PageHome blockCD = new PageHome(driver);
		SoftAssert check = new SoftAssert();
		
		blockCD.setupCmsInfo("#f2f2f2", "white");
		//FALTARIA LOS ASSERT y LA NAVEGACION para lo que es el formato 
		//de fondo para el bloque cms y el recuadro blanco selenium . HACERLO!
		
		
		blockCD.setupCmsInfo("21px", "13px", "#333333");
		check.assertEquals(blockCD.titleCB().getCssValue("font-size"),blockCD.pxTitle(), "Pixeles que se observa en el navegador debe coincidir con el parametro ingresado para el titulo del bloque");
		check.assertEquals(blockCD.subTitleCB().getCssValue("font-size"),blockCD.pxSub(), "Pixeles que se observa en el navegador debe coincidir con el parametro ingresado para el subtitulo del bloque");
		String colorRgb = blockCD.subTitleCB().getCssValue("color");
		String colorHex = Color.fromString(colorRgb).asHex();
		check.assertEquals(colorHex, blockCD.colorFontSub(),"Color de fuente que se observa en el navegador debe coincidir con el parametro ingresado para el texto del bloque");
		check.assertAll();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
