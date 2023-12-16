package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class ControladorJugarTurnoConImagen implements EventHandler<MouseEvent> {

    private final Juego juego;
    private final Dado dado;

    public ControladorJugarTurnoConImagen(Juego juego) {
        this.juego = juego;
        this.dado = new Dado(6);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            this.juego.jugarTurnoDeJugadorActual(this.dado);
        } catch (UnJugadorGanoLaPartidaError | PasaronTreintaRondasYnoHuboGanadorError e) {
            //FUNCIONA BIEN :D, gana despues de transcurir 3seg
            Duration duracion = Duration.seconds(3);
            KeyFrame keyFrame = new KeyFrame(duracion, event -> {
                this.juego.finalizarJuego();
            });
            Timeline timeline = new Timeline(keyFrame);
            timeline.play();
        }
    }
}
