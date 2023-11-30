package edu.fiuba.algo3.modelo.estados;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Lesionado implements Estado {

    private int energiaActual;

    public Lesionado(int energia){
        this.energiaActual = energia;
    }

    public Estado reducirEnergia(int energia) {
        return this;
    }

    public int avanzar(int avances) {
        throw new TurnoPerdidoError();
    }

    public Estado sanar() {
        return new Sano(this.energiaActual);
    }

    public Estado lesionar() {
        return this;
    }

    public Estado aumentarEnergia(int energia){
        return this;
    }

    // TODO: PREGUNTAR ESTO: no tiene sentido que lesionado se canse pero por solucion polimorfica debemos implementarlo.
}
