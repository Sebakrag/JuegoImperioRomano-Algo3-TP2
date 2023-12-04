package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import org.apache.logging.log4j.Logger;


import java.util.*;


public class Juego {
    private static final int CANTIDAD_MAXIMA_DE_RONDAS = 30;
    private Tablero tablero;
    private Dado dado;
    private ArrayList<Jugador> jugadores;
    private int ronda;
    private final Logger logger;

    public Juego(Logger logger) {
        // Instanciar la interfaz grafica --> se pide la cantidad de jugadores y el ingreso de los nombres.??????
        // VERIFICAR QUE LOS JUGADORES INGRESADOS SEN ENTRE 2 Y 6
        this.tablero = new Tablero();
        this.jugadores = new ArrayList<>();
        this.logger = logger;
    }

    public boolean iniciarPartida(ArrayList<Celda> celdas, int cantidadJugadores) {
        this.tablero.armarMapa(celdas);
        this.crearJugadores(cantidadJugadores);
        this.ronda = 1;
        this.dado = new Dado(cantidadJugadores);

        int i = this.dado.tirar();
        int jugadoresQueJugaron = 0;
        boolean ganador = false;
        while(chequearRonda() && !ganador) {
            for (; i < cantidadJugadores; i++ ) {
                ganador = jugadores.get(i).jugarTurno(dado, this.tablero);
                jugadoresQueJugaron++;

                if (jugadoresQueJugaron == cantidadJugadores){
                    this.ronda++;
                    jugadoresQueJugaron = 0;
                }
            }
            i = 0;
        }

        if (!ganador) {
            logger.info("La partida ha terminado sin un ganador después de 30 rondas.");
        }

        return ganador;
    }

    private void crearJugadores(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Gladiador gladiador = new Gladiador(this.logger, this.tablero.getCeldaInicial());
            Jugador jugador = new Jugador(gladiador, this.tablero.getCeldaInicial(), this.logger);
            this.jugadores.add(jugador);
        }
    }

    public boolean chequearRonda(){
        return (this.ronda <= CANTIDAD_MAXIMA_DE_RONDAS);
    }
}


