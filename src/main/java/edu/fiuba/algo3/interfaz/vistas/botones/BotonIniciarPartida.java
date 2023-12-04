package edu.fiuba.algo3.interfaz.vistas.botones;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import edu.fiuba.algo3.interfaz.controladores.ControladorInicioPartida;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class BotonIniciarPartida extends Button {

    public BotonIniciarPartida(Stage ventana, String texto, ArrayList<String> nombresJugadores) {
        super.setText(texto);

        // PARTE ASTERIIIIIIKK <3
        BackgroundFill normalFill = new BackgroundFill(Color.rgb(171, 63, 63, 1), CornerRadii.EMPTY, Insets.EMPTY);
        Background normalBackground = new Background(normalFill);

        BackgroundFill hoveredFill = new BackgroundFill(Color.rgb(119, 44, 44, 1), CornerRadii.EMPTY, Insets.EMPTY);
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

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/serif/static/SourceSerif4-Bold.ttf", 12);
        super.setFont(estiloLetra);

        this.setDisable(true);
        setOnAction(new ControladorInicioPartida(ventana, nombresJugadores));
    }
}
