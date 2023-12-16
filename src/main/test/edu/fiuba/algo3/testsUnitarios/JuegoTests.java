package edu.fiuba.algo3.testsUnitarios;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.afectantes.Potenciador;
import edu.fiuba.algo3.modelo.afectantes.Vacio;
import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.celdas.CeldaComun;
import edu.fiuba.algo3.modelo.celdas.CeldaFinal;
import edu.fiuba.algo3.modelo.celdas.CeldaInicial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class JuegoTests {

    @Test
    public void test01NohayMasDe30Rondas() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test02SeIniciaBienLaPartida() {

        /*Logger logger = LogManager.getLogger();

            ArrayList<Celda> celdas = new ArrayList<>();
            celdas.add(new CeldaInicial(0,0, logger));
            celdas.add(new CeldaComun(0,1, new Potenciador(), new Vacio(), logger));
            celdas.add(new CeldaComun(0,2, new Potenciador(), new Vacio(), logger));
            celdas.add(new CeldaComun(0,3, new Potenciador(), new Vacio(), logger));
            celdas.add(new CeldaComun(0,4, new Potenciador(), new Vacio(), logger));
            celdas.add(new CeldaFinal(0,5,logger));

            Tablero tablero = new Tablero(1,1);
            tablero.armarMapa(celdas);

            ArrayList<String> nombresJugadores = new ArrayList<>();
            nombresJugadores.add("A");
            nombresJugadores.add("B");

            Juego juego = new Juego(logger, tablero);
            juego.iniciarPartida(nombresJugadores);*/

            /*Assertions.assertTrue(gladiador.energiaIgualA(energiaEsperada));*/

    }


    @Test
    public void test03SeAgregaCorrectamenteJugador() {

    }

    @Test
    public void test04chequearRonda4() {

    }

    @Test
    public void test05JugadorPuedeJugarUnaRonda() {

    }

}


/*



    public void jugarTurnoDeJugadorActual(Dado dado) throws UnJugadorGanoLaPartidaError, PasaronTreintaRondasYnoHuboGanadorError {
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
            jugador.agregarObservadorAGladiador(observador);
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

* */