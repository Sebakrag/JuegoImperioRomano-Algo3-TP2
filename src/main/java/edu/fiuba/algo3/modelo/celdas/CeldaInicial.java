package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;

public class CeldaInicial extends Celda {
    
    public CeldaInicial(int x, int y) {
        this.coordenadasValidas(x,y);
        this.x = x;
        this.y = y;
    }

    public Celda afectar(Gladiador gladiador){
        return this;
    }

    @Override
    public Celda celdaSiguiente(){
        return this.siguiente;
    }
}
