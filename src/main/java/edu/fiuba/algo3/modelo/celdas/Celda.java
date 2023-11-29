package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;

public abstract class Celda {
    protected Celda siguiente;
    protected int x;
    protected int y;


    protected void coordenadasValidas(int x, int y) {
        if(x < 0 || y < 0) {
            throw new CoordenadaInvalidaError();
        }
    }

    public abstract Celda afectar(Gladiador gladiador);

    public abstract Celda celdaSiguiente();

    public void setSiguiente(Celda siguiente){ this.siguiente = siguiente;};
}
