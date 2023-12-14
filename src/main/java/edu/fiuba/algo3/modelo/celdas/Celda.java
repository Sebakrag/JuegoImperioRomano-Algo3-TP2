package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;
import org.apache.logging.log4j.Logger;

public abstract class Celda {
    protected String nombreImagen;
    protected Celda siguiente;
    protected int x;
    protected int y;
    protected Logger logger;
    protected String nombreImagenPremio;
    protected String nombreImagenObstaculo;

    protected void coordenadasValidas(int x, int y) {
        if (x < 0 || y < 0) {
            throw new CoordenadaInvalidaError();
        }
    }

    public abstract Celda afectar(Gladiador gladiador);

    public abstract Celda celdaSiguiente();

    public void setSiguiente(Celda siguiente) { this.siguiente = siguiente;};

    public abstract String nombreImagenFondo();

    public String nombreImagenPremio() {
        return "";
    }

    public String nombreImagenObstaculo(){
        return "";
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
