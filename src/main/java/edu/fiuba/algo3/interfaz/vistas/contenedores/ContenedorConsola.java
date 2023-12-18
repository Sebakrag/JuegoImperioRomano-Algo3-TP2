package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonJugarTurnoConImagen;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import java.util.ArrayList;


public class ContenedorConsola extends VBox {
    private String jugadorAnterior;
    private Label turnoActual;
    private Label nombreJugador;
    private Label numeroDeDado;
    private Label datosDelJugadorAnterior;
    private Label estado;
    private Label energiaActual;
    private StackPane panelImagenEquipamiento;
    private StackPane panelImagenSeniority;
    private StackPane panelImagenJugadorActual;
    private StackPane panelImagenJugadorAnterior;
    private final ArrayList<StackPane> jugadores;

    public ContenedorConsola(Juego juego, ArrayList<StackPane> jugadores) {
        this.jugadores = jugadores;
        this.turnoActual = new Label("\n\n\n\nRonda Actual: 1");
        this.nombreJugador = new Label("\n\n\n\nJugador le toca tirar");
        this.numeroDeDado = new Label("Avances");
        Label separarDado = new Label("\n\n");

        this.datosDelJugadorAnterior = new Label("\n\n\n\nDatos del jugador Actual");
        this.estado = new Label("Estado actual:");
        this.energiaActual = new Label("Energia :");

        this.panelImagenEquipamiento = new StackPane();
        this.panelImagenSeniority = new StackPane();
        this.panelImagenJugadorActual = new StackPane();
        this.panelImagenJugadorAnterior = new StackPane();

        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        this.estiloDelLabel(this.nombreJugador, estiloLetra, "orange");
        this.estiloDelLabel(this.turnoActual, estiloLetra, "orange");

        //------------ Datos del jugador ----------- //

        Font estiloLetra2 = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 15);
        this.estiloDelLabel(this.numeroDeDado, estiloLetra2, "orange");
        this.estiloDelLabel(this.datosDelJugadorAnterior, estiloLetra, "orange");
        this.estiloDelLabel(this.estado, estiloLetra2, "orange");
        this.estiloDelLabel(this.energiaActual, estiloLetra2, "orange");


        //BotonJugarTurno botonJugarTurno = new BotonJugarTurno("Jugar Turno", juego);
        StackPane panelDado = this.crearPanelDado(juego);

        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/tableroYConsola/Consola.jpg");

        ImagePattern imagePattern = new ImagePattern(imagenFondo, 0, 0, 1, 1, true);
        BackgroundFill backgroundFill = new BackgroundFill(imagePattern, null, null);
        Background background = new Background(backgroundFill);

        this.setBackground(background);

        this.getChildren().addAll(turnoActual, nombreJugador, panelImagenJugadorActual, separarDado, panelDado, datosDelJugadorAnterior, panelImagenJugadorAnterior, numeroDeDado, panelImagenSeniority,estado, energiaActual, panelImagenEquipamiento);
        this.setAlignment(Pos.TOP_CENTER);
    }

    private StackPane crearPanelDado(Juego juego){
        ImageView imagenDado = new BotonJugarTurnoConImagen(juego);
        Rectangle fondo = new Rectangle(50, 50, Color.ORANGE);
        StackPane panel = new StackPane(fondo, imagenDado);

        panel.setOnMouseEntered(event -> {
            fondo.setFill(Color.DARKORANGE);
        });

        panel.setOnMouseExited(event -> {
            fondo.setFill(Color.ORANGE);
        });

        return panel;
    }

    private void estiloDelLabel(Label label, Font font, String colorDeLetra){
        label.setFont(font);
        label.setStyle("-fx-text-fill: " + colorDeLetra + ";");
    }

    public void actualizar(String nombreJugadorActual, int ronda) {
        this.jugadorAnterior = nombreJugadorActual;
        this.turnoActual.setText("\n\n\n\nRonda Actual: " + ronda);
        this.nombreJugador.setText("\n\n\n\nSiguiente jugador: " + nombreJugadorActual);
        StackPane panelImagen = this.obtenerPanelJugador(nombreJugadorActual);

        if(panelImagen != null){
            ImageView imagenJugador = (ImageView) panelImagen.getChildren().get(0);
            Image imagen = this.imagenJugador(imagenJugador.getImage());
            ImageView imagenJugadorActual = new ImageView(imagen);
            imagenJugadorActual.setFitWidth(75);
            imagenJugadorActual.setFitHeight(75);
            this.panelImagenJugadorActual.getChildren().clear();
            this.panelImagenJugadorActual.getChildren().setAll(imagenJugadorActual);
        }
    }

    private Image imagenJugador(Image imagen){
        String rutaImagen = imagen.getUrl();
        Image imagenDevolver = new Image(rutaImagen);

        return imagenDevolver;
    }

    private StackPane obtenerPanelJugador(String nombre) {
        for (StackPane jugador : this.jugadores) {
            Label nombreJugador = (Label) jugador.getChildren().get(1);
            if (nombreJugador.getText().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public void actualizar(int energia, String estadoID, String seniorityID) {
        StackPane panelImagen = this.obtenerPanelJugador(this.jugadorAnterior);

        if(panelImagen != null){
            ImageView imagenJugador = (ImageView) panelImagen.getChildren().get(0);
            Image imagen = this.imagenJugador(imagenJugador.getImage());
            ImageView imagenJugadorActual = new ImageView(imagen);
            imagenJugadorActual.setFitWidth(75);
            imagenJugadorActual.setFitHeight(75);
            this.panelImagenJugadorAnterior.getChildren().clear();
            this.panelImagenJugadorAnterior.getChildren().setAll(imagenJugadorActual);
        }


        this.datosDelJugadorAnterior.setText("\n\n\n\nDatos del jugador " + this.jugadorAnterior);

        this.panelImagenSeniority.getChildren().clear();
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + seniorityID + ".png");
        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        this.panelImagenSeniority.getChildren().add(imageView);

        this.estado.setText(estadoID);
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
