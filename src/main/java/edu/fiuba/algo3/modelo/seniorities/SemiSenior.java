package edu.fiuba.algo3.modelo.seniorities;

import edu.fiuba.algo3.modelo.estados.Estado;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SemiSenior implements Seniority {
    private static final int AUMENTO_ENERGIA = 5;
    private static final int TURNOS_ASCENSO = 12;
    private final Logger logger;

    public SemiSenior(Logger logger) {
        this.logger = logger;
    }

    /*private static final Logger logger = LogManager.getLogger();*/

    public Seniority ascender(int turno) {
        if (turno == TURNOS_ASCENSO) {
            logger.info("Ascendiendo a Senior después de " + TURNOS_ASCENSO + " turnos.");
            return new Senior();
        }
        return this;
    }

    public Estado aumentarEnergia(Estado estado){
        estado.aumentarEnergia(AUMENTO_ENERGIA);
        return estado;
    }
}
