package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonJugarTurno;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.geometry.Pos;


public class ContenedorConsola extends VBox {
    private String jugadorAnterior;
    public ContenedorConsola(Juego juego) {

        Label turnoActual = new Label("Ronda Actual: 1");
        Label nombreJugador = new Label("Jugador le toca tirar");
        Label numeroDeDado = new Label("Avances");

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        nombreJugador.setFont(estiloLetra);
        nombreJugador.setStyle("-fx-text-fill: orange");
        turnoActual.setFont(estiloLetra);
        turnoActual.setStyle("-fx-text-fill: orange");
        numeroDeDado.setFont(estiloLetra);
        numeroDeDado.setStyle("-fx-text-fill: orange");

        BotonJugarTurno botonJugarTurno = new BotonJugarTurno("Jugar Turno", juego);

        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/tableroYConsola/Consola.jpg");

        ImagePattern imagePattern = new ImagePattern(imagenFondo, 0, 0, 1, 1, true);
        BackgroundFill backgroundFill = new BackgroundFill(imagePattern, null, null);
        Background background = new Background(backgroundFill);

        this.setBackground(background);

        this.getChildren().addAll(turnoActual, nombreJugador, numeroDeDado, botonJugarTurno);
        this.setAlignment(Pos.CENTER);
    }

    public void actualizar(String nombreJugadorActual, int ronda) {
        Label turnoActual = (Label) this.getChildren().get(0);
        Label nombreJugador = (Label) this.getChildren().get(1);
        this.jugadorAnterior = nombreJugadorActual;
        turnoActual.setText("Ronda Actual: " + ronda);
        nombreJugador.setText("Jugador " + nombreJugadorActual + " le toca tirar");
    }

    public void actualizar(String seniorityID) {
        //poner logica
    }

    public void actualizar(int energia, String estadoID) {
        //poner logica
    }

    public void actualizar(int ultimoNumeroTirado){
        Label numeroDeDado = (Label) this.getChildren().get(2);

        numeroDeDado.setText(this.jugadorAnterior + " avanzo " + ultimoNumeroTirado + " lugares");
    }
}
