package utils;

import java.io.FileWriter;
import java.io.IOException;
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
        //mapa.put("buildName", "AutoTests / test # 5.1.1");
        //mapa.put("buildOrder", "5.1.1");

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
}
