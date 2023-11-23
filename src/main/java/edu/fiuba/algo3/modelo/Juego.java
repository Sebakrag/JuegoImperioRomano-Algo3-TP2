package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.CeldaInicial;

import java.util.*;


public class Juego {
    private Tablero tablero;
    private Dado dado;
    private int cantidadJugadores;  // Lo borramos? Podemos pedirlo por interfaz grafica.
    private ArrayList<Jugador> jugadores;
    private int ronda;
}

//IGNORAR
/*
    public Juego() {
        // Instanciar la interfaz grafica --> se pide la cantidad de jugadores y el ingreso de los nombres.??????
        // VERIFICAR QUE LOS JUGADORES INGRESADOS SEN ENTRE 2 Y 6

        this.jugadores = new ArrayList<Jugador>();
        CeldaInicial celdaInicial = new CeldaInicial();
        this.tablero = new Tablero(celdaInicial);
        this.dado = new Dado();
    }

    public void iniciarPartida(int cantidadCeldas, int cantidadJugadores) {
        this.tablero.armarMapa(cantidadCeldas);
        this.crearJugadores(cantidadJugadores);
        this.ronda = 0;

        //this.ordenarJugadoresPorTurno();
    }*/

   /* public void partida(int cantidadCeldas, int cantidadJugadores){
        Partida puede ser una clase concreta (o puede haber distintos tipos de partidas?).
        boolean hayGanador = false;

        iniciarPartida(cantidadCeldas, cantidadJugadores);
        int i = (this.dado.tirar() - 1);
        // int contador = 0;
        while(!hayGanador && chequearRonda()) {
            for (; i < cantidadJugadores; i++ ) {
                hayGanador = jugadores[i].jugarTurno();
                //contador++;
            }
            i = 0;

            if (contador == cantidadJugadores) {
                sigueElJuego = chequearRonda();
            }
        }*/
/*
        public void ordenarJugadoresPorTurno(int cantidadJugadores) {

            for (int i = 0; i < cantidadJugadores; i++) {
                this.dado.tirar();

            }
        }*/

    /*
    public void crearJugadores(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Gladiador gladiador = new Gladiador();
            Jugador jugador = new Jugador(gladiador, this.tablero.getCeldaInicial());
            this.jugadores.add(jugador);
        }
    }

    public boolean chequearRonda(){
         if (this.ronda != 30) {
             this.ronda ++;
             return true;
         } else {
             return false;
         }
    }
    */

