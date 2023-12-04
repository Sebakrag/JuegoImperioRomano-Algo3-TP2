package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaTablero;
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

    private Stage ventana;
    private ArrayList<String> nombresJugadores;

    public ControladorInicioPartida(Stage ventana, ArrayList<String> nombresJugadores) {
        this.ventana = ventana;
        this.nombresJugadores = nombresJugadores;
    }

    @Override
    public void handle(ActionEvent evento){
        // TODO: Si no llegamos a poner un boceto escribimos: "Tablero en construccion ;)" CON BOB EL CONSTRUCTOR
        // Parsear el JSON.
        String rutaJson = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();
        /*
        try {
            Tablero tablero = tableroParser.leerArchivo(rutaJson);
            VistaTablero vistaTablero = new VistaTablero(tablero);
            Scene escenaTablero = new Scene(vistaTablero);
            vistaTablero.prefWidthProperty().bind(escenaTablero.widthProperty());
            vistaTablero.prefHeightProperty().bind(escenaTablero.heightProperty());
            this.ventana.setScene(escenaTablero);

            Logger logger = LogManager.getLogger();;
            Juego juego = new Juego(logger);
            //juego.iniciarPartida(tablero, this.nombresJugadores);  TODO: Hay que modificar el metodo iniciarPartida de Juego para que reciba el tablero
        } catch (IOException | ParseException) {
            return;
        }
        */

    }
}
