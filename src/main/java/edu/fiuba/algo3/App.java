package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.geometry.Pos;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane panelPrincipal = new StackPane();

        Label imperioRomanoEtiqueta = new Label("Imperio Romano");
        Label vamoAJugaEtiqueta = new Label("Vamo' a juga'?");
        Label cantidadDeJugadoresEtiqueta = new Label("Elija el número de jugadores:");

        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-VariableFont_wght.ttf", 40);
        imperioRomanoEtiqueta.setFont(estiloLetraTitulo);
        imperioRomanoEtiqueta.setStyle("-fx-text-fill: black");
        vamoAJugaEtiqueta.setFont(new Font("Arial", 20));
        vamoAJugaEtiqueta.setStyle("-fx-text-fill: black");
        cantidadDeJugadoresEtiqueta.setFont(new Font("Arial", 20));
        cantidadDeJugadoresEtiqueta.setStyle("-fx-text-fill: black");

        // color mostaza: 117, 90, 0, 1
        BackgroundFill fondo = new BackgroundFill(Color.rgb(97, 74, 0, 0.78), CornerRadii.EMPTY, Insets.EMPTY);
        Background fondoMenuInicial = new Background(fondo);
        imperioRomanoEtiqueta.setBackground(fondoMenuInicial);
        vamoAJugaEtiqueta.setBackground(fondoMenuInicial);
        cantidadDeJugadoresEtiqueta.setBackground(fondoMenuInicial);

        Button boton2 = new BotonCantidadJugador(stage, "2");
        Button boton3 = new BotonCantidadJugador(stage, "3");
        Button boton4 = new BotonCantidadJugador(stage, "4");
        Button boton5 = new BotonCantidadJugador(stage, "5");
        Button boton6 = new BotonCantidadJugador(stage, "6");

        HBox contenedorBotones = new HBox(boton2, boton3, boton4, boton5, boton6);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(10);

        Font estiloLetraBotonCreditos = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-VariableFont_wght.ttf", 12);
        Button botonCreditos = new Button("Créditos");
        botonCreditos.setFont(estiloLetraBotonCreditos);

        VBox contenedorPrincipal = new VBox(imperioRomanoEtiqueta, vamoAJugaEtiqueta, cantidadDeJugadoresEtiqueta, contenedorBotones, botonCreditos);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(10);

        //Imagen de Fondo
        Image imagenDeFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/ArmaduraGladiador.jpg");
        ImageView viewImagenFondo = new ImageView(imagenDeFondo);
        viewImagenFondo.setPreserveRatio(false);
        viewImagenFondo.fitWidthProperty().bind(stage.widthProperty());
        viewImagenFondo.fitHeightProperty().bind(stage.heightProperty());

        panelPrincipal.getChildren().add(viewImagenFondo);
        panelPrincipal.getChildren().add(contenedorPrincipal);
        //

        var scene = new Scene(panelPrincipal, 640, 480);

        Image icono = new Image("file:" + System.getProperty("user.dir") + "/imagenes/juguito2.png");
        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}