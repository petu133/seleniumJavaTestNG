package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageDetails;

public class TestMisc extends TestSetup {

	@Test(description="Verificacion del color que muestra, por defecto,  el producto en su detalle",enabled=false)
	public void productDet(){
		PageDetails product = new PageDetails(driver);
		product.setProductDetailColor("rgba(243, 156, 17, 1)");
		Assert.assertEquals(product.productRgb(), product.expectedColor(), " Color ingresado y color de producto deben coincidir");
	}
	
}
