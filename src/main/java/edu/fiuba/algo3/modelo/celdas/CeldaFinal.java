package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;

public class CeldaFinal extends Celda {

    public CeldaFinal(int x, int y) {
        if(x < 0 || y < 0) {
            throw new CoordenadaInvalidaError();
        }

        this.premio = new Vacio();
        this.obstaculo = new Vacio();

        this.x = x;
        this.y = y;
    }

    @Override
    public Celda celdaSiguiente(){
        return this;
    }

    public Celda afectar(Gladiador gladiador) {
        if (gladiador.totalmenteEquipado()){
            return this;
        }
        return siguiente;
    }
}
