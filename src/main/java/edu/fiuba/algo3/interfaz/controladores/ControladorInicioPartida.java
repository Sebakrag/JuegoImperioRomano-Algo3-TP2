package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaTablero;
import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import edu.fiuba.algo3.parsers.TableroParser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;

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
        // TODO: Si no llegamos a poner un boceto escribimos: "Tablero en construccion ;)" CON BOB EL CONSTRUCTOR
        String rutaJson = "/archivos/mapaPrueba.json";
        TableroParser tableroParser = new TableroParser();

        try {
            Tablero tablero = tableroParser.leerArchivo(rutaJson);
            VistaTablero vistaTablero = new VistaTablero(tablero);
            Scene escenaTablero = new Scene(vistaTablero, tablero.getAncho()*TAMANIO_CELDA, tablero.getLargo()*TAMANIO_CELDA); // --> Esto deberia ser si parseamos las dimensiones del JSON y creamos el tablero con el atributo ancho y alto
            vistaTablero.prefWidthProperty().bind(this.ventana.widthProperty());
            vistaTablero.prefHeightProperty().bind(this.ventana.heightProperty());
            this.ventana.setScene(escenaTablero);
            this.ventana.setResizable(true);

            Logger logger = LogManager.getLogger();;
            Juego juego = new Juego(logger);
            //juego.iniciarPartida(tablero, this.nombresJugadores);
        } catch (IOException | ParseException | ArchivoNoEncontradoError e) {
            return;
        }
    }
}
