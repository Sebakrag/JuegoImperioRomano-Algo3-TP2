package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.Logger;

public class CeldaFinal extends Celda {

    public CeldaFinal(int x, int y, Logger logger, String nombrePremio, String nombreObstaculo,  String nombreImagen) {
        coordenadasValidas(x, y);
        this.x = x;
        this.y = y;
        this.logger = logger;
        this.nombreImagenPremio = nombrePremio;
        this.nombreImagenObstaculo = nombreObstaculo;
        this.nombreImagen = nombreImagen;
    }

    @Override
    public Celda celdaSiguiente(){
        return this;
    }

    public Celda afectar(Gladiador gladiador) {
        if (gladiador.totalmenteEquipado()){
            this.logger.info("Ganaste!!!");
            return this;
        }
        return siguiente;
    }

    public String nombreImagenFondo() { return this.nombreImagen; }

    public String nombreImagenPremio() {
        return this.nombreImagenPremio;
    }

    public String nombreImagenObstaculo(){
        return this.nombreImagenObstaculo;
    }
}
