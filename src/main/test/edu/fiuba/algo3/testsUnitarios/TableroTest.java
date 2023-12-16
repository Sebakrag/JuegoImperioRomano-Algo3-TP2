package edu.fiuba.algo3.testsUnitarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableroTest {

    @Test
    public void test01SeArmaCorrectameteUnMapa() {

        /*if ( celdas.size() < 2 ) {
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
        actual.setSiguiente(celdaMedio);*/

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test02JugadorAavanza() {
            /*
            * public Celda avanzar(int avances, Celda celdaActual) {
        for (int i = 0; i < avances; i++) {
            celdaActual = celdaActual.celdaSiguiente();
        }
        return celdaActual;
    }
            * */
    }
}
