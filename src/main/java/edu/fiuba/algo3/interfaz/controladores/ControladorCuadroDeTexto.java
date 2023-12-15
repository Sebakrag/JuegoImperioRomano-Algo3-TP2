package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class ControladorCuadroDeTexto implements EventHandler<KeyEvent> {

    private final BotonIngresarNombre botonIngresarNombre;

    public ControladorCuadroDeTexto(BotonIngresarNombre botonIngresarNombre) {
        this.botonIngresarNombre = botonIngresarNombre;
    }

    @Override
    public void handle(KeyEvent evento) {
        if (evento.getCode() == KeyCode.ENTER)
            Event.fireEvent(this.botonIngresarNombre, new ActionEvent());
    }
}
