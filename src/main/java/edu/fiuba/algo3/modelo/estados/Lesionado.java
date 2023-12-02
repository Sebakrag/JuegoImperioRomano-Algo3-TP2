package edu.fiuba.algo3.modelo.estados;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;

public class Lesionado implements Estado {

    private int energiaActual;

    public Lesionado(int energia){
        this.energiaActual = energia;
    }

    public Estado reducirEnergia(int energia) {
        return this;
    }

    public Estado avanzar(Celda _futuraCelda, Gladiador _gladiador, Logger logger) {
        // No avanza
        logger.error("Lady Gago lesionado.");

        return new Sano(this.energiaActual);
    }

    public Estado aumentarEnergia(int energia){
        return this;
    }

    @Override
    public int obtenerEnergia() {
        return 0;
    }



}
