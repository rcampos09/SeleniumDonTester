package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.GetEnvironment;
import utils.GetTestListener;
import utils.GetUrlsEnvironmet;
import utils.GetWebDriverRemote;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

@Listeners(GetTestListener.class)
public class ConfigClass {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Configurar el WebDriver Local o Hub(Selenoid)
        driver = GetWebDriverRemote.createWebDriver();
        // Abrir una URL específica
        String url = GetUrlsEnvironmet.getEnvironmentURL(); // Obtener la URL según el ambiente seleccionado
        // Elimina todas las Cookies del navegador
        driver.manage().deleteAllCookies();
        // Maximizar Pantalla
        driver.manage().window().maximize();
        // Obtiene la URL a Utilizar
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el navegador al finalizar las pruebas
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        // Obtener información del sistema después de que se hayan ejecutado todos los test
        String osEnv = System.getProperty("os.name");
        String userEnv = System.getProperty("user.name");
        String urlEnv = GetUrlsEnvironmet.getNameEnv();
        String nameEnv = GetUrlsEnvironmet.getEnvironmentURL();

        // Imprimir la información
        System.out.println("*************************************************************");
        System.out.println("\uD83D\uDCE1 Información del entorno \uD83D\uDCE1");
        System.out.println("- Sistema Operativo: " + osEnv);
        System.out.println("- Usuario: " + userEnv);
        System.out.println("- Ambiente Actual: " + nameEnv);
        System.out.println("- URL actual: " + urlEnv);
        System.out.println("*************************************************************");

        // Llamar al método saveEnvironmentInfo de la clase GetEnvironment
        GetEnvironment.saveEnvironmentInfo(osEnv, userEnv, urlEnv);
    }
}
