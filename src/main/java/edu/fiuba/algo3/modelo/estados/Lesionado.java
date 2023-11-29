package edu.fiuba.algo3.modelo.estados;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Lesionado implements Estado {

    public int avanzar(int avances) {
        throw new TurnoPerdidoError();
    }

    public Estado sanar() {
        return new Sano();
    }

    public Estado lesionar() {
        return this;
    }

    // TODO: PREGUNTAR ESTO: no tiene sentido que lesionado se canse pero por solucion polimorfica debemos implementarlo.
    public Estado cansar(int energia) {
        return new Cansado();
    }

    public int calcularEnergia(int energia) {
        return energia;
    }
}
