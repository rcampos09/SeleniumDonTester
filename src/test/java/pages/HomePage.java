package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.fail;

public class HomePage {

    // Constructor que inicializa los elementos de la página
    public HomePage(WebDriver driver) {
        this.driver = driver;  // Añade esta línea para inicializar la variable driver
        PageFactory.initElements(driver, this);
    }
    protected WebDriver driver;

    // Elementos de la página usando anotaciones @FindBy
    @FindBy(id = "usuario")
    private WebElement usernameInput;

    @FindBy(id = "contrasena")
    private WebElement passwordInput;

    @FindBy(id = "click-login")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='usuario-info'][contains(text(), 'usuario')]")
    private WebElement usuarioInfoText;

    // Métodos para interactuar con la página
    @Step("Este es el: {username} parametro, y este es la contraseña: {password}")
    public void ingresarCredenciales(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void hacerLogin() {
        try {
            loginButton.click();
        } catch (Exception e) {
            Allure.addAttachment("Boton loginButton: no clickable", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
            fail("boton no clickable: " + loginButton);
            e.printStackTrace();
        }
    }

    @Step("Aceptar Alerta de Login")
    public void aceptarAlertaLogin() {
        try {
            Thread.sleep(2000);
            // Esperar a que aparezca la alerta (puedes ajustar el tiempo según sea necesario)
            Alert alert = driver.switchTo().alert();
            // Capturar la alerta y aceptar
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Valida texto Alerta de Login")
    public boolean validAlertaTextLogin() {
        try {
            Thread.sleep(2000);
            // Esperar a que aparezca la alerta (puedes ajustar el tiempo según sea necesario)
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Inicio de sesión exitoso")) {
                return true;
            } else {
                fail("Texto no es: Inicio de sesión exitozo");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usuarioInfoText() {
        try {
            return usuarioInfoText.isDisplayed();
        } catch (Exception e) {
            Allure.addAttachment("Elemento no presente", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
            fail("Elemento no presente ");
            e.printStackTrace();
            return false;
        }
    }
}
