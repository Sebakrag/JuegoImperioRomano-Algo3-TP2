package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.escenas.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorInicioPartida implements EventHandler<ActionEvent> {

    private Stage ventana;

    public ControladorInicioPartida(Stage ventana) {
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent evento) {
        // TODO: Si no llegamos a poner un boceto escribimos: "Tablero en construccion ;)" CON BOB EL CONSTRUCTOR
        VistaTablero tablero = new VistaTablero();

        Scene escenaTablero = new Scene(tablero);

        this.ventana.setScene(escenaTablero);
    }
}
