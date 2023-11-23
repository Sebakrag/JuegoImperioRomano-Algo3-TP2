package edu.fiuba.algo3.entregas;

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
        Dado dado = new Dado();
        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante fiera = new Fiera();
        int cantidadTurnosEsperado = 1;
        int coordenadaXInicial = 0;
        int coordenadaYInicial = 0;

        fiera.afectar(gladiador);

        // Verificar que no pueda tirar el dado (), y que turnos++.
        jugador.jugarTurno(dado);

        Assertions.assertTrue(jugador.estaEnCelda(coordenadaXInicial, coordenadaYInicial));
        Assertions.assertTrue(jugador.tieneTurnosIgualA(cantidadTurnosEsperado));
    }
/*
    @Test
    public void test04AlRecibirComidaSuEnergiaIncrementaEnQuince() {

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante comida = new Comida();

        int energiaInicial = 20;
        int energiaEsperada = energiaInicial + 15;  // La comida incrementa 15 de energia.

        comida.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test05AlRecibirUnPremioPorPrimeraVezRecibeUnCasco() {
        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 15;

        mejorador.afectar(jugador);  // El jugador obtiene un casco.
        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test06AlRecibirUnPremioPorTerceraVezObtieneEscudoYEspada() {
        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 2;

        // El jugador obtiene un Escudo Y Espada.
        for (int i = 0; i < 3; i++) {
            mejorador.afectar(jugador);
        }

        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test07AlHaberUnCombateConFieraSiTieneCascoPierdeQuincePuntosDeEnergia() {
        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial - 15;

        mejorador.afectar(jugador);  // El jugador obtiene un casco.
        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test08AlPasarOchoTurnosElGladiadorPasaDeNovatoASemiSenior() {
        CeldaInicial celdaInicial = new CeldaInicial();
        int cantidadCeldas = 20;
        Tablero tablero = new Tablero(celdaInicial);
        tablero.armarMapa(cantidadCeldas);

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        int energiaEsperada= 25;

        for(int i = 0; i < 8; i++){
            jugador.jugarTurno();
        }
        // turnos = 8 --> jugador pasa a SemiSenior
        // Habria que probar aca o en las pruebas unitarias que el gladiador es novato?

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {
        // Hay que hacer la logica de ganar.
        CeldaInicial celdaInicial = new CeldaInicial();
        int cantidadCeldas = 2;
        Tablero tablero = new Tablero(celdaInicial);
        tablero.armarMapa(cantidadCeldas);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        int coordenadaXMedio = 0;
        int coordenadaYMedio = 0;

        jugador.jugarTurno();

        Assertions.assertTrue(jugador.estaEnCelda(coordenadaXMedio, coordenadaYMedio));
    }

    @Test
    public void test10AlSerAtacadoPorUnaFieraYConTodoElEquipamientoNoPierdeEnergia() {

        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial;

        // Obtiene la llave
        for (int i = 0; i < 4; i++) {
            mejorador.afectar(jugador);
        }

        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test11AlTenerLaLlaveYrecibirOtroPremioNoCambiaNada() {
        Celda celdaInicial = new CeldaInicial();
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejorador = new MejorarEquipamiento();
        Fiera fiera = new Fiera();
        int energiaEsperada = 20; // igual a la energia inicial

        // El jugador obtiene la llave
        for (int i = 0; i < 4; i++) {
            mejorador.afectar(jugador);
        }

        mejorador.afectar(jugador); //No recibe nada

        fiera.afectar(jugador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test12AlPasarTreintaTurnosYnadieLlegaAlaMetaSeTerminoElJuego() {

        CeldaInicial celdaInicial = new CeldaInicial();
        int cantidadCeldas = 3;
        Tablero tablero = new Tablero(celdaInicial);
        tablero.armarMapa(cantidadCeldas);

        Gladiador gladiador1 = new Gladiador();
        Gladiador gladiador2 = new Gladiador();
        Jugador jugador1 = new Jugador(gladiador1, celdaInicial);
        Jugador jugador2 = new Jugador(gladiador2, celdaInicial);

        for (int i = 0; i < 30; i++) {
            jugador1.jugarTurno();
            jugador2.jugarTurno();
        }

        Assertions.assertFalse(jugador1.jugarTurno());
        Assertions.assertFalse(jugador2.jugarTurno());
    }
*/
}
