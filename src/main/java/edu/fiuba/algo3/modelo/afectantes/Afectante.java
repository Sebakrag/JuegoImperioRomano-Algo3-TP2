package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.Logger;

public interface Afectante {
    void afectar(Gladiador gladiador);

    String identificador();

}
