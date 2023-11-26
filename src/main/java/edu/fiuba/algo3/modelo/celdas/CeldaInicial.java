package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Afectante;
import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.afectantes.*;

public class CeldaInicial extends Celda {
    
    // Conviene tener solo CeldaComun y CeldaFinal? Haciendo que
    // CeldaComun tenga un constructor que reciba las coordenadas
    // y que instanciemos CeldaComun con x=0 e y=0 para crear la
    // celda inicial.

    public CeldaInicial() {
        this.premio = new Vacio();
        this.obstaculo = new Vacio();
        this.x = 0;
        this.y = 0;
    }

    public CeldaInicial(int x, int y) {
        this.premio = new Vacio();
        this.obstaculo = new Vacio();
        this.x = x;
        this.y = y;
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
