package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.afectantes.Afectante;
import edu.fiuba.algo3.modelo.Gladiador;

public class CeldaComun extends Celda {
    private Afectante premio;
    private Afectante obstaculo;
    public CeldaComun(int x, int y, Afectante premio, Afectante obstaculo){
        this.coordenadasValidas(x,y);
        this.x = x;
        this.y = y;
        this.premio = premio;
        this.obstaculo = obstaculo;
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
