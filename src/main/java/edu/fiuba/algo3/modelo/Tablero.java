package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.excepcion.*;
import java.util.ArrayList;

public class Tablero {
    private Celda celdaInicial;


    public void armarMapa(ArrayList<Celda> celdas){
        if ( celdas.size() < 2 ){
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

        Celda celdaMedio = celdas.get(celdas.size() / 2);
        actual.setSiguiente(celdaMedio);
    }

    public Celda getCeldaInicial(){
        return this.celdaInicial;

    }
}
