package edu.fiuba.algo3.entregas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoSemana1Test {
    @Test
    public void test01SeInicializaUnJugadorConLaEnergiaYElEquipamientoCorrecto() {

        int energiaInicial = 20;
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador);

        Assertions.assertTrue(jugador.energiaIgualA(energiaInicial));
    }

    @Test
    public void test02JugadorSaleCorrectamenteDeLaCasillaInicial() {
    }

    @Test
    public void test03UnJugadorSinEnergiaPierdeElTurno() {
    }

    @Test
    public void test04AlRecibirComidaSuEnergiaIncrementaEnQuince() {
    }

    @Test
    public void test05AlRecibirUnPremioPorPrimeraVezRecibeUnCasco() {
    }

    @Test
    public void test06AlRecibirUnPremioPorTerceraVezObtieneEscudoYEspada() {
    }


    @Test
    public void test07AlHaberUnCombateConFieraSiTieneCascoPierdeQuincePuntosDeEnergia() {
    }

    @Test
    public void test08AlPasarOchoTurnosElGladiadorPasaDeNovatoAsemiSenior() {
    }

    @Test
    public void test09AlLlegarAlaMetaSinLaLlaveRetrocedeAlaMitadDeLasCasillas() {
    }

    @Test
    public void test10AlSerAtacadoPorUnaFieraYconTodoElEquipamientoNoPierdeEnergia() {
    }

    @Test
    public void test11AlTenerLaLlaveYrecibirOtroPremioNoCambiaNada() {
    }

    @Test
    public void test12AlPasarTreintaTurnosYnadieLlegaAlaMetaSeTerminoElJuego() {
    }
}
