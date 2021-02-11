package tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.PageHome;

public class TestHomeStatus extends TestSetup {

	@Test(description="Verificar que los precios en oferta en la pagina Home se muestran en un recuadro color determinado",enabled=false)
	public void verifColorOffPrices(){
		PageHome priceOffColor = new PageHome(driver);
		priceOffColor.setColorOffPrice("rgba(241, 51, 64, 1)");
		for (int i = 0; i<priceOffColor.capture().size();i++) {
		Assert.assertEquals(priceOffColor.capture().get(i).getCssValue("background-color").toString(), priceOffColor.priceColor(), " Color ingresado y color del cuadro deben ser iguales");
		}
	}
	
	@Test(description="Verificando formato de elementos en el bloque inferior de informacion CMS", timeOut=5000, enabled=false)
	public void formatInf() {
		PageHome blockCD = new PageHome(driver);
		SoftAssert check = new SoftAssert();
		blockCD.setCmsInfo("242, 242, 242, 1", "#ffffff");
		check.assertEquals(blockCD.blockColor(), "rgba("+blockCD.expectedColorBlock()+")","El color de fondo de bloque debe coincidir con el ingresado como parametro");
		check.assertEquals(blockCD.frameColor(), blockCD.expectedColorFrame(),"El color de fondo de cuadro frame selenium debe coincidir con el ingresado como parametro");
		blockCD.setCmsInfo("21px", "13px", "#333333");
		check.assertEquals(blockCD.titleCB().getCssValue("font-size"),blockCD.pxTitle(), "Pixeles que se observa en el navegador debe coincidir con el parametro ingresado para el titulo del bloque inferior derecho de informacion");
		check.assertEquals(blockCD.subTitleCB().getCssValue("font-size"),blockCD.pxSub(), "Pixeles que se observa en el navegador debe coincidir con el parametro ingresado para el subtitulo del bloque inferior derecho de informacion");
		String colorRgb = blockCD.subTitleCB().getCssValue("color");
		String colorHex = Color.fromString(colorRgb).asHex();
		check.assertEquals(colorHex, blockCD.colorFontSub()," Color de fuente que se observa en el navegador debe coincidir con el parametro ingresado para el texto del bloque inferior derecho de informacion");
		check.assertAll();
	}
	
	
		
	
	
}
