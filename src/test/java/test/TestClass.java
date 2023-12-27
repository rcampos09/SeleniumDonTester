package test;

import config.ConfigClass;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TestClass extends ConfigClass {

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://rcampos09.github.io/demo-Shop-t-shirt/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void testExample() {
        HomePage homePage =  new HomePage(driver);
        homePage.ingresarCredenciales("usuario","contrasena");
        homePage.hacerLogin();
    }
}
