package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;

public interface Estado {

    public Estado avanzar(Celda futuraCelda, Gladiador gladiador, Logger logger);
    public Estado reducirEnergia(int energia);
    public Estado aumentarEnergia(int energia);
    public String getID();
    public int getEnergia();
}
