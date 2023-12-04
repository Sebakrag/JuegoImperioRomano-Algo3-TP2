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
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane panelPrincipal = new StackPane();

        Label imperioRomanoEtiqueta = new Label("Imperio Romano");
        Label vamoAJugaEtiqueta = new Label("Vamo' a juga'?");
        Label cantidadDeJugadoresEtiqueta = new Label("Elija el número de jugadores:");

        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/static/Cinzel-Black.ttf", 60);
        Font estiloLetraTitulo2 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/serif/static/SourceSerif4_18pt-MediumItalic.ttf", 30);
        Font estiloLetraTitulo3 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/serif/static/SourceSerif4-Medium.ttf", 25);
        imperioRomanoEtiqueta.setFont(estiloLetraTitulo);
        imperioRomanoEtiqueta.setStyle("-fx-text-fill: black");
        vamoAJugaEtiqueta.setFont(estiloLetraTitulo2);
        vamoAJugaEtiqueta.setStyle("-fx-text-fill: black");
        cantidadDeJugadoresEtiqueta.setFont(estiloLetraTitulo3);
        cantidadDeJugadoresEtiqueta.setStyle("-fx-text-fill: black");

        // color mostaza: 117, 90, 0, 1
        BackgroundFill fondo = new BackgroundFill(Color.rgb(117, 90, 0, 0.5), CornerRadii.EMPTY, Insets.EMPTY);
        Background fondoMenuInicial = new Background(fondo);

        Button boton2 = new BotonCantidadJugador(stage, "2");
        Button boton3 = new BotonCantidadJugador(stage, "3");
        Button boton4 = new BotonCantidadJugador(stage, "4");
        Button boton5 = new BotonCantidadJugador(stage, "5");
        Button boton6 = new BotonCantidadJugador(stage, "6");

        HBox contenedorBotones = new HBox(boton2, boton3, boton4, boton5, boton6);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(10);

        //Font estiloLetraBotonCreditos = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/static/Cinzel-Black.ttf", 12);

        //Button botonCreditos = new Button("Créditos");
        //botonCreditos.setFont(estiloLetraBotonCreditos);

        VBox contenedorPrincipal = new VBox(imperioRomanoEtiqueta, vamoAJugaEtiqueta, cantidadDeJugadoresEtiqueta, contenedorBotones);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setBackground(fondoMenuInicial);

        /*
        DoubleProperty fontSize = new SimpleDoubleProperty(12);
        imperioRomanoEtiqueta.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
        fontSize.bind(Bindings.createDoubleBinding(
                () -> contenedorPrincipal.getWidth() / imperioRomanoEtiqueta.getText().length() * 1.5, // Puedes ajustar este factor según tus necesidades
                contenedorPrincipal.widthProperty(), imperioRomanoEtiqueta.textProperty()));
        */

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
        stage.setTitle("IMPERIO ROMANO");
        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}