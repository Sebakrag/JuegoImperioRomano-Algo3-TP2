package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public class Desequipado extends Equipamiento {

    public Desequipado(){
        this.danio = 20;
    }

    @Override
    public Equipamiento mejorarEquipamiento(Potenciador potenciador) {
        return potenciador.equipamientoSiguiente(this);
    }

    @Override
    public boolean equipoCompleto(){
        return false;
    };
}
