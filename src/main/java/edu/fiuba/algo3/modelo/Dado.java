package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {

    private int ultimoNumeroTirado;
    private int caras = 6;

    private int ultimoNumeroTirado;

    public Dado(int carasDado){
        this.caras = carasDado;
    }
    public int tirar() {
        Random random = new Random();
        this.ultimoNumeroTirado = (random.nextInt(caras) + 1);
        return this.ultimoNumeroTirado;
    }
}
