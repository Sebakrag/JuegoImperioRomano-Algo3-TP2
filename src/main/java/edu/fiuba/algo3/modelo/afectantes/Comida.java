package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Comida implements Afectante {
    private static final int AUMENTO_ENERGIA = 15;

    private static final Logger logger = LogManager.getLogger();

    public void afectar(Gladiador gladiador) {
        gladiador.recibirImpacto(this);
        logger.info("Gladiador afectado. Se ha encontrado una comida, se incrementan 15 puntos.");
    }

    public int calcularEnergia(int energiaActual){
        return energiaActual + AUMENTO_ENERGIA;
    }
}
