package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIniciarPartida;
import edu.fiuba.algo3.interfaz.vistas.cuadroTexto.CuadroTextoIngreso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import java.util.ArrayList;


public class ControladorIngresoJugadores implements EventHandler<ActionEvent> {
    
    private final Stage ventana;
    private final BotonCantidadJugador boton;

    public ControladorIngresoJugadores(Stage ventana, BotonCantidadJugador boton) {
        this.ventana = ventana;
        this.boton = boton;
    }

    //TODO: ver de modularizar esta funcion:
    private Scene crearEscenaIngreso() {
        int cantidadLimite = this.boton.getCantidadLimite();
        Label etiquetaIngreso = new Label("Ingrese un nombre");
        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/serif/static/SourceSerif4-SemiBold.ttf", 20);
        etiquetaIngreso.setFont(estiloLetraTitulo);
        etiquetaIngreso.setStyle("-fx-text-fill: black");

        CuadroTextoIngreso cuadroTexto = new CuadroTextoIngreso();
        ArrayList<String> nombresJugadores = new ArrayList<>();
        BotonIniciarPartida botonInciarPartida = new BotonIniciarPartida(this.ventana, "Iniciar Partida", nombresJugadores);

        Label etiquetaAviso = new Label("");
        Font estiloLetraAviso = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/serif/static/SourceSerif4-MediumItalic.ttf", 12);
        etiquetaAviso.setFont(estiloLetraAviso);
        etiquetaAviso.setStyle("-fx-text-fill: black");
        BotonIngresarNombre botonIngresarNombre = new BotonIngresarNombre("Ingresar", cuadroTexto, etiquetaAviso, cantidadLimite, botonInciarPartida, nombresJugadores);
        HBox contenedorIngreso = new HBox(cuadroTexto, botonIngresarNombre);
        contenedorIngreso.setAlignment(Pos.CENTER);
        contenedorIngreso.setSpacing(3);


        //Button botonInciarPartida = new Button("Iniciar Partida");
/*
        // PARTE ASTERIK
        BackgroundFill normalFill = new BackgroundFill(Color.LIME, CornerRadii.EMPTY, Insets.EMPTY);
        Background normalBackground = new Background(normalFill);

        BackgroundFill hoveredFill = new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background hoveredBackground = new Background(hoveredFill);

        //  Estilo del Boton
        botonInciarPartida.setBackground(normalBackground);
        //  Cuando entra el Mouse
        botonInciarPartida.setOnMouseEntered(event -> {
            botonInciarPartida.setBackground(hoveredBackground);
        });
        //  Cuando sale el Mouse
        botonInciarPartida.setOnMouseExited(event -> {
            botonInciarPartida.setBackground(normalBackground);
        });
        //
*/
        Image imagenDeGladiador = new Image("file:" + System.getProperty("user.dir") + "/imagenes/gladiador.png");
        ImageView viewImagenDeGladiador = new ImageView(imagenDeGladiador);

        viewImagenDeGladiador.setPreserveRatio(false);
        viewImagenDeGladiador.setFitWidth(150);
        viewImagenDeGladiador.setFitHeight(150);

        VBox disposicionIngreso = new VBox(viewImagenDeGladiador, etiquetaIngreso, contenedorIngreso, etiquetaAviso, botonInciarPartida);
        disposicionIngreso.setAlignment(Pos.CENTER);
        disposicionIngreso.setSpacing(8);

        BackgroundFill fondo = new BackgroundFill(Color.rgb(117, 90, 0, 1), CornerRadii.EMPTY, Insets.EMPTY);
        Background fondoDeEscena = new Background(fondo);
        disposicionIngreso.setBackground(fondoDeEscena);

        return new Scene(disposicionIngreso, 500, 500);
    }

    @Override
    public void handle(ActionEvent evento) {
        Scene escenaIngresoJugadores = crearEscenaIngreso();
        //Scene escenaIngresoJugadores = new EscenaIngreso(this.boton);
        this.ventana.setScene(escenaIngresoJugadores);
    }
}
