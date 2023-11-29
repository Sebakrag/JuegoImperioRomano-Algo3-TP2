package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public class Casco extends Equipamiento{

    public Casco(){
        this.danio = 15;
    }

    @Override
    public Equipamiento mejorarEquipamiento(Potenciador potenciador) {
        return potenciador.equipamientoSiguiente(this);
    }

    @Override
    public boolean equipoCompleto(){
        return false;
    }
}
