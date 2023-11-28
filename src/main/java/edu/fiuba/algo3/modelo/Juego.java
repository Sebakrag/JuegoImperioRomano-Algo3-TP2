package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.CeldaInicial;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import java.util.*;


public class Juego {
    private static final int CANTIDAD_MAXIMA_DE_RONDAS = 30;
    private Tablero tablero;
    private Dado dado;
    private int cantidadJugadores;  // Lo borramos? Podemos pedirlo por interfaz grafica.
    private ArrayList<Jugador> jugadores;
    private int ronda;

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


