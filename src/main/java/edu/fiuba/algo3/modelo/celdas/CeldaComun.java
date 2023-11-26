package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;

public class CeldaComun extends Celda {

    public CeldaComun(int x, int y){
        if(x < 0 || y < 0) {
            throw new CoordenadaInvalidaError();
        }
        this.x = x;
        this.y = y;
    }

    public void setPremio(Afectante unPremio){
        this.premio = unPremio;
    }

    public void setObstaculo(Afectante unObstaculo){
        this.obstaculo = unObstaculo;
    }

    public Celda afectar(Gladiador gladiador){
        this.premio.afectar(gladiador);
        this.obstaculo.afectar(gladiador);
        return this;
    }

    @Override
    public Celda celdaSiguiente(){
        return this.siguiente;
    }
}
