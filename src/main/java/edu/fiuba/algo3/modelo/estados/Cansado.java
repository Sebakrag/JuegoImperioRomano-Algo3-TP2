package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Cansado implements Estado {

    public int avanzar(int avances) {
        throw new TurnoPerdidoError();
    }

    public Estado sanar() {
        return new Sano();
    }

    //TODO: idem Lesionado con cansar.
    public Estado lesionar() {
        return new Lesionado();

    }

    public Estado cansar(int energia) {
        return this;
    }

    public int calcularEnergia(int energia) {
        return (energia + 5);
    }
}
