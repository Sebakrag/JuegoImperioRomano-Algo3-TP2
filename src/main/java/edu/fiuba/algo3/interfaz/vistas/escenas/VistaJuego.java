package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonTirarDado;
import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorConsola;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class VistaJuego extends GridPane {

    //TODO: VER SI HACEMOS ESTO -> private final ContenedorConsola contenedorConsola;

    public VistaJuego(VistaTablero tableroJuego, ArrayList<String> nombresJugadores) {

        VBox consola = this.crearConsola(); //TODO: Pasar a ContenedorConsola

        ColumnConstraints columnaTablero = new ColumnConstraints();
        columnaTablero.setPercentWidth(80); // Primera columna ocupa el 80% de la ventana
        ColumnConstraints columnaConsola = new ColumnConstraints();
        super.getColumnConstraints().addAll(columnaTablero, columnaConsola);

        super.add(tableroJuego, 0, 0);
        super.add(consola, 1, 0);
    }

    private VBox crearConsola() {
        VBox consola = new VBox();

        Label nombreJugador = new Label("Jugador " + "Juan" + " le toca tirar");

        Font estiloLetraTitulo = Font.loadFont("file:" + System.getProperty("user.dir") + "/fuentes/Cinzel-Black.ttf", 20);
        nombreJugador.setFont(estiloLetraTitulo);
        nombreJugador.setStyle("-fx-text-fill: orange");

        BotonTirarDado jugarTurno = new BotonTirarDado("Jugar Turno");
        //jugarTurno.setPrefWidth(Button.USE_COMPUTED_SIZE);

        consola.getChildren().addAll(nombreJugador, jugarTurno);
        consola.setAlignment(Pos.CENTER);

        return consola;
    }
}
