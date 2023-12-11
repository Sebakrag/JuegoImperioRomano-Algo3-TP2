package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.Logger;

public class CeldaFinal extends Celda {
    private final String nombreImagen = "imagenCeldaFinal.png";
    public CeldaFinal(int x, int y, Logger logger) {
        coordenadasValidas(x, y);
        this.x = x;
        this.y = y;
        this.logger = logger;
        this.nombreImagenePremio = "";
        this.nombreImageneObstaculo = "";
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
        return this.nombreImagenePremio;
    }

    public String nombreImagenObstaculo(){
        return this.nombreImageneObstaculo;
    }
}
