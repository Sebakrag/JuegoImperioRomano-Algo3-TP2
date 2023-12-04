package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import javafx.geometry.Pos;

import javafx.stage.Stage;
import javafx.scene.control.Button;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label imperioRomanoEtiqueta = new Label("Imperio Romano");
        Label vamoAJugaEtiqueta = new Label("Vamo' a juga'?");

        Label cantidadDeJugadoresEtiqueta = new Label("Elija el número de jugadores:");

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

        var scene = new Scene(contenedorPrincipal, 640, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}