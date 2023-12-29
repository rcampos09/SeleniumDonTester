package utils;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Date ahora = new Date();

        // Formatear la fecha y hora
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatoFechaHora = formatter.format(ahora);

        // Mostrar la hora y fecha de inicio del test
        System.out.println("#########################################");
        System.out.println("Inicio de la prueba: " + result.getName());
        System.out.println("\u23F1\uFE0F Hora de la inicio prueba: " + formatoFechaHora);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Date ahora = new Date();

        // Formatear la fecha y hora
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatoFechaHora = formatter.format(ahora);

        // Mostrar la hora y fecha de inicio del test
        System.out.println("\u2705  Exito de la prueba: " + result.getName());
        System.out.println("\u23F1\uFE0F Hora de la termino prueba: " + formatoFechaHora);
        System.out.println("#########################################");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Date ahora = new Date();

        // Formatear la fecha y hora
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatoFechaHora = formatter.format(ahora);

        // Mostrar la hora y fecha de inicio del test
        System.out.println("\u274C  Fallido de la prueba: " + result.getName());
        System.out.println("\u23F1\uFE0F Hora de la termino prueba: " + formatoFechaHora);
        System.out.println("#########################################");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Prueba omitida: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("  Inicio Suites :"+context.getName());
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("   Fin Suites :"+context.getName());
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}
