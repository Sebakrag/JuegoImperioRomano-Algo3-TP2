package edu.fiuba.algo3.interfaz.vistas.cuadroTexto;

import edu.fiuba.algo3.interfaz.controladores.ControladorCuadroDeTexto;
import edu.fiuba.algo3.interfaz.vistas.botones.BotonIngresarNombre;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CuadroTextoIngreso extends TextField {

    private final ArrayList<String> nombresIngresados;

    public CuadroTextoIngreso(ArrayList<String> nombresIngresados) {
        this.nombresIngresados = nombresIngresados;
    }

    public boolean ingresoValido() {
        //Borra los espacios
        String textoIngresado = String.valueOf(this.getText().trim());
        textoIngresado = toCapitalize(textoIngresado);

        if (textoIngresado.isBlank())
            return false;

        int i = 0;
        boolean nombreYaIngresado = false;
        while (!nombreYaIngresado && (i != nombresIngresados.size())) {
            if (nombresIngresados.get(i).equals(textoIngresado))
                nombreYaIngresado = true;
            i++;
        }

        return (!nombreYaIngresado);
    }

    public String toCapitalize(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return cadena;
        } else {
            int largoCadena = cadena.length();
            return (cadena.toUpperCase().charAt(0) + cadena.substring(1, largoCadena).toLowerCase());
        }
    }

    public void asociarTeclaEnterConBotonIngresarNombre(BotonIngresarNombre botonIngresarNombre) {
        this.setOnKeyPressed(new ControladorCuadroDeTexto(botonIngresarNombre));
    }
}
