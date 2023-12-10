package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonJugarTurno;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;


public class ContenedorConsola extends VBox {

    public ContenedorConsola(Juego juego) {

        Label turnoActual = new Label("Ronda Actual: 1");
        Label nombreJugador = new Label("Jugador le toca tirar");

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        nombreJugador.setFont(estiloLetra);
        nombreJugador.setStyle("-fx-text-fill: orange");
        turnoActual.setFont(estiloLetra);
        turnoActual.setStyle("-fx-text-fill: orange");

        BotonJugarTurno botonJugarTurno = new BotonJugarTurno("Jugar Turno", juego);
        //botonJugarTurno.setPrefWidth(BotonJugarTurno.USE_COMPUTED_SIZE);

        this.getChildren().addAll(turnoActual, nombreJugador, botonJugarTurno);
        this.setAlignment(Pos.CENTER);
    }

    public void actualizar(String nombreJugadorActual, int ronda) {
        Label turnoActual = (Label) this.getChildren().get(0);
        Label nombreJugador = (Label) this.getChildren().get(1);

        turnoActual.setText("Ronda Actual: " + ronda);
        nombreJugador.setText("Jugador " + "\"" + nombreJugadorActual + "\"" + " le toca tirar");
    }

    public void actualizar(String seniorityID) {
        //poner logica
    }

    public void actualizar(int energia, String estadoID) {
        //poner logica
    }
}
