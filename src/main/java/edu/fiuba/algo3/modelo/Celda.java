package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Celda {
    protected Celda siguiente;
    protected int x;
    protected int y;
    protected Afectante premio;
    protected Afectante obstaculo;

    public abstract Celda afectar(Gladiador gladiador);

    public abstract Celda celdaSiguiente();
}