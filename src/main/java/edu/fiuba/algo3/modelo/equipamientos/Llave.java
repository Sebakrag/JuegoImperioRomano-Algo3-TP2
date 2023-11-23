package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;


public class Llave extends DecoradorEquipamiento {
    private static final int DANIO = 0;

    public Llave(Equipamiento equipamiento){
        this.equipamiento = equipamiento;
    }

    public Equipamiento mejorarEquipamiento() {
        return this;
    }

    public int recibirAtaque(int energiaActual){
        return (energiaActual - DANIO);
    }

    public boolean equipoCompleto(){
        return true;
    }
}
