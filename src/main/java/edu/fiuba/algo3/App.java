package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class App extends Application {
    private MediaPlayer sonidoPlayer;

    @Override
    public void start(Stage stage) {
        //Sonido
        String rutaSonido = ("sonidos/medieval-fantasy.mp3");
        Media sonido = new Media(new File(rutaSonido).toURI().toString());
        this.sonidoPlayer = new MediaPlayer(sonido);

        this.sonidoPlayer.setCycleCount(MediaPlayer.INDEFINITE); //Sonido en bucle
        this.sonidoPlayer.setVolume(0.04);

        this.sonidoPlayer.play(); //Reproduccion del sonido

        Scene scene = new Scene(new VistaInicial(stage), 640, 480);

        Image icono = new Image("file:" + System.getProperty("user.dir") + "/imagenes/iconoVentana.png");
        stage.setTitle("IMPERIO ROMANO");
        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}