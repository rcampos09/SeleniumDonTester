package DataProvider;

import org.testng.annotations.DataProvider;
public class SetDataProvider {

    @DataProvider(name = "loginDataProvider")
    public static Object[][] provideLoginData() {
        return new Object[][] {
                {"usuario", "contrasena"}
                // Puedes agregar más combinaciones según sea necesario
        };
    }
}
