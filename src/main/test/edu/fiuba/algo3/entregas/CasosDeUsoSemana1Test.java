package edu.fiuba.algo3.entregas;


import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.celdas.*;

import java.util.ArrayList;

public class CasosDeUsoSemana1Test {
    @Test
    public void test01SeInicializaUnJugadorConLaEnergiaYElEquipamientoCorrecto() {

        int energiaInicial = 20;
        int energiaLuegoDeSerAtacado = 0;

        CeldaInicial celdaInicial = new CeldaInicial(0, 0);
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
        int coordenadaXInicial = 0;
        int coordenadaYInicial = 0;

        Dado dado = new Dado();
        CeldaInicial celdaInicial = new CeldaInicial(0, 0);
        CeldaFinal celdaFinal = new CeldaFinal(0,1);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(celdaInicial);
        celdas.add(celdaFinal);

        
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);

        jugador.jugarTurno(dado);

        Assertions.assertFalse(jugador.estaEnCelda(coordenadaXInicial,coordenadaYInicial));
    }


    @Test
    public void test03UnJugadorSinEnergiaPierdeElTurno(){
        int cantidadTurnosEsperado = 1;
        int coordenadaXInicial = 0;
        int coordenadaYInicial = 0;

        Dado dado = new Dado();
        Celda celdaInicial = new CeldaInicial(0, 0);
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

        Celda celdaInicial = new CeldaInicial(0,0);
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
        int energiaEsperada = energiaInicial - danioCasco;

        Celda celdaInicial = new CeldaInicial(0,0);
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

        Celda celdaInicial = new CeldaInicial(0,0);
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

        Celda celdaInicial = new CeldaInicial(0,0);
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

        CeldaInicial celdaInicial = new CeldaInicial(0,0);
        CeldaFinal celdaFinal = new CeldaFinal(0,1);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Dado dado = new Dado();
        ArrayList<Celda> celdas = new ArrayList<>();

        celdas.add(celdaInicial);
        celdas.add(celdaFinal);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);

        for(int i = 0; i < 8; i++){
            jugador.jugarTurno(dado);
        }

        Assertions.assertTrue(jugador.energiaIgualA(energiaEsperada));
    }

   @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {
        // Hay que hacer la logica de ganar.
        int coordenadaXMedio = 0;
        int coordenadaYMedio = 0;

       CeldaInicial celdaInicial = new CeldaInicial(0,0);
       CeldaFinal celdaFinal = new CeldaFinal(0,1);
       ArrayList<Celda> celdas = new ArrayList<Celda>();
       celdas.add(celdaInicial);
       celdas.add(celdaFinal);
       Gladiador gladiador = new Gladiador();
       Jugador jugador = new Jugador(gladiador, celdaInicial);
       Dado dado = new Dado();

       celdas.add(celdaInicial);
       celdas.add(celdaFinal);
       Tablero tablero = new Tablero();
       tablero.armarMapa(celdas);

       jugador.jugarTurno(dado);

        Assertions.assertTrue(jugador.estaEnCelda(coordenadaXMedio, coordenadaYMedio));
    }


    @Test
    public void test10AlSerAtacadoPorUnaFieraYConTodoElEquipamientoNoPierdeEnergia() {

        int energiaInicial = 20;
        int energiaEsperada = energiaInicial;

        Celda celdaInicial = new CeldaInicial(0,0);
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

        Celda celdaInicial = new CeldaInicial(0,0);
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

    @Test
    public void test12AlPasarTreintaTurnosYnadieLlegaAlaMetaSeTerminoElJuego() {
        Juego juego = new Juego();
        CeldaInicial celdaInicial = new CeldaInicial(0,0);
        CeldaFinal celdaFinal = new CeldaFinal(0,1);
        ArrayList<Celda> celdas = new ArrayList<Celda>();
        celdas.add(celdaInicial);
        celdas.add(celdaFinal);

        Assertions.assertThrows(PasaronTreintaRondasYnoHuboGanadorError.class, () -> juego.iniciarPartida(celdas,2));
    }
}
