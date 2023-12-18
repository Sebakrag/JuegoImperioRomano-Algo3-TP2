package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorPrincipal;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class VistaInicial extends StackPane {

    public VistaInicial(Stage stage) {
        Image imagenDeFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/fondoMenuInicial.jpg");
        ImageView viewImagenFondo = new ImageView(imagenDeFondo);
        viewImagenFondo.setPreserveRatio(false);
        viewImagenFondo.fitWidthProperty().bind(stage.widthProperty());
        viewImagenFondo.fitHeightProperty().bind(stage.heightProperty());

        this.getChildren().add(viewImagenFondo);
        this.getChildren().add(new ContenedorPrincipal(stage));
    }
}
