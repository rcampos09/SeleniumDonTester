package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetUrlsEnvironmet {

    public static String getEnvironmentURL(){
        String environment = System.getProperty("env", "urlprod");
        // Cargar el archivo env.properties
        Properties properties = new Properties();
        try (
            FileInputStream input = new FileInputStream("src/test/resources/env.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Obtener la URL del ambiente seleccionado
        return properties.getProperty(environment, "https://rcampos09.github.io/demo-Shop-t-shirt/");
    }

    public static String getNameEnv() {
        String environment = System.getProperty("env", "urlprod");
        environment = environment.replace("url", "").trim().toUpperCase();
        return environment;
    }
}
