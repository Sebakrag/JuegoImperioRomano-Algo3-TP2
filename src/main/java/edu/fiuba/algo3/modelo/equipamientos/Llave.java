package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Jugador;

public class Llave extends DecoradorEquipamiento {
    private static final int DANIO = 0;

    public Llave(Equipamiento equipamiento){
        this.equipamiento = equipamiento;
    }

    public Equipamiento mejorarEquipamiento() {
        return this;
    }

    public int recibirAtaque(){
        return DANIO;
    }

    public boolean equipoCompleto(){
        return true;
    }
}
