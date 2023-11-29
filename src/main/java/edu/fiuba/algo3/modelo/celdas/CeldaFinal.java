package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;

public class CeldaFinal extends Celda {

    public CeldaFinal(int x, int y) {
        coordenadasValidas(x, y);
        this.x = x;
        this.y = y;
    }
    @Override
    public Celda celdaSiguiente(){
        return this;
    }

    // TODO: me hace ruido que el siguiente sea el del medio pero por ahora queda asi
    public Celda afectar(Gladiador gladiador) {
        if (gladiador.totalmenteEquipado()){
            return this;
        }
        return siguiente;
    }
}
