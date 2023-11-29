package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Jugador {
    private static final int CANTIDAD_MAXIMA_DE_RONDAS = 30;
    private Gladiador gladiador;
    private int turno;
    private Celda celdaActual;

    public Jugador(Gladiador gladiador, Celda celdaInicial) {
        this.gladiador = gladiador;
        this.turno = 0;
        this.celdaActual = celdaInicial;
    }

    public void jugarTurno(Dado dado) {

        this.turno++;
        
        if (!this.gladiador.estaLesionado() && this.gladiador.tieneEnergia()) {
            int avances = dado.tirar();
            this.avanzar(avances);
            this.celdaActual = this.celdaActual.afectar(this.gladiador);

        } else {
            this.gladiador.sanar();
            this.gladiador.mejorarSeniority(this.turno);
            this.gladiador.aumentarEnergia();
            throw new TurnoPerdidoError();
        }
        /*
         * Suponemos que: el seniority se mejora independientemente de si el jugador tiro o no los dados. Dado que esta
         * ligado a la cantidad de turnos.
         * */
        this.gladiador.mejorarSeniority(this.turno);
        this.gladiador.aumentarEnergia();
    }


    private void avanzar(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.celdaActual = this.celdaActual.celdaSiguiente();
        }
    }
}
