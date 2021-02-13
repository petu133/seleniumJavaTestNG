package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageSearch;

public class TestSearch extends TestSetup {
	
	@Test(description="Busqueda sin resultado dentro del listado correspondiente al producto women",enabled=true)
	public void searchWomen() {
		PageSearch women  = new PageSearch(driver);
		women.search("WOmEn");
		Assert.assertNotNull(women.women(), "No encuentra el elemento web referenciado en el metodo women()");
		Assert.assertNotNull(women.womenTextOfPage(), "No encuentra el elemento web referenciado en el metodo womenTextOfPage()");
		Assert.assertEquals(women.womenTextOfPage(), "No results were found for your search \"" + women.womenText() +"\"" );
		}
		
	@Test(description="Verificar que el resultado de la busqueda (dress) muestra una cantidad de producto en lista igual a siete (7) ",enabled=true)
	public void searchDress() {
		PageSearch dress  = new PageSearch(driver);
		dress.search("DrEsS");
		Assert.assertNotNull(dress.productCountDress(), dress.productNotFound());
		Assert.assertEquals(dress.dressCantInfoUpperField(), dress.dressCantInfoLowerField());
		Assert.assertEquals(dress.dressCantInfoUpperField(), "Showing 1 - 7 of 7 items");
	}	
	
	@Test(description="Verificar que la busqueda con parametro vacio retorna el texto \"Please enter a search keyword\" ",enabled=true)
	public void searchEmpty() {
		PageSearch pressEnter = new PageSearch(driver);
		pressEnter.search();
		Assert.assertNotNull(pressEnter.emptyBoxText(), "El metodo search del objeto pressEnter no permite el envio de parametros");
		Assert.assertEquals(pressEnter.textInEmptyBox(), "Please enter a search keyword");
	}	
	
	@Test(description="Verificar que el resultado de la busqueda de X producto devuelve la cantidad en lista igual al numero ingresado (n) esperable",enabled=true)
	public void searchCantDress() {
		PageSearch cantDress = new PageSearch(driver);
		cantDress.searchVerifCant("dress",7);
		cantDress.productList();
		Assert.assertEquals(cantDress.cantProdList(), cantDress.cantProd(),"La cantidad de productos debe concidir con el numero ingresado en el parametro del metodo searchVerifCant");
	}
	
	@Test(description="Verificar que el resultado de la busqueda de X producto devuelve la cantidad en lista igual al numero ingresado (n) esperable",enabled=true)
	public void searchCantShirt() {
		PageSearch cantShirt = new PageSearch(driver);
		cantShirt.searchVerifCant("shirt",1);
		cantShirt.productList();
		Assert.assertEquals(cantShirt.cantProdList(), cantShirt.cantProd(),"La cantidad de productos debe concidir con el numero ingresado en el parametro del metodo searchVerifCant");
	}
}
