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
import javafx.stage.Stage;
import java.util.ArrayList;

public class ContenedorTablero extends GridPane {

    private int xInicial;
    private int yInicial;
    private Stage ventana;

    private ArrayList<StackPane> jugadores;  // Array de StackPanes de gladiadores

    public ContenedorTablero(Tablero tablero, ArrayList<String> nombresJugadores, Stage ventana) {
        this.ventana = ventana;
        int columnas = tablero.getLargo();
        int filas = tablero.getAncho();
        this.xInicial = tablero.getCeldaInicial().getX();
        this.yInicial = tablero.getCeldaInicial().getY();
        this.jugadores = new ArrayList<>();

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
    public void actualizar(String nombre, Celda celda) {
        // TODO: Pregunta si el contenedorTablero puede ser un observador.
        // Quizas vista tablero no es un observador, sino que el observador
        // es vistaJuego y le da la indicacion a tablero para mover.
        StackPane gladiador = moverImagenGladiador(nombre);
        setConstraints(gladiador, celda.getX(), celda.getY());
    }


    // -------------------------------- PRIVADOS -------------------------------- //
    private void crearCamino(Tablero tablero) {
        Celda celdaActual = tablero.getCeldaInicial();

        while (!(celdaActual == tablero.getCeldaFinal())) {
            int x = celdaActual.getX();
            int y = celdaActual.getY();

            StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);
            setConstraints(panelCeldaActual, x, y);
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

        StackPane panelJugador = new StackPane();
        Label etiquetaNombreJugador = new Label(nombresJugadores.get(indiceJugador));
        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/SourceSerif4-Bold.ttf", 15);
        etiquetaNombreJugador.setFont(estiloLetra);
        etiquetaNombreJugador.setStyle("-fx-text-fill: RED");

        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/jugador.png");
        ImageView imagenGladiador = new ImageView(imagenFondo);
        imagenGladiador.setPreserveRatio(false);

        panelJugador.prefWidthProperty().bind(super.widthProperty());
        panelJugador.prefHeightProperty().bind(super.heightProperty());

        panelJugador.getChildren().addAll(imagenGladiador, etiquetaNombreJugador);
        panelJugador.setAlignment(Pos.CENTER);

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

    private StackPane moverImagenGladiador(String nombre) {
        for (StackPane jugador : this.jugadores) {
            Label label = (Label) jugador.getChildren().get(1);
            if (label.getText().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }
}
