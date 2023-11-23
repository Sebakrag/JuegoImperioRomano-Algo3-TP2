package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Jugador;

public class CeldaFinal extends Celda {

    public CeldaFinal(Celda siguiente, int x, int y) {
        this.siguiente = siguiente;
        this.afectante = new Vacio();
        this.x = x;
        this.y = y;
    }

    public void afectar(Gladiador gladiador) {
        afectante.afectar(gladiador);
    }

    //public void

    public boolean esCeldaFinal(){
        return true;
    }
}
