package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorConsola;
import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorTablero;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class VistaJuego extends GridPane implements Observador {

    //TODO: VER SI HACEMOS ESTO -> private final ContenedorConsola contenedorConsola;

    private final Juego juego;  // TODO: Vale la pena guardar una referencia a juego?
    private final ContenedorConsola contenedorConsola;
    private final ContenedorTablero contenedorTablero;

    public VistaJuego(Juego juego, Tablero tablero, ArrayList<String> nombreJugadores) {
        this.juego = juego;
        juego.agregarObservador(this);

        this.contenedorTablero = new ContenedorTablero(tablero, nombreJugadores);
        this.contenedorConsola = new ContenedorConsola(juego);

        //ArrayList<Jugador> jugadores = juego.getJugadores();
        //for (Jugador jugador : jugador) {
        //    jugador.agregarObservador(this.tablero);
        //}
        //juego.agregarObservadorAJugadores(this.contenedorTablero);

        ColumnConstraints columnaTablero = new ColumnConstraints();
        columnaTablero.setPercentWidth(80); // Primera columna ocupa el 80% de la ventana
        ColumnConstraints columnaConsola = new ColumnConstraints();
        super.getColumnConstraints().addAll(columnaTablero, columnaConsola);

        super.add(contenedorTablero, 0, 0);
        super.add(contenedorConsola, 1, 0);
    }

    public void actualizar(){}
    /*
    public void actualizar(Celda celdaNueva, String nombre) {
        // consultar el estado de juego y modificar la vista.
        contenedorTablero.actualizar(celdaNueva, nombre);
    }
 */
}
