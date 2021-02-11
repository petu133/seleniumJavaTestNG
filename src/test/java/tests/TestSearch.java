package tests;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageSearch;

public class TestSearch extends TestSetup {
	
	
	@Test(description="Busqueda sin resultado dentro del listado correspondiente al producto women",enabled=false)
	public void searchWomen() {
		PageSearch women  = new PageSearch(driver);
		
		women.search("WOMen");
		WebDriverWait wait = new WebDriverWait(driver, 4);
		Assert.assertNotNull(women.women(), "No encuentra existencia del objeto");
		WebElement womenWait = wait.until(ExpectedConditions.visibilityOf(women.women()));
		Assert.assertEquals(womenWait.getText(), "No results were found for your search \"" + women.womenText() +"\"");
		}
		
	@Test(description="Verificar que el resultado de la busqueda (dress) muestra una cantidad de producto en lista igual a siete (7) ",enabled=false)
	public void searchDress() {
		PageSearch dress  = new PageSearch(driver);
		dress.search("DrEsS");
		Assert.assertNotNull(dress.productCountDress(), dress.productNotFound());
		WebDriverWait wait = new WebDriverWait(driver,4);
		List<WebElement> dressCantFields = wait.until(ExpectedConditions.visibilityOfAllElements(dress.productCountDress()));
		Assert.assertEquals(dressCantFields.get(0).getText(), dressCantFields.get(1).getText());
		Assert.assertEquals(dressCantFields.get(0).getText(), "Showing 1 - 7 of 7 items");
		
	}	
	
	@Test(description="Verificar que la busqueda sin dar un parametro retorna el texto \"Please enter a search keyword\" ",enabled=false)
	public void searchEmpty() {
		PageSearch pressEnter = new PageSearch(driver);
		pressEnter.search();
		Assert.assertNotNull(pressEnter.emptyBoxText(), "El metodo search del objeto pressEnter no permite el envio de parametros");
		Assert.assertEquals(pressEnter.emptyBoxText().getText(), "Please enter a search keyword");
	}	
	//reparar aqui
	@Test(description="Verificar que el resultado de la busqueda de X producto devuelve la cantidad en lista igual al numero ingresado (n) esperable",enabled=false)
	public void searchCantDress() {
		PageSearch cantDress = new PageSearch(driver);
		cantDress.searchVerifCant("dress",7);
		cantDress.productList();
		Assert.assertEquals(cantDress.cantProdList(), cantDress.cantProd(),"La cantidad de productos debe concidir con el numero ingresado en el parametro del metodo searchVerifCant");
	}
	//reparar aqui
	@Test(description="Verificar que el resultado de la busqueda de X producto devuelve la cantidad en lista igual al numero ingresado (n) esperable",enabled=false)
	public void searchCantShirt() {
		PageSearch cantShirt = new PageSearch(driver);
		cantShirt.searchVerifCant("shirt",1);
		cantShirt.productList();
		Assert.assertEquals(cantShirt.cantProdList(), cantShirt.cantProd(),"La cantidad de productos debe concidir con el numero ingresado en el parametro del metodo searchVerifCant");
	}
}
