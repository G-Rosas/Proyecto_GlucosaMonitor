package services;

import java.util.Random;

public class GlucosaThread extends Thread {

    private int[] nivelesGlucosa;
    private int[] resultadosClasificacion;

    public GlucosaThread() {
        this.nivelesGlucosa = new int[10];
        this.resultadosClasificacion = new int[10];
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nivelesGlucosa[i] = random.nextInt(200);
            resultadosClasificacion[i] = GlucosaClasificador.clasificar(nivelesGlucosa[i]);
        }
    }

    public int[] getNivelesGlucosa() {
        return nivelesGlucosa;
    }

    public int[] getResultadosClasificacion() {
        return resultadosClasificacion;
    }
}

