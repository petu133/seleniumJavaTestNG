package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageLogin;

public class TestLogin extends TestSetup {

	@Test(description="Login con usuario y password incorrectos debe devolver texto email invalido	",enabled=false)
	public void loginInvalidMail() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.setLogin("user", "user");
		Assert.assertTrue(pageLogin.invalidMail().getText().contains("Invalid email address.")," Usuario y password ingresados no pueden ser nulos y sin registro ");
	}	
	
	@Test(description="Login fallido sin ingreso de usuario y password devuelve como texto el requerimiento de mail en la cuenta ",enabled=false)
	public void loginMailRequire() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.setLogin("","");
		Assert.assertTrue(pageLogin.requiereMail().getText().contains("An email address required.")," Usuario y password ingresados deben ser nulos ");
	}
	
}
