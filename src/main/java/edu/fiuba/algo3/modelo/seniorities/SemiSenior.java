package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.Seniority;

public class SemiSenior implements Seniority {
    private static final int AUMENTO_ENERGIA = 5;
    private static final int TURNOS_ASCENSO = 8;

    public Seniority ascender(int turno) {
        if (turno == TURNOS_ASCENSO) {
            return new Senior();
        }
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
