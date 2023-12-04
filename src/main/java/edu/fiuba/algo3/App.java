package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.geometry.Pos;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane panelPrincipal = new StackPane();

        Label imperioRomanoEtiqueta = new Label("Imperio Romano");
        Label vamoAJugaEtiqueta = new Label("Vamo' a juga'?");
        Label cantidadDeJugadoresEtiqueta = new Label("Elija el número de jugadores:");

        //Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/FuentesDeLetras/Cinzel-VariableFont_wght.ttf", 35);

        //imperioRomanoEtiqueta.setFont(estiloLetra);
        imperioRomanoEtiqueta.setStyle("-fx-text-fill: white");
        vamoAJugaEtiqueta.setFont(new Font("Arial", 20));
        vamoAJugaEtiqueta.setStyle("-fx-text-fill: white");
        cantidadDeJugadoresEtiqueta.setFont(new Font("Arial", 20));
        cantidadDeJugadoresEtiqueta.setStyle("-fx-text-fill: white");

        Button boton2 = new BotonCantidadJugador(stage, "2");
        Button boton3 = new BotonCantidadJugador(stage, "3");
        Button boton4 = new BotonCantidadJugador(stage, "4");
        Button boton5 = new BotonCantidadJugador(stage, "5");
        Button boton6 = new BotonCantidadJugador(stage, "6");

        HBox contenedorBotones = new HBox(boton2, boton3, boton4, boton5, boton6);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(10);

        Button botonCreditos = new Button("Créditos");

        VBox contenedorPrincipal = new VBox(imperioRomanoEtiqueta, vamoAJugaEtiqueta, cantidadDeJugadoresEtiqueta, contenedorBotones, botonCreditos);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(10);

        //Imagen de Fondo
        Image imagenDeFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/FondoDeInicio.jpg");
        ImageView viewImagenFondo = new ImageView(imagenDeFondo);
        viewImagenFondo.setFitHeight(480);
        viewImagenFondo.setFitWidth(640);

        panelPrincipal.getChildren().add(viewImagenFondo);
        panelPrincipal.getChildren().add(contenedorPrincipal);
        //

        var scene = new Scene(panelPrincipal, 640, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}