package edu.fiuba.algo3.interfaz.controladores;


import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorJugarTurno implements EventHandler<ActionEvent> {

    private final Juego juego;

    public ControladorJugarTurno(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            this.juego.jugarTurnoDeJugadorActual();
        } catch (UnJugadorGanoLaPartidaError | PasaronTreintaRondasYnoHuboGanadorError e) {
            this.juego.finalizarJuego();
        }
    }
}
