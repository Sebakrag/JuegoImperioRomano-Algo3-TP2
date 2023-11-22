package edu.fiuba.algo3.modelo;
import javafx.scene.SceneAntialiasing;

import java.util.Random;

public class Jugador {
    private Gladiador gladiador;
    private int turnos;
    private Celda celdaActual;

    public Jugador(Gladiador gladiador, Celda celdaInicial) {
        this.gladiador = gladiador;
        this.turnos = 0;
        this.celdaActual = celdaInicial;
    }

    // -------------------------------- PUBLICOS -------------------------------- //
    public void jugarTurno() {
        int cantidadAAvanzar = this.tirarDado();
        this.avanzar(cantidadAAvanzar);
        this.celdaActual.afectar(this);
        this.turnos++;
        this.gladiador.mejorarSeniority(this.turnos);
        this.aumentarEnergiaConSeniority();
    }

    public void aumentarEnergiaConSeniority() {
        this.gladiador.aumentarEnergiaConSeniority();
    }

    public boolean tieneTurnosIgualA(int cantidad) {
        return (this.turnos == cantidad);
    }

    public boolean energiaIgualA(int energia) {
        return this.gladiador.energiaIgualA(energia);
    }

    public boolean estaEnCelda(int x, int y) {
        return (this.celdaActual.tieneCoordenadas(x, y));
    }

    public void recibirEnergia(int aumentoEnergia) {
        this.gladiador.recibirEnergia(aumentoEnergia);
    }

    public void mejorarEquipamiento() {
        this.gladiador.mejorarEquipamiento();
    }

    public void recibirAtaque() {
        this.gladiador.recibirAtaque();
    }

    public void recibirDanio(int danio) {
        this.gladiador.recibirDanio(danio);
    }

    public boolean totalmenteEquipado(){
        return this.gladiador.totalmenteEquipado();
    }

    public void posicionar(Celda celda){
        this.celdaActual = celda;
    }

    // -------------------------------- PRIVADOS -------------------------------- //
    private void avanzar(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            if (!(this.celdaActual.esCeldaFinal())) {
                this.celdaActual = this.celdaActual.celdaSiguiente();
            }
        }
    }

    private int tirarDado() {
        final int CARAS_DADO = 6;

        if (this.gladiador.tieneEnergia()) {
            Random random = new Random();
            return random.nextInt(CARAS_DADO) + 1;
        }
        return 0;
    }
}


// Los metodos recibirAtaque y recibirDanio deberian ser el mismo. Quizas podemos usar Double Dispatch.
// De hecho, quizas podemos hacer Double Dispatch con un metodo que se llame recibirEfecto. De esta manera
// lograriamos que Jugador solo tenga un metodo que se llame recibirImpacto(Afectante afectante) que sea:
//
// public void recibirImpacto(Afectante afectante) {
//      this.gladiador.recibirImpacto(afectante);
//}
// Con este metodo reemplazariamos los metodos de:
//                      mejorarEquipamiento()
//                      recibirAtaque()
//                      recibirDanio()
//                      recibirEnergia()

// Entonces Gladiador tendria:
// public void recibirImpacto(Fiera fiera) {      // Este metodo reemplaza el metodo 'recibirAtaque()' de Gladiador
//      this.disminuirEnergia(this.equipamiento.recibirAtaque());
// }
//
// public void recibirImpacto(Bacanal bacanal) {      // Este metodo reemplaza el metodo 'recibirDanio()' de Gladiador
//      this.disminuirEnergia(bacanal.calcularEnergia);
// }
//
// public void recibirImpacto(Lesion lesion) {
//      // PROBLEMA con la propuesta de cambio:
//      // Aqui el Jugador en el siguiente turno no avanza.
//      // Esta logica quizas es conveniente que este en Jugador por el hecho de que un
//      // jugador tiene la cantidad de turnos.
// }
//
// public void recibirImpacto(Comida comida) {      // Este metodo reemplaza el metodo 'recibirEnergia()' de Gladiador
//       this.aumentarEnergia(comida.calcularEnergia);
// }
//
// public void recibirImpacto(MejorarEquipamiento mejorador) {  // Este metodo reemplaza el metodo 'mejorarEquipamiento()' de Gladiador
//       this.equipamiento = this.equipamiento.mejorarEquipamiento;
// }
//

// En BACANAL tendriamos que introducir el metodo:
// public int calcularEnergia() {
//     //Aca el jugador tendria que tirar los dados. Pensar si hay una solucion posible.
//     int cantidadCopas = random.nextInt(CANTIDAD_COPAS_TOTAL) + 1;
//     return (ENERGIA_POR_COPA * cantidadCopas);
// }
//

// En COMIDA tendriamos que introducir el metodo:
// public int calcularEnergia() {
//      return this.aumentoEnergia;
// }
//


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
