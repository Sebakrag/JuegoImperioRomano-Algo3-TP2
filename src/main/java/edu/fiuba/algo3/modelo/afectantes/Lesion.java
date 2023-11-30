package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
/* org.apache.logging.log4j.Logger;*/

public class Lesion implements Afectante {

    /*private final Logger logger;*/

    public Lesion(/*Logger logger*/) {
        /*this.logger = logger;*/
    }

    public void afectar(Gladiador gladiador){
        gladiador.recibirImpacto(this);

        /*logger.info("El gladiador se enoja con la vida, patea una piedra y debe esperar un turno sin avanzar");*/
    }
}
