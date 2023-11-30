package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fiera implements Afectante {

    private static final Logger logger = LogManager.getLogger();
    public void afectar(Gladiador gladiador){
        gladiador.recibirImpacto(this);
        logger.info("es atacado por un animal en casilla (X,Y) y pierde energía 10");
    }
}


