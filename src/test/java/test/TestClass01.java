package test;

import DataProvider.SetDataProvider;
import config.ConfigClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TestClass01 extends ConfigClass {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = SetDataProvider.class, testName = "TestClass01")
    @Description("Esta prueba intenta iniciar sesión en el sitio web utilizando un nombre de usuario y una contraseña. Falla si ocurre algún error.")
    @Severity(CRITICAL)
    @Owner("@DonTester")
    @Link(name = "Website", url = "https://rcampos09.github.io/demo-Shop-t-shirt/")
    @Story("DTS-001")
    @Issue("DTI-001")
    public void testExample01(String login, String password) {
        HomePage homePage =  new HomePage(driver);
        homePage.ingresarCredenciales(login,password);
        homePage.hacerLogin();
        homePage.aceptarAlertaLogin();
        Assert.assertTrue(homePage.usuarioInfoText(), "El elemento usuarioInfoText no está presente en la página");
    }
}
