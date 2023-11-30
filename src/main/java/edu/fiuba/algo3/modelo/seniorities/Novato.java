package edu.fiuba.algo3.modelo.seniorities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Novato implements Seniority {
    private  static final int AUMENTO_ENERGIA = 0;
    /*private static final Logger logger = LogManager.getLogger();*/

    public Seniority ascender(int turno) {
        int turnosAscenso = 8;

        if (turno == turnosAscenso) {
            /*logger.info("Ascendiendo a SemiSenior después de " + turnosAscenso + " turnos.");*/
            return new SemiSenior();
        }
        return this;
    }

    public int aumentarEnergia(){
        return AUMENTO_ENERGIA;
    }
}
