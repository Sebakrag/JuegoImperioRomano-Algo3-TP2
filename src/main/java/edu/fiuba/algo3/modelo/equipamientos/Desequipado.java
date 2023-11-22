package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.equipamientos.DecoradorEquipamiento;

public class Desequipado extends Equipamiento {
    private static final int DANIO = 20;

    public Equipamiento mejorarEquipamiento() {
        return new Casco(this);
    }

    public int recibirAtaque() {
        return DANIO;
    }

    public boolean equipoCompleto(){
        return false;
    };
}
