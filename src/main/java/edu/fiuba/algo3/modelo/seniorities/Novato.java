package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.Seniority;

public class Novato implements Seniority {
    private  static final int AUMENTO_ENERGIA = 0;

    public Seniority ascender(int turno) {
        int turnosAscenso = 8;

        if (turno == turnosAscenso) {
            return new SemiSenior();
        }
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
