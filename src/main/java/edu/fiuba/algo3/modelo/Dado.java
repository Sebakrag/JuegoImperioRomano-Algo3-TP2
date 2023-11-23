package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {

    private static final int CARAS_DADO = 6;

    public int tirar(){
        Random random = new Random();
        return random.nextInt(CARAS_DADO) + 1;
    }
}
