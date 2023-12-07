package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonTirarDado;
import edu.fiuba.algo3.interfaz.vistas.escenas.VistaJuego;
import edu.fiuba.algo3.interfaz.vistas.escenas.VistaTablero;
import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import edu.fiuba.algo3.parsers.TableroParser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import edu.fiuba.algo3.interfaz.vistas.escenas.VistaJuego;

import static javafx.scene.layout.GridPane.setConstraints;

public class ControladorInicioPartida implements EventHandler<ActionEvent> {

    private static final int TAMANIO_CELDA = 50;
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

            VistaTablero vistaTablero = new VistaTablero(tablero, nombresJugadores);
            VistaJuego vistaJuego = new VistaJuego(vistaTablero, nombresJugadores);

            /*
            gridPane.add(node, columnIndex, rowIndex, columnSpan, rowSpan);
            node: El nodo que se está agregando.
            columnIndex: La columna en la que se ubicará el nodo.
            rowIndex: La fila en la que se ubicará el nodo.
            columnSpan: La cantidad de columnas que el nodo ocupará.
            rowSpan: La cantidad de filas que el nodo ocupará.
            */

            Scene escenaJuego = new Scene(vistaJuego);
            vistaJuego.prefWidthProperty().bind(this.ventana.widthProperty());
            vistaJuego.prefHeightProperty().bind(this.ventana.heightProperty());
            this.ventana.setScene(escenaJuego);
            this.ventana.setResizable(true);

            Logger logger = LogManager.getLogger();;
            Juego juego = new Juego(logger);
            juego.iniciarPartida(tablero, this.nombresJugadores);
        } catch (IOException | ParseException | ArchivoNoEncontradoError e) {
            return;
        }
    }
}
