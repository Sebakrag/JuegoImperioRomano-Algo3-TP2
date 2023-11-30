package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Potenciador implements Afectante {

    /*private static final Logger logger = LogManager.getLogger();*/

    public void afectar(Gladiador gladiador) {
        gladiador.recibirImpacto(this);
    }

    public Equipamiento equipamientoSiguiente(Desequipado desequipado) {
       /* logger.info("Mejorando equipamiento a Casco.");*/
        return new Casco();
    }

    public Equipamiento equipamientoSiguiente(Casco casco) {
        /*logger.info("Mejorando equipamiento a Armadura.");*/
        return new Armadura();
    }

    public Equipamiento equipamientoSiguiente(Armadura armadura) {
        /*logger.info("Mejorando equipamiento a Escudo y Espada.");*/
        return new EscudoYEspada();
    }

    public Equipamiento equipamientoSiguiente(EscudoYEspada escudoYEspada) {
        /*logger.info("Mejorando equipamiento a Llave.");*/
        return new Llave();
    }

    public Equipamiento equipamientoSiguiente(Llave llave) {
        /*logger.info("Equipamiento actual: Llave. No hay mejora.");*/
        return llave;
    }
}
