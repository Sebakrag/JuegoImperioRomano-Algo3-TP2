package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorBotonesDeMenuInicial extends HBox {

    public ContenedorBotonesDeMenuInicial(Stage stage) {
        Button boton2 = new BotonCantidadJugador(stage, "2");
        Button boton3 = new BotonCantidadJugador(stage, "3");
        Button boton4 = new BotonCantidadJugador(stage, "4");
        Button boton5 = new BotonCantidadJugador(stage, "5");
        Button boton6 = new BotonCantidadJugador(stage, "6");

        this.getChildren().addAll(boton2, boton3, boton4, boton5, boton6);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }
}
