package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.Equipamiento;


public class EscudoYEspada extends DecoradorEquipamiento {
    private static final int PROTECCION = 8;

    public EscudoYEspada(Equipamiento equipamiento){
        this.equipamiento = equipamiento;
    }

    public Equipamiento mejorarEquipamiento() {
        return new Llave(this);
    }

    public int recibirAtaque(int energiaActual){
        return this.equipamiento.recibirAtaque(energiaActual + PROTECCION);
    }

    public boolean equipoCompleto(){
        return false;
    }
}
