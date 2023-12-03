package edu.fiuba.algo3.interfaz.vistas.botones;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import edu.fiuba.algo3.interfaz.controladores.*;

public class BotonCantidadJugador extends Button {

    private final int cantidadJugadores;

    public BotonCantidadJugador(Stage ventana, String texto) {

        this.cantidadJugadores = Integer.parseInt(texto);

        //BackgroundFill normalFill = new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill normalFill = new BackgroundFill(Color.rgb(250, 192, 0, 0.78), CornerRadii.EMPTY, Insets.EMPTY);
        Background normalBackground = new Background(normalFill);

        BackgroundFill hoveredFill = new BackgroundFill(Color.rgb(51, 39, 0, 0.78), CornerRadii.EMPTY, Insets.EMPTY);
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

        super.setText(texto);
        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4-Medium.ttf", 12);
        super.setFont(estiloLetra);

        super.setAlignment(Pos.CENTER);

        super.setOnAction(new ControladorIngresoJugadores(ventana, this));
    }
/*
    public void pedirIngreso() {
        for (int i = 0; i < this.cantidadJugadores; i++) {
            cuadroDeTexto.verificarIngreso();
        }
    }
*/
    public int getCantidadLimite(){
        return this.cantidadJugadores;
    }
}
