package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Tablero;
import org.apache.logging.log4j.Logger;

public interface Estado {

    Estado avanzar(int avances, Tablero tablero, Gladiador gladiador, Logger logger);
    Estado reducirEnergia(int energia);
    Estado aumentarEnergia(int energia);

    int obtenerEnergia();
}
