package controllers;

import services.GlucosaResultados;
import services.GlucosaService;

public class GlucosaController {

    private final GlucosaService glucosaService;

    public GlucosaController() {
        this.glucosaService = new GlucosaService();
    }

    public void ejecutarClasificacion() {
        GlucosaResultados resultados = glucosaService.clasificarGlucosa();
        System.out.println("Niveles de glucosa:");
        for (int[] niveles : resultados.getNivelesGlucosa()) {
            System.out.println(java.util.Arrays.toString(niveles));
        }

        System.out.println("Resultados de clasificación:");
        for (int[] clasificaciones : resultados.getResultadosClasificacion()) {
            System.out.println(java.util.Arrays.toString(clasificaciones));
        }

        int[] clasificacionesTotales = resultados.juntarResultados();

        int normales = 0, prediabetes = 0, diabetes = 0;
        for (int resultado : clasificacionesTotales) {
            switch (resultado) {
                case 0:
                    normales++;
                    break;
                case 1:
                    prediabetes++;
                    break;
                case 2:
                    diabetes++;
                    break;
            }
        }

        System.out.println("\nClasificación de resultados:");
        System.out.printf("Normal: %.2f%%%n", (normales / 30.0) * 100);
        System.out.printf("Prediabetes: %.2f%%%n", (prediabetes / 30.0) * 100);
        System.out.printf("Diabetes: %.2f%%%n", (diabetes / 30.0) * 100);
    }
}
