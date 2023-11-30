package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class Juego {
    private static final int CANTIDAD_MAXIMA_DE_RONDAS = 30;
    private Tablero tablero;
    private Dado dado;
    private int cantidadJugadores;  // Lo borramos? Podemos pedirlo por interfaz grafica.
    private ArrayList<Jugador> jugadores;
    private int ronda;
    private static final Logger logger = LogManager.getLogger();

    public Juego() {
        // Instanciar la interfaz grafica --> se pide la cantidad de jugadores y el ingreso de los nombres.??????
        // VERIFICAR QUE LOS JUGADORES INGRESADOS SEN ENTRE 2 Y 6
        this.tablero = new Tablero();
        this.jugadores = new ArrayList<>();
    }

    public void iniciarPartida(ArrayList<Celda> celdas, int cantidadJugadores) {
        this.tablero.armarMapa(celdas);
        this.crearJugadores(cantidadJugadores);
        this.ronda = 1;
        this.dado = new Dado(cantidadJugadores);

        int i = this.dado.tirar();
        int jugadoresQueJugaron = 0;
        while(chequearRonda()) {
            for (; i < cantidadJugadores; i++ ) {
                jugadores.get(i).jugarTurno(dado);
                jugadoresQueJugaron++;

                if (jugadoresQueJugaron == cantidadJugadores){
                    this.ronda++;
                    jugadoresQueJugaron = 0;
                }
            }
            i = 0;
        }

        logger.info("La partida ha terminado sin un ganador después de 30 rondas.");
        throw new PasaronTreintaRondasYnoHuboGanadorError();
    }

    public void crearJugadores(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Gladiador gladiador = new Gladiador();
            Jugador jugador = new Jugador(gladiador, this.tablero.getCeldaInicial());
            this.jugadores.add(jugador);
        }
    }

    public boolean chequearRonda(){
        return (this.ronda <= CANTIDAD_MAXIMA_DE_RONDAS);
    }
}


