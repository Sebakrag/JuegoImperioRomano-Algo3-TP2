package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.*;

public class Potenciador implements Afectante {

    public void afectar(Gladiador gladiador) {
        gladiador.recibirImpacto(this);
    }

    public Equipamiento equipamientoSiguiente(Desequipado desequipado) {
        return new Casco();
    }

    public Equipamiento equipamientoSiguiente(Casco casco) {
        return new Armadura();
    }

    public Equipamiento equipamientoSiguiente(Armadura armadura) {
        return new EscudoYEspada();
    }

    public Equipamiento equipamientoSiguiente(EscudoYEspada escudoYEspada) {
        return new Llave();
    }

    public Equipamiento equipamientoSiguiente(Llave llave) {
        return llave;
    }
}
