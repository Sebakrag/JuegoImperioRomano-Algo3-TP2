package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIniciarPartida;
import edu.fiuba.algo3.interfaz.vistas.cuadroTexto.CuadroTextoIngreso;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class ContenedorIngresoNombre extends HBox {

    public ContenedorIngresoNombre(Label etiquetaAviso, int cantidadLimite, BotonIniciarPartida botonIniciarPartida, ArrayList<String> nombresJugadores, Label etiquetaIngreso) {
        CuadroTextoIngreso cuadroTexto = new CuadroTextoIngreso(nombresJugadores);
        BotonIngresarNombre botonIngresarNombre = new BotonIngresarNombre("Ingresar", cuadroTexto, etiquetaAviso, cantidadLimite, botonIniciarPartida, nombresJugadores, etiquetaIngreso);
        cuadroTexto.asociarTeclaEnterConBotonIngresarNombre(botonIngresarNombre);

        this.getChildren().addAll(cuadroTexto, botonIngresarNombre);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(3);
    }
}
