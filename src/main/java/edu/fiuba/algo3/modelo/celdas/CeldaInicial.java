package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;

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
