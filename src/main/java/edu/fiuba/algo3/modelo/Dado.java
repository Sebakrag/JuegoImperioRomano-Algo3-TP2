package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado extends Observable {

    private int ultimoNumeroTirado;
    private int caras = 6;

    public Dado(int carasDado){
        this.caras = carasDado;
    }

    public int tirar() {
        Random random = new Random();
        this.ultimoNumeroTirado = (random.nextInt(caras) + 1);
        return this.ultimoNumeroTirado;
    }

    public void notificarObservadores(int ultimoNumeroTirado) {
        for (Observador observador : this.observadores) {
            observador.actualizar(ultimoNumeroTirado);
        }
    }
}
