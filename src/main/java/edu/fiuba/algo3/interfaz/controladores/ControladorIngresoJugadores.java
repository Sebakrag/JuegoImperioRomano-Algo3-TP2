package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonCantidadJugador;
import edu.fiuba.algo3.interfaz.vistas.escenas.VistaIngresoJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ControladorIngresoJugadores implements EventHandler<ActionEvent> {
    
    private final Stage ventana;
    private final BotonCantidadJugador boton;

    public ControladorIngresoJugadores(Stage ventana, BotonCantidadJugador boton) {
        this.ventana = ventana;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent evento) {
        Scene escenaIngresoJugadores = new Scene(new VistaIngresoJugadores(this.boton, this.ventana), 500, 500);
        this.ventana.setScene(escenaIngresoJugadores);
        this.ventana.setFullScreen(true); // Configurar la ventana para que se abra en pantalla completa
        this.ventana.setOnCloseRequest(event -> System.exit(0)); // Establecer un evento para cerrar la aplicación al presionar Esc en pantalla completa

        escenaIngresoJugadores.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F11) {
                this.ventana.setFullScreen(!this.ventana.isFullScreen());
            }
        });
    }

}
