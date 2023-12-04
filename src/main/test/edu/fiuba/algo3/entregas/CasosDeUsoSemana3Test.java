package edu.fiuba.algo3.entregas;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CasosDeUsoSemana3Test {

    @Test
    public void test22SimularYVerificarQueJugadorGaneUnaPartida() {
        Logger logger = LogManager.getLogger();

        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(new CeldaInicial(0,0, logger));
        celdas.add(new CeldaComun(0,1, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaComun(0,2, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaComun(0,3, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaComun(0,4, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaFinal(0,5,logger));

        Juego juego = new Juego(logger);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Pepe");
        nombresJugadores.add("juan");

        boolean hayGanador = juego.iniciarPartida(tablero, nombresJugadores);

        Assertions.assertTrue(hayGanador);
    }

    @Test
    public void test23SimularyVerificarQueElJugadorPierdeUnaPartida() {
        Logger logger = LogManager.getLogger();

        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(new CeldaInicial(0,0, logger));
        celdas.add(new CeldaComun(0,1, new Vacio(), new Vacio(), logger));
        celdas.add(new CeldaFinal(0,2,logger));

        Juego juego = new Juego(logger);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Pepe");
        nombresJugadores.add("juan");

        boolean hayGanador = juego.iniciarPartida(tablero, nombresJugadores);

        Assertions.assertFalse(hayGanador);
    }
}
