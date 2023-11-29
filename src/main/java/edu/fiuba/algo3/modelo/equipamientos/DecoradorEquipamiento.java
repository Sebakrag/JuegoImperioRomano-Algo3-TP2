package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;

public abstract class DecoradorEquipamiento extends Equipamiento {
    protected Equipamiento equipamiento;

    public abstract Equipamiento mejorarEquipamiento();

    public abstract int recibirAtaque(int energiaActual);
}