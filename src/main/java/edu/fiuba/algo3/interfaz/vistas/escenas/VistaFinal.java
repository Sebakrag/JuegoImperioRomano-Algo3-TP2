package edu.fiuba.algo3.interfaz.vistas.escenas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaFinal extends StackPane {

    public VistaFinal(String textoLabel, String rutaImagen, Stage ventana) {

        Label labelFinalizarJuego = new Label(textoLabel);
        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4-Bold.ttf", 40);
        labelFinalizarJuego.setFont(estiloLetra);
        labelFinalizarJuego.setStyle("-fx-text-fill: red");

        Image imagenGanador = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + rutaImagen);
        ImageView viewImagenGanador = new ImageView(imagenGanador);

        viewImagenGanador.fitWidthProperty().bind(ventana.widthProperty());
        viewImagenGanador.fitHeightProperty().bind(ventana.heightProperty());

        this.getChildren().addAll(viewImagenGanador, labelFinalizarJuego);
        this.setAlignment(Pos.CENTER);

        this.prefWidthProperty().bind(ventana.widthProperty());
        this.prefHeightProperty().bind(ventana.heightProperty());
    }
}
