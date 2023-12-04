package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
//import edu.fiuba.algo3.interfaz.vistas.escenas.EscenaIngreso;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIniciarPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.interfaz.vistas.cuadroTexto.CuadroTextoIngreso;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ControladorIngresoNombre implements EventHandler<ActionEvent> {

    private CuadroTextoIngreso cuadroTexto;
    private ArrayList<String> nombresJugadores;
    private Label etiquetaAviso;
    private int cantidadLimite;
    private BotonIngresarNombre botonIngreso;
    private BotonIniciarPartida botonIniciarPartida;
    
    public ControladorIngresoNombre(CuadroTextoIngreso cuadroTexto, Label etiquetaAviso, int cantidadLimite, BotonIngresarNombre botonIngreso, BotonIniciarPartida botonIniciarPartida) {
        this.cuadroTexto = cuadroTexto;
        this.nombresJugadores = new ArrayList<>();
        this.etiquetaAviso = etiquetaAviso;
        this.cantidadLimite = cantidadLimite;
        this.botonIngreso = botonIngreso;
        this.botonIniciarPartida = botonIniciarPartida;
    }

    @Override
    public void handle(ActionEvent evento) {
        if (!this.cuadroTexto.ingresoValido()) {
            this.etiquetaAviso.setText("Ingreso inválido. El nombre no puede ser vacío.");
        } else if ((this.cantidadLimite - 1) == this.nombresJugadores.size()) {
            this.etiquetaAviso.setText("Se ha ingresado la cantidad máxima de jugadores. Es hora de jugar!");
            this.cuadroTexto.setDisable(true);
            this.botonIngreso.setDisable(true);
            this.botonIniciarPartida.setDisable(false);
        } else {
            this.nombresJugadores.add(String.valueOf(this.cuadroTexto.getText().trim().equals("")));
            this.etiquetaAviso.setText("\"" + this.cuadroTexto.getText() + "\"" + "ingresado con éxito!");
        }

        this.cuadroTexto.clear();
        this.cuadroTexto.requestFocus();
    }

    public ArrayList<String> getNombresJugadores() {
        return this.nombresJugadores;
    }

}
