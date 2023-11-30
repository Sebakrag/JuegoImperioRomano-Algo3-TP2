package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

import org.apache.logging.log4j.Logger;

public class Jugador {
    private Gladiador gladiador;
    private Tablero tablero;
    private int turno;

    private final Logger logger;

    public Jugador(Gladiador gladiador, Tablero tablero, Logger logger) {
        this.gladiador = gladiador;
        this.turno = 0;
        this.tablero = tablero;
        this.logger = logger;
    }

    /*
     * Suponemos que: el seniority se mejora independientemente de si el jugador tiro o no los dados. Dado que esta
     * ligado a la cantidad de turnos.
     * */
    public void jugarTurno(Dado dado) throws TurnoPerdidoError {
        logger.info("string de jugador 1 /2 jugando");
        this.turno++;

        try {
            this.gladiador.mover(dado.tirar(), this.tablero, this.turno);
            /*logger.info("Turno jugado con éxito. Nueva celda del gladiador: " + this.celdaActual);*/
        } catch(TurnoPerdidoError e) {
            logger.error("Turno perdido durante el juego. Detalles: " + e.getMessage());
            // TODO: sacarlo y reformular los tests:
            throw e;
        }
    }
}
