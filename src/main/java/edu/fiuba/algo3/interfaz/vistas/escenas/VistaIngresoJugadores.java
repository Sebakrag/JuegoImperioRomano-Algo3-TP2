package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIniciarPartida;
import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorIngresoNombre;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaIngresoJugadores extends VBox {

    public VistaIngresoJugadores(BotonCantidadJugador boton, Stage ventana) {
        int cantidadLimite = boton.getCantidadLimite();

        Label etiquetaIngreso = new Label("Ingrese nombre del jugador 1");
        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4-SemiBold.ttf", 20);
        etiquetaIngreso.setFont(estiloLetraTitulo);
        etiquetaIngreso.setStyle("-fx-text-fill: black");

        Label etiquetaAviso = new Label("");
        Font estiloLetraAviso = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4-MediumItalic.ttf", 12);
        etiquetaAviso.setFont(estiloLetraAviso);
        etiquetaAviso.setStyle("-fx-text-fill: black");

        ArrayList<String> nombresJugadores = new ArrayList<>();

        BotonIniciarPartida botonIniciarPartida = new BotonIniciarPartida(ventana, "Iniciar Partida", nombresJugadores);

        ContenedorIngresoNombre contenedorIngresoNombre = new ContenedorIngresoNombre(etiquetaAviso, cantidadLimite, botonIniciarPartida, nombresJugadores, etiquetaIngreso);

        Image imagenDeGladiador = new Image("file:" + System.getProperty("user.dir") + "/imagenes/imagenIngreso.png");
        ImageView viewImagenDeGladiador = new ImageView(imagenDeGladiador);

        viewImagenDeGladiador.setPreserveRatio(false);
        viewImagenDeGladiador.setFitWidth(150);
        viewImagenDeGladiador.setFitHeight(150);

        this.getChildren().addAll(viewImagenDeGladiador, etiquetaIngreso, contenedorIngresoNombre, etiquetaAviso, botonIniciarPartida);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(8);

        BackgroundFill fondo = new BackgroundFill(Color.rgb(117, 90, 0, 1), CornerRadii.EMPTY, Insets.EMPTY);
        Background fondoDeEscena = new Background(fondo);
        this.setBackground(fondoDeEscena);
    }
}
