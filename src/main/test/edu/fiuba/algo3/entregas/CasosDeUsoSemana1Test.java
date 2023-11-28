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

        Celda celdaInicial = new CeldaInicial(0,0);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante comida = new Comida();

        comida.afectar(gladiador); //energia = 35
        inhabilitarGladiador(gladiador, 2);

        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
    }

    @Test
    public void test05AlRecibirUnPremioPorPrimeraVezRecibeUnCasco() {

        Celda celdaInicial = new CeldaInicial(0,0);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();

        mejora.afectar(gladiador);  // El jugador obtiene un casco, al ser atacado 2 veces por una fiera se queda sin energia
        inhabilitarGladiador(gladiador, 2);

        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
    }

    @Test
    public void test06AlRecibirUnPremioPorTerceraVezObtieneEscudoYEspada() {

        Celda celdaInicial = new CeldaInicial(0,0);
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();

        obtenerEscudoYEspada(gladiador, mejora);

        inhabilitarGladiador(gladiador, 10); //para sacarle toda la energia debe ser atacado 10 veces

        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
    }

    @Test
    public void test07AlHaberUnCombateConFieraSiTieneCascoPierdeQuincePuntosDeEnergia() {

        CeldaInicial celdaInicial = new CeldaInicial(0, 0);
        CeldaComun celdaComun = new CeldaComun(0,1);
        celdaComun.setObstaculo(new Vacio());
        celdaComun.setPremio(new Vacio());
        celdaInicial.setSiguiente(celdaComun);

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();
        Fiera fiera = new Fiera();

        mejora.afectar(gladiador);  // El jugador obtiene un casco.
        fiera.afectar(gladiador); //lo ataca la fiera y queda con energia = 5
        Assertions.assertDoesNotThrow(() -> jugador.jugarTurno(new Dado(1))); //puede jugar su turno

        fiera.afectar(gladiador);
        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(new Dado(6)));
    }

    @Test
    public void test08AlPasarOchoTurnosElGladiadorPasaDeNovatoASemiSenior() {

        CeldaInicial celdaInicial = new CeldaInicial(0,0);
        CeldaFinal celdaFinal = new CeldaFinal(0,1);
        ArrayList<Celda> celdas = new ArrayList<>();
        celdas.add(celdaInicial);
        celdas.add(celdaFinal);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Dado dado = new Dado(6);

        ascenderASemiSenior(jugador, dado); //pasa a tener 25 de energia.
        inhabilitarGladiador(gladiador, 2); //atacado 2 veces por fiera

        Assertions.assertThrows(TurnoPerdidoError.class,() -> jugador.jugarTurno(dado));
    }

   @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {

       CeldaInicial celdaInicial = new CeldaInicial(0,0);
       CeldaFinal celdaFinal = new CeldaFinal(0,1);
       ArrayList<Celda> celdas = new ArrayList<Celda>();
       celdas.add(celdaInicial);
       celdas.add(celdaFinal);
       Tablero tablero = new Tablero();
       tablero.armarMapa(celdas);

       Gladiador gladiador = new Gladiador();
       Jugador jugador = new Jugador(gladiador, celdaInicial);
       Dado dado = new Dado(1);

       jugador.jugarTurno(dado); //el jugador llega al final y vuelve al medio, deberia poder jugar de nuevo otro turno.

       Assertions.assertDoesNotThrow(() -> jugador.jugarTurno(dado));
    }


    @Test
    public void test10AlSerAtacadoPorUnaFieraYConTodoElEquipamientoNoPierdeEnergia(){

        Celda celdaInicial = new CeldaInicial(0,0);
        CeldaComun celdaComun = new CeldaComun(0,1);
        celdaComun.setPremio(new Vacio());
        celdaComun.setObstaculo(new Vacio());
        celdaInicial.setSiguiente(celdaComun);

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();

        obtenerLlave(gladiador,mejora);

        inhabilitarGladiador(gladiador, 1000); //no va a perder nunca energia al ser atacado infinitas veces

        Assertions.assertDoesNotThrow(() -> jugador.jugarTurno(new Dado(1))); //puede jugar turno.
    }

    @Test
    public void test11AlTenerLaLlaveYrecibirOtroPremioNoCambiaNada() {

        Celda celdaInicial = new CeldaInicial(0,0);
        CeldaComun celdaComun = new CeldaComun(0,1);
        celdaComun.setPremio(new Vacio());
        celdaComun.setObstaculo(new Vacio());
        celdaInicial.setSiguiente(celdaComun);

        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, celdaInicial);
        Afectante mejora = new Potenciador();

        obtenerLlave(gladiador,mejora);

        mejora.afectar(gladiador); //No recibe nada, sigue con llave.

        inhabilitarGladiador(gladiador, 1000); //no va a perder nunca energia al ser atacado infinitas veces

        Assertions.assertDoesNotThrow(() -> jugador.jugarTurno(new Dado(1))); //puede jugar turno.
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
