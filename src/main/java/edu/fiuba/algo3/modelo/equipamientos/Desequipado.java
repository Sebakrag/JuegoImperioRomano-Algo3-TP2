package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;

public class Desequipado extends Equipamiento {
    private static final int DANIO = 20;

    public Equipamiento mejorarEquipamiento() {
        return new Casco(this);
    }

    public int recibirAtaque(int energiaActual) {
        return (energiaActual - DANIO);
    }

    public boolean equipoCompleto(){
        return false;
    };
}
