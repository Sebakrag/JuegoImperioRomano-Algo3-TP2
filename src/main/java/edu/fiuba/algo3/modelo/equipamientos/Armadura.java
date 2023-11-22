package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.equipamientos.DecoradorEquipamiento;

public class Armadura extends DecoradorEquipamiento {
    private static final int DANIO = 10;

    public Armadura(Equipamiento equipamiento){
        this.equipamiento = equipamiento;
    }

    public Equipamiento mejorarEquipamiento() {
        return new EscudoYEspada(this);
    }

    public int recibirAtaque(){
        return DANIO;
    }

    public boolean equipoCompleto() {
        return false;
    }
}
