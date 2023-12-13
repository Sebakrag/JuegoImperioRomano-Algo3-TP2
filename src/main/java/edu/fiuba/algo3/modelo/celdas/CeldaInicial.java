package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.Logger;

public class CeldaInicial extends Celda {
    
    public CeldaInicial(int x, int y, Logger logger, String nombrePremio, String nombreObstaculo, String nombreImagen) {
        this.coordenadasValidas(x,y);
        this.x = x;
        this.y = y;
        this.logger = logger;
        this.nombreImagenPremio = nombrePremio;
        this.nombreImagenObstaculo = nombreObstaculo;
        this.nombreImagen = nombreImagen;
    }

    public Celda afectar(Gladiador gladiador){
        return this;
    }

    @Override
    public Celda celdaSiguiente(){
        return this.siguiente;
    }

    public String nombreImagenFondo() { return this.nombreImagen; }

    public String nombreImagenPremio() {
        return this.nombreImagenPremio;
    }

    public String nombreImagenObstaculo(){
        return this.nombreImagenObstaculo;
    }
}
