package edu.fiuba.algo3.interfaz.controladores;

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
    
    public ControladorIngresoNombre(CuadroTextoIngreso cuadroTexto, Label etiquetaAviso, int cantidadLimite) {
        this.cuadroTexto = cuadroTexto;
        this.nombresJugadores = new ArrayList<>();
        this.etiquetaAviso = etiquetaAviso;
        this.cantidadLimite = cantidadLimite;
    }

    @Override
    public void handle(ActionEvent evento) {
        if (!this.cuadroTexto.ingresoValido()) {
            this.etiquetaAviso.setText("Ingreso inválido. El nombre no puede ser vacío.");
        } else if ((this.cantidadLimite - 1) == this.nombresJugadores.size()) {
            this.etiquetaAviso.setText("Se ha ingresado la cantidad máxima de jugadores. Es hora de jugar!");
            this.cuadroTexto.setDisable(true);
            //TODO: Sacar el boton "ingresar".
            //TODO: agregar boto inicio partida. -> Mostramos otra escena o modificamos la escena actual de alguna manera?
        } else {
            this.nombresJugadores.add(String.valueOf(this.cuadroTexto.getText().trim().equals("")));
            this.etiquetaAviso.setText("");
        }

        this.cuadroTexto.clear();
        this.cuadroTexto.requestFocus();
    }

    public ArrayList<String> getNombresJugadores() {
        return this.nombresJugadores;
    }

}
