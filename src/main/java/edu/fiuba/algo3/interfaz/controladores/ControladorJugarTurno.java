package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorJugarTurno implements EventHandler<ActionEvent> {

    private final Dado dado;
    private final Juego juego;

    public ControladorJugarTurno(Juego juego) {
        this.juego = juego;
        this.dado = new Dado(6);
    }

    @Override
    public void handle(ActionEvent evento) {

        int avances = this.dado.tirar();
        try {
            this.juego.jugarTurnoDeJugadorActual(avances);
        } catch (UnJugadorGanoLaPartidaError | PasaronTreintaRondasYnoHuboGanadorError e) {
            // Hay que finalizar el juego. Quizas le podemos mandar un mensaje al juego para que cambie su estado
            // y le notifique a sus observadores.
            this.juego.finalizarJuego();
        }
    }
}
