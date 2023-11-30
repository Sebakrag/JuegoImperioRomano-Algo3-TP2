package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Comida implements Afectante {
    private static final int AUMENTO_ENERGIA = 15;


    public void afectar(Gladiador gladiador) {
        gladiador.recibirImpacto(this);
    }

    public int calcularEnergia(int energiaActual){
        return energiaActual + AUMENTO_ENERGIA;
    }
}
