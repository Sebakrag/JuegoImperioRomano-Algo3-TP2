package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;

public class Cansado implements Estado {

    private static final int ENERGIA_CANSADO = 0;
    private int energiaActual;

    private final String id = "Cansado";

    public Cansado(){
        this.energiaActual = ENERGIA_CANSADO;
    }

    public Estado avanzar(Celda futuraCelda, Gladiador gladiador, Logger logger){
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

    public int getEnergia() {
        return this.energiaActual;
    }

    public String getID(){return  this.id;}
}
