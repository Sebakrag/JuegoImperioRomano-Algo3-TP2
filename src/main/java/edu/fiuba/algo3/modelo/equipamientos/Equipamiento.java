package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.afectantes.Potenciador;
import edu.fiuba.algo3.modelo.estados.Estado;

public abstract class Equipamiento {

    protected int danio;

    protected String id;

    public abstract Equipamiento mejorarEquipamiento(Potenciador potenciador);

    public Estado recibirAtaque(Estado estado) {
        return estado.reducirEnergia(this.danio);
    }

    public abstract boolean equipoCompleto();

    public String getID() {
        return this.id;
    }
}
