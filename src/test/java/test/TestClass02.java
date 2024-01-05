package test;

import DataProvider.SetDataProvider;
import config.ConfigClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TestClass02 extends ConfigClass {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = SetDataProvider.class, testName = "TestClass02", description = "Login User And Pass")
    @Description("Esta prueba intenta iniciar sesión en el sitio web utilizando un nombre de usuario y una contraseña. Falla si ocurre algún error.")
    @Severity(CRITICAL)
    @Owner("@DonTester")
    @Link(name = "Website", url = "https://rcampos09.github.io/demo-Shop-t-shirt/")
    @Story("DTS-000")
    @Issue("DTI-002")
    public void testExample02(String login, String password) {
        HomePage homePage =  new HomePage(driver);
        homePage.ingresarCredenciales(login,password);
        homePage.hacerLogin();
    }
}
