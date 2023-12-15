package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorJugarTurno implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final Dado dado;

    public ControladorJugarTurno(Juego juego) {
        this.juego = juego;
        this.dado = new Dado(6);
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            this.juego.jugarTurnoDeJugadorActual(this.dado);
        } catch (UnJugadorGanoLaPartidaError | PasaronTreintaRondasYnoHuboGanadorError e) {
            this.juego.finalizarJuego();
        }
    }
}
