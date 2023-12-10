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
        this.contenedorConsola = new ContenedorConsola(juego);

        ColumnConstraints columnaTablero = new ColumnConstraints();
        columnaTablero.setPercentWidth(80); // Primera columna ocupa el 80% de la ventana
        ColumnConstraints columnaConsola = new ColumnConstraints();
        super.getColumnConstraints().addAll(columnaTablero, columnaConsola);

        super.add(contenedorTablero, 0, 0);
        super.add(contenedorConsola, 1, 0);
    }

    public void actualizar(String nombreJugador, Celda celda, int avances) {
        this.contenedorTablero.actualizar(nombreJugador, celda, avances);
    }

    public void actualizar(String nombreJugadorActual, int ronda) {
        this.contenedorConsola.actualizar(nombreJugadorActual, ronda);
    }

    public void actualizar(String seniorityID) {
        this.contenedorConsola.actualizar(seniorityID);
    }

    public void actualizar(int energia, String ID) {
        this.contenedorConsola.actualizar(energia, ID);
    }

    public void actualizar(int ultimoNumeroTirado) {
        this.contenedorConsola.actualizar(ultimoNumeroTirado);
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
