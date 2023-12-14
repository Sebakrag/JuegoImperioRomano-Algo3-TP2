package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;

public class Sano implements Estado {

    private final String id = "Sano";
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;
    private int energiaActual;

    public Sano() {
        this.energiaActual = ENERGIA_INICIAL;
    }

    public Sano(int energia) {
        this.energiaActual = energia;
    }

    public Estado avanzar(Celda futuraCelda, Gladiador gladiador, Logger logger) {
        logger.info("Movimiento exitoso.");
        return gladiador.mover(futuraCelda);
    }

    public Estado reducirEnergia(int energia) {
        this.energiaActual -= energia;
        if (this.energiaActual <= SIN_ENERGIA) {

            return new Cansado();
        }

        return this;
    }

    public Estado aumentarEnergia(int energia) {
        this.energiaActual += energia;
        return this;
    }

    public int getEnergia() {
        return this.energiaActual;
    }

    public String getID() {
        return this.id;
    }
}
