package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
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