package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.JSONObject;
public class GetEnvironment {

    public static void saveEnvironmentInfo(String os, String user, String env, String url) {
        // Obtener la ruta completa del directorio target/allure-results
        String allureResultsPath = Paths.get("target", "allure-results").toString();

        // Crear la ruta completa del archivo environment.properties
        String filePath = Paths.get(allureResultsPath, "environment.properties").toString();

        Properties properties = new Properties();
        properties.setProperty("Sistema Operativo:", os);
        properties.setProperty("Usuario:", user);
        properties.setProperty("Ambiente:", env);
        properties.setProperty("URL:", url);


        try (FileWriter fileWriter = new FileWriter(filePath)) {
            properties.store(fileWriter, "Configuración del entorno");
            //System.out.println("Archivo environment.properties creado con éxito en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveExecutorInfo() {
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> mapa = new HashMap<>();  // Parametriza tu HashMap

        mapa.put("name", "github");
        mapa.put("type", "github");
        mapa.put("url", "http://example.org");
        mapa.put("buildOrder", "7");
        mapa.put("buildName", "#7-regression-tests");
        mapa.put("buildUrl", "http://example.org/build#7");
        mapa.put("reportUrl", "http://example.org/build#7/AllureReport");
        mapa.put("reportName", "Demo allure report");

        // Utilizar putAll para agregar todos los elementos del HashMap al JSONObject
        jsonObject.putAll(mapa);

        String targetFolderPath = "target/allure-results";
        String fileName = "executor.json";
        String filePath = Paths.get(targetFolderPath, fileName).toString();

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonObject.toJSONString());
            //System.out.println("Archivo JSON creado con éxito en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyCategoriesJsonToTarget() throws IOException {
        // Rutas de origen y destino
        Path sourcePath = Paths.get("src", "test", "resources", "categories.json");
        Path targetPath = Paths.get("target/allure-results", "categories.json");

        // Verifica si el directorio de destino existe, si no, créalo
        Path targetDirectory = targetPath.getParent();
        if (!Files.exists(targetDirectory)) {
            Files.createDirectories(targetDirectory);
        }
        // Copia el archivo
        Files.copy(sourcePath, targetPath);
        //System.out.println("categories.json copiado exitosamente a la carpeta target.");
    }
}
