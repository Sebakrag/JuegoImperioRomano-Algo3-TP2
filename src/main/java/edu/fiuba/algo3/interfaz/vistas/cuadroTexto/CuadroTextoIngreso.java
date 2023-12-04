package edu.fiuba.algo3.interfaz.vistas.cuadroTexto;

import javafx.scene.control.TextField;

public class CuadroTextoIngreso extends TextField {

    public CuadroTextoIngreso() {

    }

    public boolean ingresoValido() {
        //Borra los espacios
        String textoIngresado = String.valueOf(this.getText().trim());

        return (!textoIngresado.isBlank());

        /*
        if (textoIngresado.matches("[a-zA-Z0-9]*")) {

        }
        */
    }


}
