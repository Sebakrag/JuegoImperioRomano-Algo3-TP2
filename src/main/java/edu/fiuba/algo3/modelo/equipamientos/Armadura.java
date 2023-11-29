package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public class Armadura extends Equipamiento {

    public Armadura(){
        this.danio = 10;
    }

    @Override
    public Equipamiento mejorarEquipamiento(Potenciador potenciador) {
        return potenciador.equipamientoSiguiente(this);
    }

    @Override
    public boolean equipoCompleto() {
        return false;
    }
}
