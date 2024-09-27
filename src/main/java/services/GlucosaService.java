package services;

public class GlucosaService {

    public GlucosaResultados clasificarGlucosa() {
        GlucosaThread grvhilo1 = new GlucosaThread();
        GlucosaThread grvhilo2 = new GlucosaThread();
        GlucosaThread grvhilo3 = new GlucosaThread();
        grvhilo1.start();
        grvhilo2.start();
        grvhilo3.start();
        try {
            grvhilo1.join();
            grvhilo2.join();
            grvhilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[][] nivelesGlucosa = new int[3][10];
        int[][] resultadosClasificacion = new int[3][10];
        nivelesGlucosa[0] = grvhilo1.getNivelesGlucosa();
        nivelesGlucosa[1] = grvhilo2.getNivelesGlucosa();
        nivelesGlucosa[2] = grvhilo3.getNivelesGlucosa();
        resultadosClasificacion[0] = grvhilo1.getResultadosClasificacion();
        resultadosClasificacion[1] = grvhilo2.getResultadosClasificacion();
        resultadosClasificacion[2] = grvhilo3.getResultadosClasificacion();
        return new GlucosaResultados(nivelesGlucosa, resultadosClasificacion);
    }
}

