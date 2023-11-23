package edu.fiuba.algo3.modelo;

public abstract class Equipamiento {
    public abstract Equipamiento mejorarEquipamiento();

    public abstract int recibirAtaque(int energia);

    public abstract boolean equipoCompleto();
}
