package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonJugarTurno;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;


public class ContenedorConsola extends VBox {

    public ContenedorConsola(Juego juego) {

        Label nombreJugador = new Label("Jugador " + "Juan" + " le toca tirar");

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        nombreJugador.setFont(estiloLetra);
        nombreJugador.setStyle("-fx-text-fill: orange");

        BotonJugarTurno botonJugarTurno = new BotonJugarTurno("Jugar Turno", juego);
        //botonJugarTurno.setPrefWidth(Button.USE_COMPUTED_SIZE);

        this.getChildren().addAll(nombreJugador, botonJugarTurno);
        this.setAlignment(Pos.CENTER);
    }
}
