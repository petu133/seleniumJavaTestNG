package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.PageHome;

public class TestHomeStatus extends TestSetup {

	@Test(description="Verificar que los precios en oferta en la pagina Home se muestran en un recuadro color determinado",enabled=false)
	public void verifColor(){
		List<WebElement> capture = (List<WebElement>) driver.findElements(By.className("price-percent-reduction"));
		String setColor="rgba(241, 51, 64, 1)";
		for (int i = 0; i<capture.size();i++) {
		Assert.assertEquals(capture.get(i).getCssValue("background-color").toString(), setColor, " Color ingresado y color del cuadro deben ser iguales");
		}
	}
	
	@Test(description="Verificando formato de elementos en el bloque inferior de informacion CMS", timeOut=5000, enabled=false)
	public void bloqueInf() {
		PageHome blockCD = new PageHome(driver);
		SoftAssert check = new SoftAssert();
		
		//blockCD.setupCmsInfo("#f2f2f2", "white");
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
	
	
	
}
