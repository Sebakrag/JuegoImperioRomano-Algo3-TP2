package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;

public class Vacio implements Afectante {

    public Vacio() { }

    public void afectar(Gladiador gladiador) {
        gladiador.recibirImpacto(this);
    }
}
