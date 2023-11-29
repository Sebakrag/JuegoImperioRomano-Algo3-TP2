package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Jugador {
    private Gladiador gladiador;
    private Celda celdaActual;
    private int turno;

    public Jugador(Gladiador gladiador, Celda celdaInicial) {
        this.gladiador = gladiador;
        this.turno = 0;
        this.celdaActual = celdaInicial;
    }

    /*
     * Suponemos que: el seniority se mejora independientemente de si el jugador tiro o no los dados. Dado que esta
     * ligado a la cantidad de turnos.
     * */
    public void jugarTurno(Dado dado) throws TurnoPerdidoError {
        this.turno++;

        try {
            this.celdaActual = this.gladiador.mover(dado.tirar(), this.celdaActual, this.turno);
        } catch(TurnoPerdidoError e) {
            // TODO: poner logger con mensajito ;)
            // TODO: sacarlo y reformular los tests:
            throw e;
        }
    }
}
