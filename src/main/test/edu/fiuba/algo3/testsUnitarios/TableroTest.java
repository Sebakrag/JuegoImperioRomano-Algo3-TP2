package edu.fiuba.algo3.testsUnitarios;


import edu.fiuba.algo3.modelo.celdas.*;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.excepcion.*;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.modelo.*;
import java.util.ArrayList;

public class TableroTest {

    @Test
    public void test01SeArmaCorrectameteUnMapa() {
        Logger logger = LogManager.getLogger();

        CeldaInicial celdaInicial = new CeldaInicial(0, 0, logger);
        CeldaFinal celdaFinal = new CeldaFinal(0,1,logger);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(celdaInicial);
        celdas.add(celdaFinal);

        Tablero tablero = new Tablero(1,1);
        Assertions.assertDoesNotThrow(()->tablero.armarMapa(celdas));

    }

    @Test
    public void test02AlArmarMapaConCantidadDeCeldasInvalidasLanzaError() {

        Logger logger = LogManager.getLogger();

        CeldaInicial celdaInicial = new CeldaInicial(0, 0, logger);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(celdaInicial);


        Tablero tablero = new Tablero(0,1);
        Assertions.assertThrows(CantidadInvalidaDeCeldasError.class,()->tablero.armarMapa(celdas));
    }

    @Test
    public void test03SeDevuelveLaCeldaCorrectaAlAvanzar() {
        Logger logger = LogManager.getLogger();

        CeldaInicial celdaInicial = new CeldaInicial(0, 0, logger);
        CeldaFinal celdaFinal = new CeldaFinal(0,1,logger);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(celdaInicial);
        celdas.add(celdaFinal);

        Tablero tablero = new Tablero(1,1);
        tablero.armarMapa(celdas);


        Celda celdaSiguiente = tablero.avanzar(1, celdaInicial);

        Assertions.assertEquals(celdaSiguiente, celdaFinal);

    }
}
