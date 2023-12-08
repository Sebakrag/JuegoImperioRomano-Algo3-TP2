package edu.fiuba.algo3.interfaz.vistas.botones;

import edu.fiuba.algo3.interfaz.controladores.ControladorJugarTurno;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BotonJugarTurno extends Button {

    public BotonJugarTurno(String texto, Juego juego){
        super.setText(texto);

        BackgroundFill normalFill = new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY);
        Background normalBackground = new Background(normalFill);

        BackgroundFill hoveredFill = new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY);
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

        this.setOnAction(new ControladorJugarTurno(juego));
    }
}
