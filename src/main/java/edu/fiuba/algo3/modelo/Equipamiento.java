package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;

public interface Equipamiento {
    public Equipamiento mejorarEquipamiento(Potenciador potenciador);

    public int recibirAtaque(int energia);

    public boolean equipoCompleto();
}
