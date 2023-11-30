package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.estados.Estado;

public interface Seniority {
    public Seniority ascender(int turno);
    public Estado aumentarEnergia(Estado estado);
}
