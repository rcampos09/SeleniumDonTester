package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    // Constructor que inicializa los elementos de la página
    public HomePage(WebDriver driver) {
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

}
