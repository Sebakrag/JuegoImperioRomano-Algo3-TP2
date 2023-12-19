package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaJuego;
import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import edu.fiuba.algo3.parsers.TableroParser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;


public class ControladorInicioPartida implements EventHandler<ActionEvent> {

    private Stage ventana;
    private ArrayList<String> nombresJugadores;

    public ControladorInicioPartida(Stage ventana, ArrayList<String> nombresJugadores) {
        this.ventana = ventana;
        this.nombresJugadores = nombresJugadores;
    }

    @Override
    public void handle(ActionEvent evento) {
        String rutaJson = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();

        try {
            Tablero tablero = tableroParser.leerArchivo(rutaJson);

            Logger logger = LogManager.getLogger();;
            Juego juego = new Juego(logger, tablero);
            VistaJuego vistaJuego = new VistaJuego(juego, tablero, this.nombresJugadores, this.ventana);
            juego.iniciarPartida(this.nombresJugadores);

            juego.agregarObservadorAJugadores(vistaJuego);

            Scene escenaJuego = new Scene(vistaJuego);
            vistaJuego.prefWidthProperty().bind(this.ventana.widthProperty());
            vistaJuego.prefHeightProperty().bind(this.ventana.heightProperty());
            this.ventana.setScene(escenaJuego);
            this.ventana.setFullScreen(true); // Configurar la ventana para que se abra en pantalla completa
            this.ventana.setOnCloseRequest(event -> System.exit(0)); // Establecer un evento para cerrar la aplicación al presionar Esc en pantalla completa
            this.ventana.setResizable(true);

            escenaJuego.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.F11) {
                    this.ventana.setFullScreen(!this.ventana.isFullScreen());
                }
            });

        } catch (IOException | ParseException | ArchivoNoEncontradoError e) {
            return;
        }
    }
}
