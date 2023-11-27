package edu.fiuba.algo3.entregas;


import edu.fiuba.algo3.modelo.excepcion.PasaronTreintaRondasYnoHuboGanadorError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.excepcion.*;

import java.util.ArrayList;

public class CasosDeUsoSemana1Test {

    public void inhabilitarGladiador(Gladiador gladiador, int i){
        Fiera fiera = new Fiera();

        for(int j = 0; j < i; j++){
            fiera.afectar(gladiador);
        }
    }

    public void obtenerEscudoYEspada(Gladiador gladiador, Afectante mejora){
        // El jugador obtiene un Escudo Y Espada.
        for (int i = 0; i < 3; i++) {
            mejora.afectar(gladiador);
        }
    }

    public void obtenerLlave(Gladiador gladiador, Afectante mejora){
        // El jugador obtiene un Escudo Y Espada.
        for (int i = 0; i < 4; i++) {
            mejora.afectar(gladiador);
        }
    }

    public void ascenderASemiSenior(Jugador jugador, Dado dado){
        for(int i = 0; i < 8; i++){
            jugador.jugarTurno(dado);
        }
    }

    @Test
    public void test01SeInicializaUnJugadorConLaEnergiaYElEquipamientoCorrecto() {

        CeldaInicial celdaInicial = new CeldaInicial(0, 0);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);

        inhabilitarGladiador(gladiador, 1);
        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
    }

    @Test
    public void test02JugadorSaleCorrectamenteDeLaCasillaInicial(){

        Dado dado = new Dado(1);
        CeldaInicial celdaInicial = new CeldaInicial(0, 0);
        CeldaComun celdaComun = new CeldaComun(0,1);
        celdaComun.setObstaculo(new Fiera());
        celdaComun.setPremio(new Vacio());
        ArrayList<Celda> celdas = new ArrayList<>();

        celdas.add(celdaInicial);
        celdas.add(celdaComun);

        
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);

        jugador.jugarTurno(dado); //pasa a la siguiente celda que tiene una fiera

        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
    }

    @Test
    public void test03UnJugadorSinEnergiaPierdeElTurno(){

        Celda celdaInicial = new CeldaInicial(0, 0);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);

        inhabilitarGladiador(gladiador,1);

        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
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

        obtenerEscudoYEspada(gladiador, mejora);

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
        Dado dado = new Dado(6);
        ArrayList<Celda> celdas = new ArrayList<>();

        celdas.add(celdaInicial);
        celdas.add(celdaFinal);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);

        ascenderASemiSenior(jugador, dado);

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
       Dado dado = new Dado(6);

       celdas.add(celdaInicial);
       celdas.add(celdaFinal);
       Tablero tablero = new Tablero();
       tablero.armarMapa(celdas);

       jugador.jugarTurno(dado);

        Assertions.assertTrue(jugador.estaEnCelda(coordenadaXMedio, coordenadaYMedio));
    }


    @Test
    public void test10AlSerAtacadoPorUnaFieraYConTodoElEquipamientoNoPierdeEnergia(){

        int energiaInicial = 20;
        int energiaEsperada = energiaInicial;

        Celda celdaInicial = new CeldaInicial(0,0);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera();

        obtenerLlave(gladiador,mejora);

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

        obtenerLlave(gladiador,mejora);

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
