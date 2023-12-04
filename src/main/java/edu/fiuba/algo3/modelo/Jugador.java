package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

import org.apache.logging.log4j.Logger;

public class Jugador {
    private Gladiador gladiador;
    private int turno;
    private Celda celdaActual;
    private final Logger logger;

    public Jugador(Gladiador gladiador, Celda celdaInicial, Logger logger) {
        this.gladiador = gladiador;
        this.turno = 0;
        this.celdaActual = celdaInicial;
        this.logger = logger;
    }

    /*
     * Suponemos que: el seniority se mejora independientemente de si el jugador tiro o no los dados. Dado que esta
     * ligado a la cantidad de turnos.
     * */

    public boolean jugarTurno(Dado dado, Tablero tablero){
        logger.info("string de jugador 1 /2 jugando");
        this.turno++;

        int avances = dado.tirar();
        Celda celdaProxima = tablero.avanzar(avances, this.celdaActual);
        this.celdaActual = this.gladiador.mover(celdaProxima, this.turno);

        return (celdaActual == tablero.getCeldaFinal());
        /*logger.info("Turno jugado con éxito. Nueva celda del gladiador: " + this.celdaActual);*/
    }
}
