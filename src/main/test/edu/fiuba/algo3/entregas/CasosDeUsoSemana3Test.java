package edu.fiuba.algo3.entregas;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CasosDeUsoSemana3Test {
    public void moverAJugador(Jugador jugador, Dado dado, Tablero tablero, int avances) {
        for (int i = 0; i < avances; i++) {
            jugador.jugarTurno(dado, tablero);
        }
    }

    public Celda obtenerCeldaProxima(Tablero tablero, int avances){
        Dado dado = new Dado(1);
        Celda celdaProxima = tablero.getCeldaInicial();

        for(int i = 0; i < avances; i++){
            celdaProxima = tablero.avanzar(dado.tirar(), celdaProxima);
        }
        return celdaProxima;
    }
    @Test
    public void test22SimularYVerificarQueJugadorGaneUnaPartida() {
        Logger logger = LogManager.getLogger();

        Dado dado = new Dado(1);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(new CeldaInicial(0,0, logger));
        celdas.add(new CeldaComun(0,1, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaComun(0,2, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaComun(0,3, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaComun(0,4, new Potenciador(), new Vacio(), logger));
        celdas.add(new CeldaFinal(0,5,logger));

        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);
        Gladiador gladiador = new Gladiador(logger, tablero.getCeldaInicial());
        Jugador jugador = new Jugador(gladiador, tablero.getCeldaInicial(), logger);
        int turno = 5;
        int avances = 4;

        moverAJugador(jugador, dado, tablero, avances); //Jugador obtiene la llave
        Celda celdaProxima = obtenerCeldaProxima(tablero, avances);

        //Gana el juego
        celdaProxima = tablero.avanzar(dado.tirar(), celdaProxima);
        Celda celdaFinalGladiador = gladiador.mover(celdaProxima, turno);
        //celdaFinalGladiador = gladiador.mover(celdaFinalGladiador, turno);

        Assertions.assertSame(celdaProxima, celdaFinalGladiador);
    }

    @Test
    public void test23SimularyVerificarQueElJugadorPierdeUnaPartida() {
        Logger logger = LogManager.getLogger();

        Dado dado = new Dado(1);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(new CeldaInicial(0,0, logger));
        celdas.add(new CeldaComun(0,1, new Vacio(), new Vacio(), logger));
        celdas.add(new CeldaFinal(0,2,logger));

        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);
        Gladiador gladiador = new Gladiador(logger, tablero.getCeldaInicial());
        Jugador jugador = new Jugador(gladiador, tablero.getCeldaInicial(), logger);
        int turno = 30;
        int avances = 29;

        moverAJugador(jugador, dado, tablero, avances);
        Celda celdaProxima = obtenerCeldaProxima(tablero, avances);

        //Pierde el juego
        celdaProxima = tablero.avanzar(dado.tirar(), celdaProxima);
        Celda celdaFinalGladiador = gladiador.mover(celdaProxima, turno);

        Assertions.assertNotSame(celdaProxima, celdaFinalGladiador);
    }
}
