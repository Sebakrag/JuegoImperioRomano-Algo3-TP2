package edu.fiuba.algo3.interfaz.vistas.botones;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import edu.fiuba.algo3.interfaz.controladores.ControladorInicioPartida;
import javafx.stage.Stage;


public class BotonIniciarPartida extends Button {

    public BotonIniciarPartida(Stage ventana, String texto) {
        super.setText(texto);

        // PARTE ASTERIIIIIIKK <3
        BackgroundFill normalFill = new BackgroundFill(Color.LIME, CornerRadii.EMPTY, Insets.EMPTY);
        Background normalBackground = new Background(normalFill);

        BackgroundFill hoveredFill = new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY);
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
        //

        this.setDisable(true);
        setOnAction(new ControladorInicioPartida(ventana));
    }
}
