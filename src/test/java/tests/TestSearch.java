package tests;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageSearch;

public class TestSearch extends TestSetup {
	
	
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
		Assert.assertEquals(dressCantFields.get(0).getText(), dressCantFields.get(1).getText(),"Los textos tanto superior como inferior de la lista de productos deben ser iguales");
		Assert.assertEquals(dressCantFields.get(0).getText(), "Showing 1 - 7 of 7 items", " El texto resultado debe ser \"Showing 1 - 7 of 7 items\" ");
	}	
	
	@Test(description="Verificar que el resultado de la busqueda del producto devuelve el texto \"SHIRT\"",enabled=false)
	public void searchShirt() {
		PageSearch shirt = new PageSearch(driver);
		shirt.search("shirt");
		Assert.assertEquals(shirt.shirtSearch().getText(), "\"SHIRT\"", "El texto debe ser SHIRT");
	}
	
	@Test(description="Verificar que la busqueda sin dar un parametro retorna el texto \"Please enter a search keyword\" ",enabled=false)
	public void searchEmpty() {
		PageSearch pressEnter = new PageSearch(driver);
		pressEnter.search();
		Assert.assertEquals(pressEnter.emptyBoxText().getText(), "Please enter a search keyword","No se debe ingresar texto de busqueda");
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
}
