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
    private Label turnoActual;
    private Label nombreJugador;
    private Label numeroDeDado;
    private Label datosDelJugadorAnterior;
    private Label estado;
    private Label energiaActual;
    private Label seniority;
    private StackPane panelImagenEquipamiento;
    private StackPane panelImagenSeniority;

    public ContenedorConsola(Juego juego) {

        this.turnoActual = new Label("Ronda Actual: 1");
        this.nombreJugador = new Label("Jugador le toca tirar");
        this.numeroDeDado = new Label("Avances");

        this.datosDelJugadorAnterior = new Label("\n\nDatos del jugador Actual");
        this.estado = new Label("Estado actual:");
        this.energiaActual = new Label("Energia :");
        this.seniority = new Label("Seniority: ");

        this.panelImagenEquipamiento = new StackPane();
        this.panelImagenSeniority = new StackPane();

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        this.estiloDelLabel(this.nombreJugador, estiloLetra, "orange");
        this.estiloDelLabel(this.turnoActual, estiloLetra, "orange");
        this.estiloDelLabel(this.numeroDeDado, estiloLetra, "orange");

        //------------ Datos del jugador ----------- //

        Font estiloLetra2 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 15);
        this.estiloDelLabel(this.datosDelJugadorAnterior, estiloLetra2, "red");
        this.estiloDelLabel(this.estado, estiloLetra2, "red");
        this.estiloDelLabel(this.energiaActual, estiloLetra2, "red");
        this.estiloDelLabel(this.seniority, estiloLetra2, "red");

        HBox seniorityYImagen = new HBox();
        seniorityYImagen.getChildren().addAll(this.seniority, this.panelImagenSeniority);
        seniorityYImagen.setAlignment(Pos.CENTER);


        BotonJugarTurno botonJugarTurno = new BotonJugarTurno("Jugar Turno", juego);

        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/tableroYConsola/Consola.jpg");

        ImagePattern imagePattern = new ImagePattern(imagenFondo, 0, 0, 1, 1, true);
        BackgroundFill backgroundFill = new BackgroundFill(imagePattern, null, null);
        Background background = new Background(backgroundFill);

        this.setBackground(background);

        this.getChildren().addAll(turnoActual, nombreJugador, numeroDeDado, botonJugarTurno, datosDelJugadorAnterior, seniorityYImagen, estado, energiaActual, panelImagenEquipamiento);
        this.setAlignment(Pos.CENTER);
    }

    private void estiloDelLabel(Label label, Font font, String colorDeLetra){
        label.setFont(font);
        label.setStyle("-fx-text-fill: " + colorDeLetra + ";");
    }

    public void actualizar(String nombreJugadorActual, int ronda) {

        this.jugadorAnterior = nombreJugadorActual;
        this.turnoActual.setText("Ronda Actual: " + ronda);
        this.nombreJugador.setText("Jugador " + nombreJugadorActual + " le toca tirar");
    }

    public void actualizar(int energia, String estadoID, String seniorityID) {
        this.datosDelJugadorAnterior.setText("\n\nDatos del jugador " + this.jugadorAnterior);

        this.panelImagenSeniority.getChildren().clear();
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + seniorityID + ".png");
        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        this.panelImagenSeniority.getChildren().add(imageView);

        this.estado.setText("Estado: " + estadoID);
        this.energiaActual.setText("Energia: " + energia);
    }

    public void actualizar(String equipamientoID){
        this.panelImagenEquipamiento.getChildren().clear();

        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + equipamientoID + ".png");
        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        this.panelImagenEquipamiento.getChildren().add(imageView);
    }


    public void actualizar(int ultimoNumeroTirado){

        this.numeroDeDado.setText(this.jugadorAnterior + " avanzo " + ultimoNumeroTirado + " lugares");
    }
}
