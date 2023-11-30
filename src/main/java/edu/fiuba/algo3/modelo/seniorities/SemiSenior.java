package edu.fiuba.algo3.modelo.seniorities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SemiSenior implements Seniority {
    private static final int AUMENTO_ENERGIA = 5;
    private static final int TURNOS_ASCENSO = 8;
    /*private static final Logger logger = LogManager.getLogger();*/

    public Seniority ascender(int turno) {
        if (turno == TURNOS_ASCENSO) {
            /*logger.info("Ascendiendo a Senior después de " + TURNOS_ASCENSO + " turnos.");*/
            return new Senior();
        }
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
