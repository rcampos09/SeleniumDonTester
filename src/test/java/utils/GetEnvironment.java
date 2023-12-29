package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
public class GetEnvironment {

    public static void saveEnvironmentInfo(String os, String user, String url) {
        // Obtener la ruta completa del directorio target/allure-results
        String allureResultsPath = Paths.get("target", "allure-results").toString();

        // Crear la ruta completa del archivo environment.properties
        String filePath = Paths.get(allureResultsPath, "environment.properties").toString();

        Properties properties = new Properties();
        properties.setProperty("sistema.operativo", os);
        properties.setProperty("usuario", user);
        properties.setProperty("url", url);

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            properties.store(fileWriter, "Configuración del entorno");
            //System.out.println("Archivo environment.properties creado con éxito en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
