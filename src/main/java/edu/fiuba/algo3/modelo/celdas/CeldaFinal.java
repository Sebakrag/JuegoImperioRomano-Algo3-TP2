package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.Jugador;

public class CeldaFinal extends Celda {

    public CeldaFinal(Celda siguiente, int x, int y) {
        this.siguiente = siguiente;
        this.afectante = new Vacio();
        this.x = x;
        this.y = y;
    }

    public void afectar(Jugador jugador) {
        if (!(jugador.totalmenteEquipado())) {
            jugador.posicionar(this.celdaSiguiente());
        }
        // jugador.ganarJuego();     A analizar...
        // this.juego.gano(jugador);     A analizar...
    }

    public boolean esCeldaFinal(){
        return true;
    }
}
