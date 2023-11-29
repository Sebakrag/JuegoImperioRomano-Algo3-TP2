package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.*;
import java.util.ArrayList;

public class Tablero {
    private Celda celdaInicial;

    // TODO: Siento que es al pedo esta clase, que ese metodo puede estar privado en el parser

    /*
    * Si eliminamos esta clase, deberiamos modificar los tests y utilizar el parser para crear la celdaInicial.
    * Ademas, si eliminamos la clase Tablero, el parser ya no devolveria un Tablero sino, como mencionamos, deberia
    * devolver una celdaInicial.
    * Tema ancho y alto?? donde lo guardamos si la sacamos a la clase?
    * Pensarlo bien.
    * */

    public void armarMapa(ArrayList<Celda> celdas) throws CantidadInvalidaDeCeldasError {

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
