package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Tablero;
import org.apache.logging.log4j.Logger;

public class Sano implements Estado {
    
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;

    private int energiaActual;

    public Sano() {
        this.energiaActual = ENERGIA_INICIAL;
    }

    public Sano(int energia) {
        this.energiaActual = energia;
    }

    public Estado avanzar (int avances, Tablero tablero, Gladiador gladiador, Logger logger) {
        logger.info("Movimiento exitoso.");
        gladiador.avanzar(avances,tablero);
        return this;
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

    @Override
    public int obtenerEnergia() {
        return this.energiaActual;
    }
}
