package edu.fiuba.algo3.interfaz.vistas.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ContenedorPrincipal extends VBox {

    public ContenedorPrincipal(Stage stage) {
        Label imperioRomanoEtiqueta = new Label("Imperio Romano");
        Label vamoAJugaEtiqueta = new Label("Vamo' a juga'?");
        Label cantidadDeJugadoresEtiqueta = new Label("Elija el número de jugadores:");

        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 60);
        Font estiloLetraTitulo2 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4_18pt-MediumItalic.ttf", 30);
        Font estiloLetraTitulo3 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4-Medium.ttf", 25);
        this.estiloDelLabel(imperioRomanoEtiqueta, estiloLetraTitulo, "black");
        this.estiloDelLabel(vamoAJugaEtiqueta, estiloLetraTitulo2, "black");
        this.estiloDelLabel(cantidadDeJugadoresEtiqueta, estiloLetraTitulo3, "black");

        ContenedorBotonesDeMenuInicial contenedorBotones = new ContenedorBotonesDeMenuInicial(stage);

        BackgroundFill fondo = new BackgroundFill(Color.rgb(117, 90, 0, 0.5), CornerRadii.EMPTY, Insets.EMPTY);
        Background fondoMenuInicial = new Background(fondo);

        this.getChildren().addAll(imperioRomanoEtiqueta, vamoAJugaEtiqueta, cantidadDeJugadoresEtiqueta, contenedorBotones);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setBackground(fondoMenuInicial);
    }

    private void estiloDelLabel(Label label, Font font, String colorDeLetra){
        label.setFont(font);
        label.setStyle("-fx-text-fill: " + colorDeLetra + ";");
    }
}
