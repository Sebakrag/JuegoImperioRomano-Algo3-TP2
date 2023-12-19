package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import edu.fiuba.algo3.modelo.excepcion.UnJugadorGanoLaPartidaError;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class ControladorJugarTurnoConImagen implements EventHandler<MouseEvent> {

    private final Juego juego;
    private final Dado dado;
    private MediaPlayer sonidoDado;

    public ControladorJugarTurnoConImagen(Juego juego) {
        this.juego = juego;
        this.dado = new Dado(6);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        String rutaSonidoObstaculo = ("sonidos/sonidoDado.mp3");
        Media sonidoObstaculo = new Media(new File(rutaSonidoObstaculo).toURI().toString());
        this.sonidoDado = new MediaPlayer(sonidoObstaculo);
        this.sonidoDado.setCycleCount(MediaPlayer.INDEFINITE);
        this.sonidoDado.setVolume(0.5);
        this.sonidoDado.play();

        // Pausar el sonido al final de la animación
        Duration duracionTotal = Duration.seconds(1.5);

        Timeline timelineDado = new Timeline(
                new KeyFrame(duracionTotal, event -> this.sonidoDado.stop())
        );
        timelineDado.play();

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
