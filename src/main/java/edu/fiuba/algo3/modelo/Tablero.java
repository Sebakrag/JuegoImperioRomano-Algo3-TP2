package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.*;
import java.util.ArrayList;

public class Tablero {
    private Celda celdaInicial;
    private Celda celdaFinal;
    private final int ancho;
    private final int largo;

    public Tablero(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public void armarMapa(ArrayList<Celda> celdas) throws CantidadInvalidaDeCeldasError {

        if ( celdas.size() < 2 ) {
            throw new CantidadInvalidaDeCeldasError();
        }

        this.celdaInicial = celdas.get(0);
        Celda actual = celdas.get(0);
        int i = 1;
        for (; i < celdas.size(); i++) {
            Celda celdaComun = celdas.get(i);
            actual.setSiguiente(celdaComun);
            actual = celdaComun;
        }
        this.celdaFinal = actual;
        Celda celdaMedio = celdas.get((celdas.size() - 1) / 2);
        actual.setSiguiente(celdaMedio);
    }

    public Celda getCeldaInicial(){
        return this.celdaInicial;
    }

    public Celda getCeldaFinal(){
        return this.celdaFinal;
    }

    public Celda avanzar(int avances, Celda celdaActual) {
        for (int i = 0; i < avances; i++) {
            celdaActual = celdaActual.celdaSiguiente();
        }
        return celdaActual;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getLargo() {
        return this.largo;
    }
}
