package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;


public class EscudoYEspada implements Equipamiento {
    private static final int DANIO = 2;

    public Equipamiento mejorarEquipamiento(Potenciador potenciador) {
        return potenciador.equipamientoSiguiente(this);

    }

    public int recibirAtaque(int energiaActual){
        return (energiaActual - DANIO);
    }

    public boolean equipoCompleto(){
        return false;
    }
}
