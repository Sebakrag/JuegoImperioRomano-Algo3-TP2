package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
/* org.apache.logging.log4j.Logger;*/

public class Lesion implements Afectante {

    public void afectar(Gladiador gladiador){
        gladiador.recibirImpacto(this);
    }
}
