package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonTirarDado;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;


public class ContenedorConsola extends VBox {

    public ContenedorConsola() {

        Label nombreJugador = new Label("Jugador " + "Juan" + " le toca tirar");

        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        nombreJugador.setFont(estiloLetraTitulo);
        nombreJugador.setStyle("-fx-text-fill: orange");

        BotonTirarDado jugarTurno = new BotonTirarDado("Jugar Turno");
        //jugarTurno.setPrefWidth(Button.USE_COMPUTED_SIZE);

        this.getChildren().addAll(nombreJugador, jugarTurno);
        this.setAlignment(Pos.CENTER);
    }
}
