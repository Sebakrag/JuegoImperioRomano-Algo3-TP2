package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;


public class EscudoYEspada extends DecoradorEquipamiento {
    private static final int DANIO = 2;

    public EscudoYEspada(Equipamiento equipamiento){
        this.equipamiento = equipamiento;
    }

    public Equipamiento mejorarEquipamiento() {
        return new Llave(this);
    }

    public int recibirAtaque(int energiaActual){
        return (energiaActual - DANIO);
    }

    public boolean equipoCompleto(){
        return false;
    }
}
