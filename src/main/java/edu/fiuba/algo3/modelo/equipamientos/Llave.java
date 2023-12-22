package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public class Llave extends Equipamiento {

    public Llave() {
        this.danio = 0;
        this.id = "LLave";
    }

    @Override
    public Equipamiento mejorarEquipamiento(Potenciador potenciador) {
        return potenciador.equipamientoSiguiente(this);
    }

    @Override
    public boolean equipoCompleto(){
        return true;
    }
}
