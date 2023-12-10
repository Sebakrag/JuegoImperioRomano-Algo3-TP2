package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Observable {

    protected ArrayList<Observador> observadores;

    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }
}
