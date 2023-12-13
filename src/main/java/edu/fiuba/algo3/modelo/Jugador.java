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

        Celda celdaAnterior = this.celdaActual;
        Celda celdaProxima = tablero.avanzar(avances, this.celdaActual);
        this.celdaActual = this.gladiador.mover(celdaProxima, this.turno);

        notificarObservadores(this.nombre, celdaAnterior, this.celdaActual, avances);

        if (celdaActual == tablero.getCeldaFinal()) {
            logger.info(this.nombre + " has ganado la partida. ¡Felicitaciones!");
            return true;
        }
        return false;
    }

    public String getNombre() {
        return this.nombre;
    }

    // -------------------------------- PRIVADOS -------------------------------- //

    private void notificarObservadores(String nombre, Celda celdaAnterior, Celda celdaActual, int avances) {
        for (Observador observador : this.observadores) {
            observador.actualizar(nombre, celdaAnterior, celdaActual, avances);
        }
    }

}
