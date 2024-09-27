package services;

public class GlucosaClasificador {

    public static int clasificar(int nivelGlucosa) {
        if (nivelGlucosa < 99) {
            return 0;
        } else if (nivelGlucosa >= 100 && nivelGlucosa <= 125) {
            return 1;
        } else {
            return 2;
        }
    }
}

