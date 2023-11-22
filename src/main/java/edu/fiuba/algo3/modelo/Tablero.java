package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.afectantes.Vacio;
import edu.fiuba.algo3.modelo.celdas.CeldaComun;
import edu.fiuba.algo3.modelo.celdas.CeldaFinal;
import edu.fiuba.algo3.modelo.celdas.CeldaInicial;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private Celda celdaInicial;
    private int tamanio; //
    //private ArrayList<Afectante> afectantes;

    public Tablero(int cantidadCeldas, CeldaInicial celdaInicial) {
        this.tamanio = cantidadCeldas;
        this.celdaInicial = celdaInicial;
        //this.afectantes = new ArrayList<>();
    }

    public void armarMapa(){
        Afectante afectante = new Vacio();  // Esto deberia ser un RANDOM siguiendo el mapa del JSON.
        Celda actual = this.celdaInicial;
        int i = 1;
        for (; i < (this.tamanio - 1); i++) {
            Celda celdaComun = new CeldaComun(i, i, afectante);
            actual.setSiguiente(celdaComun);
            actual = celdaComun;
        }
        Celda celdaMedio = this.buscarCeldaDelMedio();
        Celda celdaFinal = new CeldaFinal(celdaMedio, i, i);
        actual.setSiguiente(celdaFinal);
    }

    private Celda buscarCeldaDelMedio() {
        Celda celdaMedio = this.celdaInicial;
        for (int i = 1; i < (tamanio / 2) ; i++) {
            celdaMedio = celdaMedio.celdaSiguiente();
        }
        return celdaMedio;
    }
}
