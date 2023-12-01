package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Tablero;
import org.apache.logging.log4j.Logger;

public class Cansado implements Estado {

    private static final int ENERGIA_CANSADO = 0;
    private int energiaActual;

    public Cansado(){
        this.energiaActual = ENERGIA_CANSADO;
    }

    public Estado avanzar(int avances, Tablero tablero, Gladiador gladiador, Logger logger) {
        logger.warn("Estoy cansado no puedo :(");
        int energia = 5;
        return new Sano(energia);
    }

    //TODO: idem Lesionado con cansar.
    public Estado lesionar() {
        return this;
    }
    public Estado reducirEnergia(int energia) {
        return this;
    }

    public Estado aumentarEnergia(int energia) {
        return this;
    }

    @Override
    public int obtenerEnergia() {
        return this.energiaActual;
    }


}
