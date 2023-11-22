package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.CeldaInicial;

import java.util.*;


public class Juego {
    private Tablero tablero;
    private int cantidadJugadores;  // Lo borramos? Podemos pedirlo por interfaz grafica.
    private ArrayList<Jugador> jugadores;

    public Juego() {
        // Instanciar la interfaz grafica --> se pide la cantidad de jugadores y el ingreso de los nombres.??????
        // VERIFICAR QUE LOS JUGADORES INGRESADOS SEN ENTRE 2 Y 6
        this.jugadores = new ArrayList<Jugador>();

        CeldaInicial celdaInicial = new CeldaInicial();
        this.tablero = new Tablero(celdaInicial);
    }

    public void iniciarJuego(int cantidadCeldas){
        this.tablero.armarMapa(cantidadCeldas);

        //Cantidad de jugadores a jugar -> Lo pedimos por interfaz.
        this.crearJugadores(this.cantidadJugadores);


    }

    public void crearJugadores(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Gladiador gladiador = new Gladiador();
            //Jugador jugador = new Jugador(gladiador, this.tablero.getCeldaInicial());
            //this.jugadores.add(jugador);
        }
    }

    // Este metodo va aca (no en Jugador):
    // public boolean chequearTurno(){
    //     if (this.turnos != 30) {
    //         this.turnos ++;
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
}
