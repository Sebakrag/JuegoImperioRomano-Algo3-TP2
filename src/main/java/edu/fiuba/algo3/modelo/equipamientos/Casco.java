package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.DecoradorEquipamiento;

public class Casco extends DecoradorEquipamiento {
    private static final int DANIO = 15;

    public Casco(Equipamiento equipamiento) {
        this.equipamiento = equipamiento;
    }

    public Equipamiento mejorarEquipamiento() {
        return new Armadura(this);
    }

    public int recibirAtaque() {
        return DANIO;
    }

    public boolean equipoCompleto(){
        return false;
    }
}
