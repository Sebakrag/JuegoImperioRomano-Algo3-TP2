package edu.fiuba.algo3.modelo.seniorities;

import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.modelo.estados.Estado;


public class Novato implements Seniority {
    private  static final int AUMENTO_ENERGIA = 0;
    private static final int TURNOS_ASCENSO = 8;

    private final String id = "Novato";
    private final Logger logger;

    public Novato(Logger logger) {
        this.logger = logger;
    }

    public Seniority ascender(int turno) {

        if (turno == TURNOS_ASCENSO) {
            logger.info("Ascendiendo a SemiSenior después de " + TURNOS_ASCENSO + " turnos.");
            return new SemiSenior(logger);
        }
        return this;
    }

    public Estado aumentarEnergia(Estado estado){
        estado.aumentarEnergia(AUMENTO_ENERGIA);
        return estado;
    }

    public String getID(){
        return this.id;
    }
}
