package edu.fiuba.algo3.modelo.seniorities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.modelo.estados.Estado;


public class Novato implements Seniority {
    private  static final int AUMENTO_ENERGIA = 0;
    /*private static final Logger logger = LogManager.getLogger();*/

    private final Logger logger;

    public Novato(Logger logger) {
        this.logger = logger;
    }
    public Seniority ascender(int turno) {
        int turnosAscenso = 8;

        if (turno == turnosAscenso) {
            logger.info("Ascendiendo a SemiSenior después de " + turnosAscenso + " turnos.");
            return new SemiSenior(logger);
        }
        return this;
    }

    public Estado aumentarEnergia(Estado estado){
        estado.aumentarEnergia(AUMENTO_ENERGIA);
        return estado;
    }
}
