package edu.fiuba.algo3.modelo;

public class Jugador {
    private static final int CANTIDAD_MAXIMA_DE_RONDAS = 30;
    private Gladiador gladiador;
    private int turno;
    private Celda celdaActual;

    public Jugador(Gladiador gladiador, Celda celdaInicial) {
        this.gladiador = gladiador;
        this.turno = 0;
        this.celdaActual = celdaInicial;
    }

    // -------------------------------- PUBLICOS -------------------------------- //
    public void jugarTurno(Dado dado) {

        this.turno++;
        
        if (!this.gladiador.estaLesionado() && this.gladiador.tieneEnergia()) {
            int cantidadAAvanzar = dado.tirar();
            this.avanzar(cantidadAAvanzar);
            this.celdaActual = this.celdaActual.afectar(this.gladiador);

        } else {
            this.gladiador.sanar();
        }
        /*
         * Suponemos que: el seniority se mejora independientemente de si el jugador tiro o no los dados. Dado que esta
         * ligado a la cantidad de turnos.
         * */
        this.gladiador.mejorarSeniority(this.turno);
        this.gladiador.aumentarEnergia();
    }


    public boolean tieneTurnosIgualA(int cantidad) {
        return (this.turno == cantidad);
    }

    public boolean energiaIgualA(int energia) {
        return this.gladiador.energiaIgualA(energia);
    }

    public boolean estaEnCelda(int x, int y) {
        return (this.celdaActual.tieneCoordenadas(x, y));
    }

    public void totalmenteEquipado() {
        if (!this.gladiador.totalmenteEquipado()) {
            this.celdaActual = this.celdaActual.celdaSiguiente();
        }
    }

    // -------------------------------- PRIVADOS -------------------------------- //
    private void avanzar(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.celdaActual = this.celdaActual.celdaSiguiente();
        }
    }
}


// NOTA APARTE:
// No implementamos Personaje.
// Si creamos esta abstraccion e implementamos el metodo recibirImpacto como esta planteado arriba
// podriamos extender nuestro codigo a que tenga distintos tipos de personajes que reaccionen de distinta manera
// a los afectantes.
// Esto se veria como:
// public void recibirImpacto(Afectante afectante) {
//      this.personaje.recibirImpacto(afectante);
//}
// Entonces cada tipo de personaje tendria su propio metodo ante cada tipo de Afectante.
