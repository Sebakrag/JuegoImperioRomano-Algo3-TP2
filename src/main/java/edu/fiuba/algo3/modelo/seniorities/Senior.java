package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.estados.Estado;

public class Senior implements Seniority {
    private static final int AUMENTO_ENERGIA = 10;


    public Seniority ascender(int turno) {
        return this;
    }

    public Estado aumentarEnergia(Estado estado){
        estado.aumentarEnergia(AUMENTO_ENERGIA);
        return estado;
    }
}
