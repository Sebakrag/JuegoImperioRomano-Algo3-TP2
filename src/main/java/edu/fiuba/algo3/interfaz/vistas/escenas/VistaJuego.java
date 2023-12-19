package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorConsola;
import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorTablero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;


public class VistaJuego extends GridPane implements Observador {
    private final ContenedorConsola contenedorConsola;
    private final ContenedorTablero contenedorTablero;
    private Stage ventana;
    private MediaPlayer sonidoPlayerCaminata;
    private MediaPlayer sonidoPlayerAplusos;
    private MediaPlayer sonidoPlayerObstaculo;
    private MediaPlayer sonidoPlayerPremio;

    public VistaJuego(Juego juego, Tablero tablero, ArrayList<String> nombreJugadores, Stage ventana) {
        this.ventana = ventana;
        juego.agregarObservador(this);

        //Sonido
        String rutaSonidoCaminata = ("sonidos/Caminata.mp3");
        String rutaSonidoAplausos = ("sonidos/Aplausos.mp3");

        Media sonidoCaminata = new Media(new File(rutaSonidoCaminata).toURI().toString());
        Media sonidoAplausos = new Media(new File(rutaSonidoAplausos).toURI().toString());

        this.sonidoPlayerCaminata = new MediaPlayer(sonidoCaminata);
        this.sonidoPlayerAplusos = new MediaPlayer(sonidoAplausos);

        this.sonidoPlayerCaminata.setCycleCount(MediaPlayer.INDEFINITE); //Sonido en bucle
        this.sonidoPlayerCaminata.setVolume(0.2);
        this.sonidoPlayerAplusos.setCycleCount(MediaPlayer.INDEFINITE);
        this.sonidoPlayerAplusos.setVolume(0.3);

        this.sonidoPlayerObstaculo = new MediaPlayer(sonidoAplausos);
        this.sonidoPlayerPremio = new MediaPlayer(sonidoAplausos);

        this.sonidoPlayerObstaculo.setCycleCount(MediaPlayer.INDEFINITE);
        this.sonidoPlayerObstaculo.setVolume(0.01);
        this.sonidoPlayerPremio.setCycleCount(MediaPlayer.INDEFINITE);
        this.sonidoPlayerPremio.setVolume(0.01);

        this.contenedorTablero = new ContenedorTablero(tablero, nombreJugadores, this.sonidoPlayerCaminata, this.sonidoPlayerObstaculo, this.sonidoPlayerPremio);
        this.contenedorConsola = new ContenedorConsola(juego, this.contenedorTablero.getJugadoresImagenes());

        //Los StackPane los cree para que se adapten bien a la ventana (funcionaba), pero ahora que agregue las imagenes de los afectantes no se adapta bien
        StackPane panelTablero = new StackPane(this.contenedorTablero);
        StackPane panelConsola = new StackPane(this.contenedorConsola);

        ColumnConstraints columnaTablero = new ColumnConstraints();
        ColumnConstraints columnaConsola = new ColumnConstraints();
        columnaTablero.setPercentWidth(80); // Primera columna ocupa el 80% de la ventana
        columnaConsola.setPercentWidth(20); // Segunda columna ocupa el 20% de la ventana
        super.getColumnConstraints().addAll(columnaTablero, columnaConsola);

        super.add(panelTablero, 0, 0);
        super.add(panelConsola, 1, 0);

        panelTablero.prefWidthProperty().bind(this.widthProperty());
        panelTablero.prefHeightProperty().bind(this.heightProperty());

        panelConsola.prefWidthProperty().bind(this.widthProperty());
        panelConsola.prefHeightProperty().bind(this.heightProperty());
    }

    public void actualizar(String nombreJugador, Celda celdaAnterior, Celda celdaActual, int avances) {
        if (celdaAnterior != celdaActual) {
            this.contenedorConsola.actualizar(avances);
            this.contenedorConsola.actualizar(celdaActual.nombreImagenPremio(), celdaActual.nombreImagenObstaculo());
            this.contenedorTablero.actualizar(nombreJugador, celdaAnterior, celdaActual);
        } else {
            this.contenedorConsola.actualizar(0);
            this.contenedorConsola.actualizar("", "");
        }
    }

    public void actualizar(String nombreJugadorActual, int ronda) {
        this.contenedorConsola.actualizar(nombreJugadorActual, ronda);
    }

    public void actualizar(int energia, String estadoID, String seniorityID) {
        this.contenedorConsola.actualizar(energia, estadoID, seniorityID);
    }

    public void actualizar(String equipamientoID) {
        this.contenedorConsola.actualizar(equipamientoID);
    }

    public void actualizar(String nombreJugador, boolean hayGanador) {
        String textoFinal;
        String rutaImagen;

        if (hayGanador) {
            this.sonidoPlayerAplusos.play();
            textoFinal = "¡GANADOR " + "\"" + nombreJugador + "\"" + "!";
            rutaImagen = "imagenGanador.gif";
        } else {
            textoFinal = "¡¡¡PERDEDORES!!!";
            rutaImagen = "imagenPerdedor.gif";
        }

        StackPane panelFinalizarJuego = new VistaFinal(textoFinal, rutaImagen, this.ventana);

        Scene escenaFinJuego = new Scene(panelFinalizarJuego, 800, 600);
        this.ventana.setScene(escenaFinJuego);
        this.ventana.setFullScreen(true); // Configurar la ventana para que se abra en pantalla completa
        this.ventana.setOnCloseRequest(event -> System.exit(0)); // Establecer un evento para cerrar la aplicación al presionar Esc en pantalla completa

        escenaFinJuego.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F11) {
                this.ventana.setFullScreen(!this.ventana.isFullScreen());
            }
        });
    }
}
