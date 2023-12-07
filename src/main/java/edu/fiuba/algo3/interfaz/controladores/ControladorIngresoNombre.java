package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIniciarPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.interfaz.vistas.cuadroTexto.CuadroTextoIngreso;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class ControladorIngresoNombre implements EventHandler<ActionEvent> {

    private CuadroTextoIngreso cuadroTexto;
    private ArrayList<String> nombresJugadores;
    private Label etiquetaAviso;
    private int cantidadLimite;
    private BotonIngresarNombre botonIngreso;
    private BotonIniciarPartida botonIniciarPartida;
    private Label etiquetaIngreso;
    private int cantidadIngresada;
    
    public ControladorIngresoNombre(CuadroTextoIngreso cuadroTexto, Label etiquetaAviso, int cantidadLimite, BotonIngresarNombre botonIngreso, BotonIniciarPartida botonIniciarPartida,  ArrayList<String> nombresJugadores, Label etiquetaIngreso) {
        this.cuadroTexto = cuadroTexto;
        this.nombresJugadores = nombresJugadores;
        this.etiquetaAviso = etiquetaAviso;
        this.cantidadLimite = cantidadLimite;
        this.botonIngreso = botonIngreso;
        this.botonIniciarPartida = botonIniciarPartida;
        this.etiquetaIngreso = etiquetaIngreso;
        this.cantidadIngresada = 1;
    }

    @Override
    public void handle(ActionEvent evento) {
        if (!this.cuadroTexto.ingresoValido()) {
            this.etiquetaAviso.setText("Ingreso inválido. El nombre no puede ser vacío.");
        } else if ((this.cantidadLimite - 1) == this.nombresJugadores.size()) {
            etiquetaIngreso.setText("¡Cantidad máxima ingresada!");
            this.nombresJugadores.add(String.valueOf(this.cuadroTexto.getText().trim()));
            this.etiquetaAviso.setText("\"" + this.cuadroTexto.getText() + "\"" + " Ingresado con éxito. \n\t ¡Es hora de jugar!");
            this.etiquetaAviso.setAlignment(Pos.CENTER);
            this.cuadroTexto.setDisable(true);
            this.botonIngreso.setDisable(true);
            this.botonIniciarPartida.setDisable(false);
        } else {
            this.cantidadIngresada++;
            etiquetaIngreso.setText("Ingrese nombre del jugador " + this.cantidadIngresada);
            this.nombresJugadores.add(String.valueOf(this.cuadroTexto.getText().trim()));
            this.etiquetaAviso.setText("\"" + this.cuadroTexto.getText() + "\"" + " ingresado con éxito.");
        }

        this.cuadroTexto.clear();
        this.cuadroTexto.requestFocus();
    }
}
