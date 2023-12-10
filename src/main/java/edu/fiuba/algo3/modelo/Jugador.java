package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Jugador extends Observable {
    private Gladiador gladiador;
    private int turno;
    private Celda celdaActual;
    private final Logger logger;
    private final String nombre;

    // -------------------------------- PUBLICOS -------------------------------- //

    public Jugador(String nombre, Gladiador gladiador, Celda celdaInicial, Logger logger) {
        this.gladiador = gladiador;
        this.turno = 0;
        this.celdaActual = celdaInicial;
        this.logger = logger;
        this.nombre = nombre;
        this.observadores = new ArrayList<>();
    }

    /*
     * Suponemos que: el seniority se mejora independientemente de si el jugador tiro o no los dados. Dado que esta
     * ligado a la cantidad de turnos.
     * */

    public boolean jugarTurno(int avances, Tablero tablero) {
        logger.info("Turno de: " + this.nombre);
        this.turno++;

        Celda celdaProxima = tablero.avanzar(avances, this.celdaActual);
        this.celdaActual = this.gladiador.mover(celdaProxima, this.turno);

        if (celdaActual == tablero.getCeldaFinal()) {
            logger.info(this.nombre + " has ganado la partida. ¡Felicitaciones!");
            return true;
        }

        notificarObservadores(this.nombre, this.celdaActual);
        return false;
        //logger.info("Turno jugado con éxito. Nueva celda del gladiador: " + this.celdaActual);
    }

    public String getNombre() {
        return this.nombre;
    }

    // -------------------------------- PRIVADOS -------------------------------- //

    private void notificarObservadores(String nombre, Celda celda) {
        for (Observador observador : this.observadores) {
            observador.actualizar(nombre, celda);
        }
    }
}
