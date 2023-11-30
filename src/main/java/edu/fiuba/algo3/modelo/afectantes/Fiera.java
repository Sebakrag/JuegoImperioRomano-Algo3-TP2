package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fiera implements Afectante {

    public void afectar(Gladiador gladiador){
        gladiador.recibirImpacto(this);
    }
}


