package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Tablero;
import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;

public class Cansado implements Estado {

    private static final int ENERGIA_CANSADO = 0;
    private int energiaActual;

    public Cansado(){
        this.energiaActual = ENERGIA_CANSADO;
    }

    public Estado avanzar(int avances, Tablero tablero, Gladiador gladiador, Logger logger){
        logger.warn("Estoy cansado Jefe :(");
        int energia = 5;
        return new Sano(energia);
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

    public boolean puedoMoverme(){
        return false;
    }
}
