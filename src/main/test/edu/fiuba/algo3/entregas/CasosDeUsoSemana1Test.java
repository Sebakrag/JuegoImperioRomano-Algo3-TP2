package edu.fiuba.algo3.entregas;

import java.util.Arrays;
import java.util.List;
import edu.fiuba.algo3.modelo.seniorities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.modelo.celdas.*;

public class CasosDeUsoSemana1Test {
    @Test
    public void test01SeInicializaUnJugadorConLaEnergiaYElEquipamientoCorrecto() {

        int energiaInicial = 20;
        int energiaLuegoDeSerAtacado = 0;

        CeldaInicial celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Fiera fiera = new Fiera();

        boolean jugadorAlCrearseTieneEnergiaInicial = jugador.energiaIgualA(energiaInicial);

        fiera.afectar(gladiador);

        Assertions.assertTrue(jugadorAlCrearseTieneEnergiaInicial);
        Assertions.assertTrue(jugador.energiaIgualA(energiaLuegoDeSerAtacado));
    }

    @Test
    public void test02JugadorSaleCorrectamenteDeLaCasillaInicial(){
        int cantidadCeldas = 6;
        int coordenadaXInicial = 0;
        int coordenadaYInicial = 0;

        Dado dado = new Dado();
        CeldaInicial celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Tablero tablero = new Tablero(celdaInicial);
        tablero.armarMapa(cantidadCeldas);

        jugador.jugarTurno(dado);

        Assertions.assertFalse(jugador.estaEnCelda(coordenadaXInicial,coordenadaYInicial));
    }

    @Test
    public void test03UnJugadorSinEnergiaPierdeElTurno(){

        int cantidadTurnosEsperado = 1;
        int coordenadaXInicial = 0;
        int coordenadaYInicial = 0;

        Dado dado = new Dado();
        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante fiera = new Fiera();

        fiera.afectar(gladiador);
        // Verificar que no pueda tirar el dado (), y que turnos++.
        jugador.jugarTurno(dado);

        Assertions.assertTrue(jugador.estaEnCelda(coordenadaXInicial, coordenadaYInicial));
        Assertions.assertTrue(jugador.tieneTurnosIgualA(cantidadTurnosEsperado));
    }

    @Test
    public void test04AlRecibirComidaSuEnergiaIncrementaEnQuince() {

        int energiaInicial = 20;
        int energiaEsperada = energiaInicial + 15;  // La comida incrementa 15 de energia.

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante comida = new Comida();

        comida.afectar(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test05AlRecibirUnPremioPorPrimeraVezRecibeUnCasco() {

        int energiaInicial = 20;
        int danioCasco = 15;
        int energiaEsperada = energiaInicial - 15;

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);

        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera(); // Buscamos chequear comportamiento

        mejora.afectar(gladiador);  // El jugador obtiene un casco.
        fiera.afectar(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test06AlRecibirUnPremioPorTerceraVezObtieneEscudoYEspada() {

        int energiaInicial = 20;
        int danioEscudoYEspada = 2;
        int energiaEsperada = energiaInicial - danioEscudoYEspada;

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera();

        // El jugador obtiene un Escudo Y Espada.
        for (int i = 0; i < 3; i++) {
            mejora.afectar(gladiador);
        }

        fiera.afectar(gladiador); // Buscamos chequear comportamiento

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test07AlHaberUnCombateConFieraSiTieneCascoPierdeQuincePuntosDeEnergia() {

        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 15;

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera();

        mejora.afectar(gladiador);  // El jugador obtiene un casco.
        fiera.afectar(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test08AlPasarOchoTurnosElGladiadorPasaDeNovatoASemiSenior() {

        int energiaEsperada= 25;
        int cantidadCeldas = 20;

        CeldaInicial celdaInicial = new CeldaInicial();
        Tablero tablero = new Tablero(celdaInicial);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Dado dado = new Dado();


        tablero.armarMapa(cantidadCeldas);

        for(int i = 0; i < 8; i++){
            jugador.jugarTurno(dado);
        }
        // turnos = 8 --> jugador pasa a SemiSenior
        // Habria que probar aca o en las pruebas unitarias que el gladiador es novato?


        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

   @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {
        // Hay que hacer la logica de ganar.
        int coordenadaXMedio = 0;
        int coordenadaYMedio = 0;
        int cantidadCeldas = 2;

        CeldaInicial celdaInicial = new CeldaInicial();
        Tablero tablero = new Tablero(celdaInicial);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Dado dado = new Dado();

        tablero.armarMapa(cantidadCeldas);
        jugador.jugarTurno(dado);

        Assertions.assertTrue(jugador.estaEnCelda(coordenadaXMedio, coordenadaYMedio));
    }

    @Test
    public void test10AlSerAtacadoPorUnaFieraYConTodoElEquipamientoNoPierdeEnergia() {

        int energiaInicial = 20;
        int energiaEsperada = energiaInicial;

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera();

        // Obtiene la llave
        for (int i = 0; i < 4; i++) {
            mejora.afectar(gladiador);
        }

        fiera.afectar(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test11AlTenerLaLlaveYrecibirOtroPremioNoCambiaNada() {

        int energiaEsperada = 20; // igual a la energia inicial

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera();

        // El jugador obtiene la llave
        for (int i = 0; i < 4; i++) {
            mejora.afectar(gladiador);
        }

        mejora.afectar(gladiador); //No recibe nada

        fiera.afectar(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    /*
    @Test
    public void test12AlPasarTreintaTurnosYnadieLlegaAlaMetaSeTerminoElJuego() {

        int cantidadCeldas = 3;

        CeldaInicial celdaInicial = new CeldaInicial();
        Tablero tablero = new Tablero(celdaInicial);

        Gladiador gladiador1 = new Gladiador();
        Gladiador gladiador2 = new Gladiador();
        Jugador jugador1 = new Jugador(gladiador1, celdaInicial);
        Jugador jugador2 = new Jugador(gladiador2, celdaInicial);
        Dado dado = new Dado();

        tablero.armarMapa(cantidadCeldas);

        for (int i = 0; i < 30; i++) {
            jugador1.jugarTurno(dado);
            jugador2.jugarTurno(dado);
        }

        Juego juego = new Juego();
        for(int i = 0; i < 30; i++){
            juego.chequearRonda();
        }
        //Assertions.assertFalse(jugador1.jugarTurno(dado));
        Assertions.assertFalse(juego.chequearRonda());

    }
*/
}
