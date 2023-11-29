package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {
    private int caras = 6;

    public Dado(int carasDado){
        this.caras = carasDado;
    }
    public int tirar(){
        Random random = new Random();
        return random.nextInt(caras) + 1;
    }
}