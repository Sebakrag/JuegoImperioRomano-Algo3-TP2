package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Juego extends Observable {

    private static final int CANTIDAD_MAXIMA_DE_RONDAS = 30;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private int ronda;
    private final Logger logger;
    private Jugador jugadorTurnoActual;
    private int indiceJugadorActual;
    private Jugador jugadorInicial;
    private boolean hayGanador;

    public Juego(Logger logger, Tablero tablero) {
        this.jugadores = new ArrayList<>();
        this.logger = logger;
        this.tablero = tablero;
        this.hayGanador = false;
        this.observadores = new ArrayList<>();
    }

    // -------------------------------- PUBLICOS -------------------------------- //

    public void iniciarPartida(ArrayList<String> nombresJugadores) {
        this.crearJugadores(nombresJugadores);
        this.ronda = 1;
        int cantidadJugadores = nombresJugadores.size();
        Dado dado = new Dado(cantidadJugadores);
        this.indiceJugadorActual = (dado.tirar() - 1);
        this.jugadorInicial = this.jugadores.get(this.indiceJugadorActual);
        this.jugadorTurnoActual = this.jugadores.get(this.indiceJugadorActual);
        notificarObservadores(this.jugadorInicial.getNombre(), this.ronda);
    }

    public void jugarTurnoDeJugadorActual() throws UnJugadorGanoLaPartidaError, PasaronTreintaRondasYnoHuboGanadorError {
        Dado dado = new Dado(6);
        this.hayGanador = this.jugadorTurnoActual.jugarTurno(dado.tirar(), this.tablero);
        if (this.hayGanador) {
            throw new UnJugadorGanoLaPartidaError();
        }

        if (this.indiceJugadorActual < (this.jugadores.size() - 1)) {
            this.indiceJugadorActual++;
        } else {
            this.indiceJugadorActual = 0;
        }

        this.jugadorTurnoActual = this.jugadores.get(this.indiceJugadorActual);
        if ((this.jugadorTurnoActual == this.jugadorInicial) && quedanRondasPorJugar())
            this.ronda++;

        if (!quedanRondasPorJugar()) {
            logger.info("La partida ha terminado sin un ganador después de 30 rondas.");
            throw new PasaronTreintaRondasYnoHuboGanadorError();  // TODO: Le sacamos "Error" del nombre?
        }

        notificarObservadores(this.jugadorTurnoActual.getNombre(), this.ronda);
    }

    public void finalizarJuego() {
        notificarObservadores(this.jugadorTurnoActual.getNombre(), this.hayGanador);
    }

    public void agregarObservadorAJugadores(Observador observador) {
        for (Jugador jugador : this.jugadores) {
            jugador.agregarObservador(observador);
        }
    }

    // -------------------------------- PRIVADOS -------------------------------- //

    private void crearJugadores(ArrayList<String> nombresJugadores) {
        int cantidadJugadores = nombresJugadores.size();
        for (int i = 0; i < cantidadJugadores; i++) {
            Gladiador gladiador = new Gladiador(this.logger, this.tablero.getCeldaInicial());
            Jugador jugador = new Jugador(nombresJugadores.get(i), gladiador, this.tablero.getCeldaInicial(), this.logger);
            this.jugadores.add(jugador);
        }
    }

    private boolean quedanRondasPorJugar() {
        return (this.ronda <= CANTIDAD_MAXIMA_DE_RONDAS);
    }

    private void notificarObservadores(String nombre, int ronda) {
        for (Observador observador : this.observadores) {
            observador.actualizar(nombre, ronda);
        }
    }

    private void notificarObservadores(String nombre, boolean hayGanador){
        for (Observador observador : this.observadores) {
            observador.actualizar(nombre, hayGanador);
        }
    }
}
