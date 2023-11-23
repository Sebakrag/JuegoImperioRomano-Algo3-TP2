package edu.fiuba.algo3.modelo;

public class Jugador {
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
        int cantidadAAvanzar = this.tirarDado(dado);

        if (this.avanzar(cantidadAAvanzar))
            this.celdaActual.afectar(this.gladiador);
            //if (this.celdaActual.esCeldaFinal()) // sabemos que hay que fletarlo
            //    this.celdaActual = this.celdaActual.celdaSiguiente();

        // jugador.ganarJuego();     A analizar...
        // this.juego.gano(jugador);     A analizar...

        this.gladiador.mejorarSeniority(this.turno);
        this.gladiador.aumentarEnergia();
    }

    public int tirarDado(Dado dado) {
        this.turno++;
        if (this.gladiador.tieneEnergia()) {
            return dado.tirar();
        }
        return 0;
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
    private boolean avanzar(int cantidad) {

        boolean avanza = false;
        for (int i = 0; i < cantidad; i++) {
            if (!(this.celdaActual.esCeldaFinal())) {
                this.celdaActual = this.celdaActual.celdaSiguiente(); //this.posicionar(this.celdaActual.celdaSiguiente()); ?
            } else {
                this.totalmenteEquipado();
                return true;//NO nos gusta ! ver de cambiar-> es un espanto
            }
            avanza = true;

        }
        return avanza;
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
