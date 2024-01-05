package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class GetWebDriverRemote {

    public static WebDriver createWebDriver() {
        WebDriver driver; // Declarar la variable driver aquí
        String remoteDriver = System.getProperty("remote", "true");

        if (remoteDriver.equals("false")) {// Por defecto se utiliza Chrome (lastest)
            // System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
            // Configurar las opciones de Chrome para ejecutar en modo sin cabeza
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--headless");
            // Inicializar el controlador de Chrome con las opciones configuradas
            driver = new ChromeDriver(chromeOptions);
        } else {
            ChromeOptions options = new ChromeOptions();
            // Por defecto se utiliza Chrome (120.0)
            options.setCapability("browserVersion", "120.0");
            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                /* Se habilita VNC para visualizar la ejecución en vivo. */
                put("enableVNC", true);
                /* Cómo agregar una insignia de prueba */
                put("name", "Test badge...");
                /* Cómo establecer el tiempo de espera de la sesión */
                put("sessionTimeout", "15m");
                /* Cómo establecer la zona horaria */
                put("env", new ArrayList<String>() {{
                    add("TZ=UTC");
                }});
                /* Cómo agregar un botón "trash" (papelera) */
                put("labels", new HashMap<String, Object>() {{
                    put("manual", "true");
                }});
                /* Cómo habilitar la grabación de video */
                put("enableVideo", false);
            }});
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al construir la URL del driver remoto.");
            }
        }
        return driver; // Devolver la variable driver al final
    }
}
