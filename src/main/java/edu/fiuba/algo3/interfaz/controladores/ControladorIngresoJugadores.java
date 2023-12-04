package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIniciarPartida;
import edu.fiuba.algo3.interfaz.vistas.cuadroTexto.CuadroTextoIngreso;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
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
        Label etiquetaIngreso = new Label("Ingrese un nombre:");
        CuadroTextoIngreso cuadroTexto = new CuadroTextoIngreso();
        ArrayList<String> nombresJugadores = new ArrayList<>();
        BotonIniciarPartida botonInciarPartida = new BotonIniciarPartida(this.ventana, "Iniciar Partida", nombresJugadores);

        Label etiquetaAviso = new Label("");
        BotonIngresarNombre botonIngresarNombre = new BotonIngresarNombre("Ingresar", cuadroTexto, etiquetaAviso, cantidadLimite, botonInciarPartida, nombresJugadores);
        HBox contenedorIngreso = new HBox(etiquetaIngreso, cuadroTexto, botonIngresarNombre);
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
        VBox disposicionIngreso = new VBox(contenedorIngreso, etiquetaAviso, botonInciarPartida);
        disposicionIngreso.setAlignment(Pos.CENTER);
        disposicionIngreso.setSpacing(8);
        return new Scene(disposicionIngreso, 500, 500);
    }

    @Override
    public void handle(ActionEvent evento) {
        Scene escenaIngresoJugadores = crearEscenaIngreso();
        //Scene escenaIngresoJugadores = new EscenaIngreso(this.boton);
        this.ventana.setScene(escenaIngresoJugadores);
    }
}
