package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Observable {

    protected ArrayList<Observador> observadores;

    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    public void notificarObservadores() {
        for (Observador observador : this.observadores) {
            observador.actualizar(this);
        }
    }
}
