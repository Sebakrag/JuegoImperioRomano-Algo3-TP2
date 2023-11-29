package edu.fiuba.algo3.modelo.estados;

public class Sano implements Estado {

    public int avanzar(int avances) {
        return avances;
    }

    public Estado sanar() {
        return this;
    }

    public Estado lesionar() {
        return new Lesionado();
    }

    public Estado cansar(int energia) {
        if (energia == 0) {
            return new Cansado();
        }
        return this;
    }

    public int calcularEnergia(int energia) {
        return energia;
    }
}
