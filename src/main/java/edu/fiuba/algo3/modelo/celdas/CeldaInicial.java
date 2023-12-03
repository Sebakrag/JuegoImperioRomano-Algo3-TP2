package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.Logger;

public class CeldaInicial extends Celda {

    private final String nombreImagen = "imagenCeldaInicial.png";
    
    public CeldaInicial(int x, int y, Logger logger) {
        this.coordenadasValidas(x,y);
        this.x = x;
        this.y = y;
        this.logger = logger;
    }

    public Celda afectar(Gladiador gladiador){
        return this;
    }

    @Override
    public Celda celdaSiguiente(){
        return this.siguiente;
    }

    public String nombreImagenFondo() { return this.nombreImagen; }

}
