package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Afectante;

public class CeldaComun extends Celda {
    public CeldaComun(int x, int y, Afectante afectante) {
        this.siguiente = siguiente;
        this.afectante = afectante;
        this.x = x;
        this.y = y;
    }

    public boolean esCeldaFinal(){
        return false;
    }
}
