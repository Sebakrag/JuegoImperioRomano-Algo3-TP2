package edu.fiuba.algo3.modelo.afectantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.estados.Estado;

public class Bacanal implements Afectante {

    /*private static final Logger logger = LogManager.getLogger();*/
    private static final int ENERGIA_POR_COPA = 4;

    public void afectar(Gladiador gladiador){
        gladiador.recibirImpacto(this);
    }

    public Estado modificarEnergia(Estado estado) {
        Dado dado = new Dado(6);
        int cantidadCopas = dado.tirar(); // Se puede vincular la accion de un boton al metodo tirar() de Dado?
        return (estado.reducirEnergia(ENERGIA_POR_COPA * cantidadCopas));
    }
}
