package edu.fiuba.algo3.interfaz.vistas.botones;

import edu.fiuba.algo3.interfaz.vistas.cuadroTexto.CuadroTextoIngreso;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import edu.fiuba.algo3.interfaz.controladores.ControladorIngresoNombre;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BotonIngresarNombre extends Button {

    public BotonIngresarNombre(String texto, CuadroTextoIngreso cuadroTexto, Label etiquetaAviso, int cantidadLimite, BotonIniciarPartida botonIniciarPartida, ArrayList<String> nombresJugadores) {
        super.setText(texto);

        BackgroundFill normalFill = new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY);
        Background normalBackground = new Background(normalFill);

        BackgroundFill hoveredFill = new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY);
        Background hoveredBackground = new Background(hoveredFill);

        //  Estilo del Boton
        this.setBackground(normalBackground);
        //  Cuando entra el Mouse
        this.setOnMouseEntered(event -> {
            this.setBackground(hoveredBackground);
        });
        //  Cuando sale el Mouse
        this.setOnMouseExited(event -> {
            this.setBackground(normalBackground);
        });

        super.setOnAction(new ControladorIngresoNombre(cuadroTexto, etiquetaAviso, cantidadLimite, this, botonIniciarPartida, nombresJugadores));
    }
}
