package edu.fiuba.algo3.modelo.seniorities;

public class Senior implements Seniority {
    private static final int AUMENTO_ENERGIA = 10;

    public Seniority ascender(int turno) {
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
