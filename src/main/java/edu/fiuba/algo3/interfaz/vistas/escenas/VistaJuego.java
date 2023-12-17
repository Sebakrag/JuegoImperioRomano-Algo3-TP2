package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorConsola;
import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorTablero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;


public class VistaJuego extends GridPane implements Observador {
    private final ContenedorConsola contenedorConsola;
    private final ContenedorTablero contenedorTablero;
    private Stage ventana;

    public VistaJuego(Juego juego, Tablero tablero, ArrayList<String> nombreJugadores, Stage ventana) {
        this.ventana = ventana;
        juego.agregarObservador(this);

        this.contenedorTablero = new ContenedorTablero(tablero, nombreJugadores);
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
            this.contenedorTablero.actualizar(nombreJugador, celdaAnterior, celdaActual);
        } else {
            this.contenedorConsola.actualizar(0);
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
            textoFinal = "¡GANADOR " + "\"" + nombreJugador + "\"" + "!";
            rutaImagen = "imagenGanador.gif";
        } else {
            textoFinal = "¡¡¡PERDEDORES!!!";
            rutaImagen = "imagenPerdedor.gif";
        }

        StackPane panelFinalizarJuego = new VistaFinal(textoFinal, rutaImagen, this.ventana);

        Scene escenaFinJuego = new Scene(panelFinalizarJuego, 800, 600);
        this.ventana.setScene(escenaFinJuego);
    }
}
