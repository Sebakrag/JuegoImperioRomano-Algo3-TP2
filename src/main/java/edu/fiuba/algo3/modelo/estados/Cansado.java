package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Cansado implements Estado {

    private static final int ENERGIA_CANSADO = 0;
    private int energiaActual;

    public Cansado(){
        this.energiaActual = ENERGIA_CANSADO;
    }

    public int avanzar(int avances) {
        throw new TurnoPerdidoError();
    }

    public Estado sanar() {
        return new Sano(5);
    }

    //TODO: idem Lesionado con cansar.
    public Estado lesionar() {
        return this;
    }
    public Estado reducirEnergia(int energia) {
        return this;
    }

    public Estado aumentarEnergia(int energia) {
        return this;
    }


}
