package edu.fiuba.algo3.modelo.afectantes;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;


public class Bacanal implements Afectante {
    private int cantidadCopas;  // aca se guarda el numero del dado que tira el jugador.
    private static final int ENERGIA_POR_COPA = 4;

    // Deberiamos tener un constructor de bacanal? En principio parece que si pq
    // tiene que haber una instancia concreta en una casilla.

    public void afectar(Gladiador gladiador){
        Dado dado = new Dado(6);
        this.cantidadCopas = dado.tirar();    // Se puede vincular la accion de un boton al metodo tirar() de Dado?
        // En vez de necesitar una instancia de Jugador para poder tirar el dado.
        // Si decidimos dejar estas dos lineas de codigo de Dado, deberian ir en calcularEnergia.
        gladiador.recibirImpacto(this);
    }
    public int calcularEnergia(int energiaActual) {
        return (energiaActual - (ENERGIA_POR_COPA * this.cantidadCopas));
    }

}
