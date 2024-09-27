package services;

public class GlucosaResultados {

    private int[][] nivelesGlucosa;
    private int[][] resultadosClasificacion;

    public GlucosaResultados(int[][] nivelesGlucosa, int[][] resultadosClasificacion) {
        this.nivelesGlucosa = nivelesGlucosa;
        this.resultadosClasificacion = resultadosClasificacion;
    }

    public int[][] getNivelesGlucosa() {
        return nivelesGlucosa;
    }

    public int[][] getResultadosClasificacion() {
        return resultadosClasificacion;
    }

    public int[] juntarResultados() {
        int[] clasificacionesTotales = new int[30];
        System.arraycopy(resultadosClasificacion[0], 0, clasificacionesTotales, 0, 10);
        System.arraycopy(resultadosClasificacion[1], 0, clasificacionesTotales, 10, 10);
        System.arraycopy(resultadosClasificacion[2], 0, clasificacionesTotales, 20, 10);
        return clasificacionesTotales;
    }
}

