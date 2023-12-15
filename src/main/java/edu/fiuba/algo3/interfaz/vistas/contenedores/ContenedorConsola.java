package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonJugarTurno;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

        Label datos = new Label("\nDatos del jugador Actual");
        Label estado = new Label("Estado actual:");
        Label energiaActual = new Label("Energia :");
        Label seniority = new Label("Seniority jugador:");

        StackPane panelImagen = new StackPane();

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        nombreJugador.setFont(estiloLetra);
        nombreJugador.setStyle("-fx-text-fill: orange");
        turnoActual.setFont(estiloLetra);
        turnoActual.setStyle("-fx-text-fill: orange");
        numeroDeDado.setFont(estiloLetra);
        numeroDeDado.setStyle("-fx-text-fill: orange");

        //------------ Datos del jugador ----------- //

        Font estiloLetra2 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 15);
        datos.setFont(estiloLetra2);
        datos.setStyle("-fx-text-fill: orange");
        estado.setFont(estiloLetra2);
        estado.setStyle("-fx-text-fill: orange");
        energiaActual.setFont(estiloLetra2);
        energiaActual.setStyle("-fx-text-fill: orange");
        seniority.setFont(estiloLetra2);
        seniority.setStyle("-fx-text-fill: orange");


        BotonJugarTurno botonJugarTurno = new BotonJugarTurno("Jugar Turno", juego);

        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/tableroYConsola/Consola.jpg");

        ImagePattern imagePattern = new ImagePattern(imagenFondo, 0, 0, 1, 1, true);
        BackgroundFill backgroundFill = new BackgroundFill(imagePattern, null, null);
        Background background = new Background(backgroundFill);

        this.setBackground(background);

        this.getChildren().addAll(turnoActual, nombreJugador, numeroDeDado, botonJugarTurno, datos, seniority, estado, energiaActual, panelImagen);
        this.setAlignment(Pos.CENTER);
    }

    public void actualizar(String nombreJugadorActual, int ronda) {
        Label turnoActual = (Label) this.getChildren().get(0);
        Label nombreJugador = (Label) this.getChildren().get(1);
        this.jugadorAnterior = nombreJugadorActual;
        turnoActual.setText("Ronda Actual: " + ronda);
        nombreJugador.setText("Jugador " + nombreJugadorActual + " le toca tirar");
    }

    public void actualizar(int energia, String estadoID, String seniorityID) {
        Label seniority = (Label) this.getChildren().get(5);
        Label estado = (Label) this.getChildren().get(6);
        Label energiaActual = (Label) this.getChildren().get(7);

        seniority.setText("Seniority jugador: " + seniorityID);
        estado.setText("Estado: " + estadoID);
        energiaActual.setText("Energia: " + energia);
    }

    public void actualizar(String equipamientoID){
        StackPane panelImagen = (StackPane) this.getChildren().get(8);
        panelImagen.getChildren().clear();

        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + equipamientoID + ".png");
        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        panelImagen.getChildren().add(imageView);
    }

    /*public void actualizar(int energia, String estadoID) {
        Label estado = (Label) this.getChildren().get(7);
        Label energiaActual = (Label) this.getChildren().get(8);

        estado.setText("Estado: " + estadoID);
        energiaActual.setText("Energia: " + energia);
        //this.getChildren().add(7, estado);
        //this.getChildren().add(8, energiaActual);
    }*/

    public void actualizar(int ultimoNumeroTirado){
        Label numeroDeDado = (Label) this.getChildren().get(2);

        numeroDeDado.setText(this.jugadorAnterior + " avanzo " + ultimoNumeroTirado + " lugares");
    }
}
