package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public abstract class Equipamiento {

    protected int danio;

    public abstract Equipamiento mejorarEquipamiento(Potenciador potenciador);

    public int recibirAtaque(int energiaActual) {
        int energiaNueva = (energiaActual - danio);
        if (energiaNueva < 0) {
            return 0;
        }
        return energiaNueva;
    }

    public abstract boolean equipoCompleto();
}
