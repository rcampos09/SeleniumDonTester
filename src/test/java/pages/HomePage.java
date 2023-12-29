package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public void ingresarCredenciales(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void hacerLogin() {
        loginButton.click();
    }

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

    public boolean validAlertaTextLogin() {
        try {
            Thread.sleep(2000);
            // Esperar a que aparezca la alerta (puedes ajustar el tiempo según sea necesario)
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Inicio de sesión exitoso")) {
                System.out.println("El mensaje es el mismo: " + alertText);
                return true;
            } else {
                System.out.println("El mensaje es diferente: " + alertText);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usuarioInfoText() {
        return usuarioInfoText.isDisplayed();
    }
}
