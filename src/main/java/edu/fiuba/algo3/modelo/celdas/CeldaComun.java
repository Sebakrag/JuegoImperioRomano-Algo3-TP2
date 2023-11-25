package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Gladiador;

public class CeldaComun extends Celda {

    public CeldaComun(int x, int y, Afectante afectante) {
        this.afectante = afectante;
        this.x = x;
        this.y = y;
    }

    public Celda afectar(Gladiador gladiador){
        this.afectante.afectar(gladiador);
        return this;
    }

    @Override
    public Celda celdaSiguiente(){
        return this.siguiente;
    }
}
