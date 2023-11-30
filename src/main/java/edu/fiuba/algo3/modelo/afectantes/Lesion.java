package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lesion implements Afectante {

    private static final Logger logger = LogManager.getLogger();

    public void afectar(Gladiador gladiador){
        gladiador.recibirImpacto(this);

        logger.info("El gladiador se enoja con la vida, patea una piedra y debe esperar un turno sin avanzar");
    }
}
