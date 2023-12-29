package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.GetEnvironment;


public class ConfigClass {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configurar el WebDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
        driver = new ChromeDriver();

        // Abrir una URL específica
        String url = "https://rcampos09.github.io/demo-Shop-t-shirt/"; // Reemplaza con la URL que desees abrir
        // Elimina todas las Cookies del navegador
        driver.manage().deleteAllCookies();
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
        String urlEnv = "https://rcampos09.github.io/demo-Shop-t-shirt/";

        // Imprimir la información
        System.out.println("Sistema Operativo: " + osEnv);
        System.out.println("Usuario: " + userEnv);
        System.out.println("URL actual: " + urlEnv);

        // Llamar al método saveEnvironmentInfo de la clase GetEnvironment
        GetEnvironment.saveEnvironmentInfo(osEnv, userEnv, urlEnv);
    }
}
