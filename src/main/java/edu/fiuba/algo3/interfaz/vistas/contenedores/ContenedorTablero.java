package edu.fiuba.algo3.interfaz.vistas.contenedores;

import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ContenedorTablero extends GridPane {
    private final int xInicial;
    private final int yInicial;
    private final ArrayList<StackPane> jugadores;  // Array de StackPanes de gladiadores
    private final ArrayList<StackPane> jugadoresImagenes;
    private List<String> imagenesGladiadores;
    private Tablero tablero;
    private MediaPlayer sonidoPlayerCaminata;

    public ContenedorTablero(Tablero tablero, ArrayList<String> nombresJugadores, MediaPlayer sonidoCaminata) {
        this.tablero = tablero;

        this.sonidoPlayerCaminata = sonidoCaminata;

        int columnas = tablero.getLargo();
        int filas = tablero.getAncho();
        this.xInicial = tablero.getCeldaInicial().getX();
        this.yInicial = tablero.getCeldaInicial().getY();
        this.jugadores = new ArrayList<>();
        this.jugadoresImagenes = new ArrayList<>();
        this.imagenesGladiadores = new ArrayList<>(List.of(
                "gladiadores/Gladiador1",
                "gladiadores/Gladiador2",
                "gladiadores/Gladiador3",
                "gladiadores/Gladiador4",
                "gladiadores/Gladiador5",
                "gladiadores/Gladiador6"
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
    public void actualizar(String nombre, Celda celdaAnterior, Celda celdaActual) {
        StackPane jugador = obtenerPanelJugador(nombre);
        int retrasoEntreIteracionesEnMilisegundos = 500; // 1000 ms = 1 segundo
        Timeline timeline = new Timeline();

        if (jugador != null) {
            Celda celdaSiguiente = celdaAnterior.celdaSiguiente();
            if (celdaSiguiente == celdaActual) {
                int finalX = celdaSiguiente.getX();
                int finalY = celdaSiguiente.getY();
                setConstraints(jugador, finalX, finalY);
                // Pausar el sonido al final de la animación
                //this.sonidoPlayerCaminata.pause();
            } else {
                this.sonidoPlayerCaminata.play(); //Reproduccion del sonido
                int i = 0;
                Celda verificarCeldaFinal;
                boolean celdaFinal = false;

                while (celdaAnterior != celdaActual) {
                    celdaAnterior = celdaAnterior.celdaSiguiente();
                    int finalX = celdaAnterior.getX();
                    int finalY = celdaAnterior.getY();

                    verificarCeldaFinal = celdaAnterior.celdaSiguiente();
                    if(celdaAnterior == verificarCeldaFinal){
                        celdaAnterior = celdaActual;
                        celdaFinal = true;
                    }

                    KeyFrame keyFrame = new KeyFrame(
                            Duration.millis(i * retrasoEntreIteracionesEnMilisegundos),
                            event -> {
                                setConstraints(jugador, finalX, finalY);
                            }
                    );
                    timeline.getKeyFrames().add(keyFrame);
                    i++;
                }
                if(celdaFinal){
                    int finalX = celdaActual.getX();
                    int finalY = celdaActual.getY();
                    setConstraints(jugador, finalX, finalY);
                    KeyFrame keyFrame = new KeyFrame(
                            Duration.millis(i * retrasoEntreIteracionesEnMilisegundos),
                            event -> {
                                setConstraints(jugador, finalX, finalY);
                                // Pausar el sonido al final de la animación
                                this.sonidoPlayerCaminata.pause();
                            }
                    );
                    timeline.getKeyFrames().add(keyFrame);
                }else{
                    KeyFrame keyFrame = new KeyFrame(
                            Duration.millis(i * retrasoEntreIteracionesEnMilisegundos),
                            event -> {
                                // Pausar el sonido al final de la animación
                                this.sonidoPlayerCaminata.pause();
                            }
                    );
                    timeline.getKeyFrames().add(keyFrame);
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

            StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);

            super.getChildren().add(panelCeldaActual);
            setConstraints(panelCeldaActual, x, y);

            celdaActual = celdaActual.celdaSiguiente();
        }

        int x = celdaActual.getX();
        int y = celdaActual.getY();
        // Llegado este punto se crea el panel de la celda final y se lo ubica en la grilla del tablero.
        StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);
        setConstraints(panelCeldaActual, x, y);
        super.getChildren().add(panelCeldaActual);
    }

    private ImageView crearImagenPremioObstaculo(String imagenPremioObstaculo) {
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + imagenPremioObstaculo + ".png");
        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);

        return imageView;
    }

    private void rellenarConCeldasPasto(Tablero tablero) {
        for (int i = 0; i < tablero.getAncho(); i++) {
            for (int j = 0; j < tablero.getLargo(); j++) {
                StackPane panelCelda = crearPanelCelda("imagenPasto");
                super.getChildren().add(panelCelda);
                setConstraints(panelCelda, j, i);
            }
        }
    }

    private StackPane crearPanelCelda(String nombreImagen) {
        StackPane panelCelda = new StackPane();
        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/tableroYConsola/" + nombreImagen + ".png");

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
            StackPane panelJugador2 = crearPanelJugadorImagenView(nombresJugadores, i);

            this.jugadores.add(panelJugador);
            this.jugadoresImagenes.add(panelJugador2);

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
        etiquetaNombreJugador.setVisible(false); //Hace la etiqueta invisible

        panelJugador.getChildren().add(etiquetaNombreJugador);

        return panelJugador;
    }

    private StackPane crearPanelJugadorImagenView(ArrayList<String> nombresJugadores, int indiceJugador) {

        StackPane panelJugador = crearPanelCeldaConImagenView(this.imagenesGladiadores.get(indiceJugador));
        Label etiquetaNombreJugador = new Label(nombresJugadores.get(indiceJugador));
        Font estiloLetra = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        etiquetaNombreJugador.setFont(estiloLetra);
        etiquetaNombreJugador.setStyle("-fx-text-fill: RED");

        panelJugador.getChildren().add(etiquetaNombreJugador);

        return panelJugador;
    }

    private StackPane crearPanelCeldaConImagenView(String nombreImagen) {
        StackPane panelCelda = new StackPane();
        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/tableroYConsola/" + nombreImagen + ".png");

        ImageView imageView = new ImageView(imagenFondo);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        panelCelda.getChildren().add(imageView);

        return panelCelda;
    }

    private StackPane crearPanelCamino(Celda celdaActual) {
        StackPane celdaCamino = this.crearPanelCelda(celdaActual.nombreImagenFondo());
        String nombrePremio = celdaActual.nombreImagenPremio();
        String nombreObstaculo = celdaActual.nombreImagenObstaculo();

        if (!nombrePremio.isEmpty()) {
            String ruta = "premios/" + nombrePremio;
            ImageView imagenPremio = this.crearImagenPremioObstaculo(ruta);
            celdaCamino.getChildren().add(imagenPremio);
            StackPane.setAlignment(imagenPremio, Pos.CENTER_RIGHT);
        }

        if (!nombreObstaculo.isEmpty()) {
            String ruta = "obstaculos/" + nombreObstaculo;
            ImageView imagenObstaculo = this.crearImagenPremioObstaculo(ruta);
            celdaCamino.getChildren().add(imagenObstaculo);
            StackPane.setAlignment(imagenObstaculo, Pos.CENTER_LEFT);
        }

        return celdaCamino;
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

    public ArrayList<StackPane> getJugadoresImagenes(){
        return this.jugadoresImagenes;
    }
}
