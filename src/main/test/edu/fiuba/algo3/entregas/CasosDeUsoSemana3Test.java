package edu.fiuba.algo3.entregas;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CasosDeUsoSemana3Test {

    private void jugarCantidadDeRondas(Juego juego, int cantidadRondas, Dado dado) {
        for (int i = 0; i < cantidadRondas; i++) {
            juego.jugarTurnoDeJugadorActual(dado);
            juego.jugarTurnoDeJugadorActual(dado);
        }
    }

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

        Tablero tablero = new Tablero(1,6);
        tablero.armarMapa(celdas);

        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Pepe");
        nombresJugadores.add("juan");

        Juego juego = new Juego(logger, tablero);
        juego.iniciarPartida(nombresJugadores);

        Dado dado = new Dado(1);
        jugarCantidadDeRondas(juego, 4, dado);

        Assertions.assertThrows(UnJugadorGanoLaPartidaError.class, () -> juego.jugarTurnoDeJugadorActual(dado));
    }

    @Test
    public void test23SimularyVerificarQueElJugadorPierdeUnaPartida() {
        Logger logger = LogManager.getLogger();

        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(new CeldaInicial(0,0,logger));
        celdas.add(new CeldaComun(0,1, new Vacio(), new Vacio(), logger));
        celdas.add(new CeldaFinal(0,2, logger));
        Tablero tablero = new Tablero(1,3);
        tablero.armarMapa(celdas);

        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Pepe");
        nombresJugadores.add("juan");

        Juego juego = new Juego(logger, tablero);
        juego.iniciarPartida(nombresJugadores);

        Dado dado = new Dado(1);
        jugarCantidadDeRondas(juego, 29, dado);

        juego.jugarTurnoDeJugadorActual(dado);

        Assertions.assertThrows(PasaronTreintaRondasYnoHuboGanadorError.class,()-> juego.jugarTurnoDeJugadorActual(dado));
    }
}
