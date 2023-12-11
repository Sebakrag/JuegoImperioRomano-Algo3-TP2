package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ContenedorTablero extends GridPane {
    private final int xInicial;
    private final int yInicial;
    private final ArrayList<StackPane> jugadores;  // Array de StackPanes de gladiadores
    private List<String> imagenesGladiadores;

    public ContenedorTablero(Tablero tablero, ArrayList<String> nombresJugadores) {
        int columnas = tablero.getLargo();
        int filas = tablero.getAncho();
        this.xInicial = tablero.getCeldaInicial().getX();
        this.yInicial = tablero.getCeldaInicial().getY();
        this.jugadores = new ArrayList<>();
        this.imagenesGladiadores = new ArrayList<>(List.of(
                "Gladiador1.png",
                "Gladiador2.png",
                "Gladiador3.png",
                "Gladiador4.png",
                "Gladiador5.png",
                "Gladiador6.png"
        ));

        super.setAlignment(Pos.CENTER);

        // Configurar restricciones de columna
        for (int i = 0; i < columnas; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / columnas);
            this.getColumnConstraints().add(columnConstraints);
        }

        // Configurar restricciones de fila
        for (int i = 0; i < filas; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / filas);
            this.getRowConstraints().add(rowConstraints);
        }

        this.rellenarConCeldasPasto(tablero);
        this.crearCamino(tablero);
        this.agregarJugadores(nombresJugadores);
    }


    // -------------------------------- PUBLICOS -------------------------------- //
    public void actualizar(String nombre, Celda _celdaAnterior, Celda celdaActual, int avances) {
        // TODO: Pregunta si el contenedorTablero puede ser un observador.
        // Quizas vista tablero no es un observador, sino que el observador
        // es vistaJuego y le da la indicacion a tablero para mover.
        StackPane jugador = obtenerPanelJugador(nombre);
        int retrasoEntreIteracionesEnMilisegundos = 500; // 1000 ms = 1 segundo
        Timeline timeline = new Timeline();

        if (jugador != null && avances != 0) {
            Celda celdaAnterior = _celdaAnterior.celdaSiguiente();
            if(avances == 1){
                int finalX = celdaAnterior.getX();
                int finalY = celdaAnterior.getY();
                setConstraints(jugador, finalX, finalY);
            }
            else{
                for (int i = 0; i < avances; i++) {
                    int finalX = celdaAnterior.getX();
                    int finalY = celdaAnterior.getY();

                    KeyFrame keyFrame = new KeyFrame(
                            Duration.millis(i * retrasoEntreIteracionesEnMilisegundos),
                            event -> {
                                setConstraints(jugador, finalX, finalY);
                            }
                    );
                    timeline.getKeyFrames().add(keyFrame);

                    celdaAnterior = celdaAnterior.celdaSiguiente();
                }
                timeline.play();
            }
        }
    }


    // -------------------------------- PRIVADOS -------------------------------- //
    private void crearCamino(Tablero tablero) {
        Celda celdaActual = tablero.getCeldaInicial();

        while (!(celdaActual == tablero.getCeldaFinal())) {
            int x = celdaActual.getX();
            int y = celdaActual.getY();
            String nombrePremio = celdaActual.nombreImagenPremio();
            String nombreObstaculo = celdaActual.nombreImagenObstaculo();

            StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);
            setConstraints(panelCeldaActual, x, y);

            if(!nombrePremio.isEmpty()){
                ImageView imagenPremio = this.crearImagenPremioObstaculo(nombrePremio);
                panelCeldaActual.getChildren().add(imagenPremio);
                StackPane.setAlignment(imagenPremio, Pos.CENTER_RIGHT);
            }

            if(!nombreObstaculo.isEmpty()){
                ImageView imagenObstaculo = this.crearImagenPremioObstaculo(nombreObstaculo);
                panelCeldaActual.getChildren().add(imagenObstaculo);
                StackPane.setAlignment(imagenObstaculo, Pos.CENTER_LEFT);
            }

            super.getChildren().add(panelCeldaActual);

            celdaActual = celdaActual.celdaSiguiente();
        }
        int x = celdaActual.getX();
        int y = celdaActual.getY();
        // Llegado este punto se crea el panel de la celda final y se lo ubica en la grilla del tablero.
        StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);
        setConstraints(panelCeldaActual, x, y);
        super.getChildren().add(panelCeldaActual);
    }

    private ImageView crearImagenPremioObstaculo(String imagenPremioObstaculo){
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + imagenPremioObstaculo + ".png");
        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        return imageView;
    }

    private void rellenarConCeldasPasto(Tablero tablero) {
        for (int i = 0; i < tablero.getAncho(); i++) {
            for (int j = 0; j < tablero.getLargo(); j++) {
                StackPane panelCelda = crearPanelCelda("imagenPasto.png");
                super.getChildren().add(panelCelda);
                setConstraints(panelCelda, j, i);
            }
        }
    }

    private StackPane crearPanelCelda(String nombreImagen) {
        StackPane panelCelda = new StackPane();
        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + nombreImagen);

        ImagePattern imagePattern = new ImagePattern(imagenFondo, 0, 0, 1, 1, true);
        BackgroundFill backgroundFill = new BackgroundFill(imagePattern, null, null);
        Background background = new Background(backgroundFill);

        panelCelda.setBackground(background);

        panelCelda.prefWidthProperty().bind(super.widthProperty());
        panelCelda.prefHeightProperty().bind(super.heightProperty());

        return panelCelda;
    }

    private void agregarJugadores(ArrayList<String> nombresJugadores) {
        int i = 0;
        while (i < nombresJugadores.size()) {
            StackPane panelJugador = crearPanelJugador(nombresJugadores, i);

            this.jugadores.add(panelJugador);

            super.getChildren().add(panelJugador);
            setConstraints(panelJugador, this.xInicial, this.yInicial);
            i++;
        }
    }

    private StackPane crearPanelJugador(ArrayList<String> nombresJugadores, int indiceJugador) {

        StackPane panelJugador = crearPanelCelda(this.imagenesGladiadores.get(indiceJugador));
        Label etiquetaNombreJugador = new Label(nombresJugadores.get(indiceJugador));
        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        etiquetaNombreJugador.setFont(estiloLetra);
        etiquetaNombreJugador.setStyle("-fx-text-fill: RED");

        panelJugador.getChildren().add(etiquetaNombreJugador);

        return panelJugador;
    }

    // TODO: Decidir si vamos a poner imagenes de afectantes en las celdas
    private StackPane crearPanelCamino(Celda celdaActual) {
        return crearPanelCelda(celdaActual.nombreImagenFondo());

        // Si optamos por no agregar una imagen del premio y del obstaculo en cada celda, el metodo crearPanelCamino
        // pasa a ser innecesario y usariamos "crearPanelCelda" como su reemplazante.

        /*   Este codigo comentado sirve si queremos poner una imagen del premio y del obstaculo en cada celda que tenga el respectivo premio u obstaculo
        StackPane panelCelda = crearPanelCelda(celdaActual.nombreImagenFondo());
        Image imagenPremio = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenPremio());
        Image imagenObstaculo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenObstaculo());

        ImageView viewImagenPremio = new ImageView(imagenPremio);
        viewImagenPremio.setFitHeight(20);
        viewImagenPremio.setFitWidth(20);

        ImageView viewImagenObstaculo = new ImageView(imagenObstaculo);
        viewImagenObstaculo.setFitHeight(20);
        viewImagenObstaculo.setFitWidth(20);

        panelCelda.getChildren().add(viewImagenPremio);
        panelCelda.getChildren().add(viewImagenObstaculo);

        return panelCelda;
        */
    }

    private StackPane obtenerPanelJugador(String nombre) {
        for (StackPane jugador : this.jugadores) {
            Label nombreJugador = (Label) jugador.getChildren().get(0);
            if (nombreJugador.getText().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }
}
