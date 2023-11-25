package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Celda {
    protected Celda siguiente;
    protected int x;
    protected int y;
    protected Afectante afectante;

    public abstract Celda afectar(Gladiador gladiador);

    public boolean tieneCoordenadas(int x, int y){
        return ((this.x == x) && (this.y == y));
    }

    public abstract Celda celdaSiguiente();

    public void setSiguiente(Celda siguiente){ this.siguiente = siguiente;};

}
