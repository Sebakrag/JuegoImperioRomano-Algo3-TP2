package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Jugador;

public class CeldaFinal extends Celda {

    public CeldaFinal(Celda medio, int x, int y) {
        this.siguiente = medio;
        this.afectante = new Vacio();
        this.x = x;
        this.y = y;
    }

    @Override
    public Celda celdaSiguiente(){
        return this;
    }

    public Celda afectar(Gladiador gladiador){
        if (gladiador.totalmenteEquipado()){
            return this;
        }
        return siguiente;
    }
}
