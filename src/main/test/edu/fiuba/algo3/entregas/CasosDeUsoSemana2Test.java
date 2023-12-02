package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.afectantes.Fiera;
import edu.fiuba.algo3.parsers.TableroParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.excepcion.*;
import edu.fiuba.algo3.modelo.celdas.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class CasosDeUsoSemana2Test {

    public void inhabilitarGladiador(Gladiador gladiador, int i) {
        Logger logger = LogManager.getLogger();
        Fiera fiera = new Fiera();

        for (int j = 0; j < i; j++) {
            fiera.afectar(gladiador);
        }
    }

    @Test
    public void test13ElFormatoDelMapaJsonEsValido() {
        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertDoesNotThrow(() -> tableroParser.leerArchivo(rutaJsonValida));
    }

    @Test
    public void test14AlNoEncontrarElArchivoTableroParserLevantaUnaExcepcion() {
        String rutaJsonValida = "/NoMapa.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(ArchivoNoEncontradoError.class,() -> tableroParser.leerArchivo(rutaJsonValida));
    }

    @Test
    public void test15ElTableroSeCreaCorrectamenteAPartirDeUnArchivoJSON() throws IOException, ParseException {
        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();
        Tablero tablero = tableroParser.leerArchivo(rutaJsonValida);
        Celda celda = tablero.getCeldaInicial();

        Logger logger = LogManager.getLogger();
        Dado dado = new Dado(1);
        int turno = 10;
        Gladiador gladiador = new Gladiador(logger, tablero.getCeldaInicial());

        celda.afectar(gladiador); //no recibe nada, continua con energia = 20
        inhabilitarGladiador(gladiador,1); //al afectar 1 vez con fiera -> energia = 0

        Celda celdaProxima = tablero.avanzar(dado.tirar(), celda);
        Celda celdaActual = gladiador.mover(celdaProxima, turno);

        Assertions.assertNotSame(celdaProxima, celdaActual);
    }

    @Test
    public void test16ElFormatoJsonEsValidoYConversionDelMapaHecha() throws IOException, ParseException {
        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();
        Tablero tablero = tableroParser.leerArchivo(rutaJsonValida);
        Celda celda = tablero.getCeldaInicial();
        Celda celdaConEquipamiento = celda.celdaSiguiente();
        Celda celdaConComida = celdaConEquipamiento.celdaSiguiente();

        Logger logger = LogManager.getLogger();
        Dado dado = new Dado(6);
        int turno = 10;
        Gladiador gladiador = new Gladiador(logger, tablero.getCeldaInicial());
        celdaConComida.afectar(gladiador); // energia pasa a 35

        inhabilitarGladiador(gladiador,2); //al afectar 2 veces con fiera -> energia < 0

        Celda celdaProxima = tablero.avanzar(dado.tirar(), celda);
        Celda celdaActual = gladiador.mover(celdaProxima, turno);

        Assertions.assertNotSame(celdaProxima, celdaActual);
    }

    @Test
    public void test17ElJsonAlTenerCoordenadasIncorrectasLanzaError() {
        String rutaJsonInvalido = "/archivos/mapaConCoordenadaInvalida.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(CoordenadaInvalidaError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test18ElJsonAlTenerUnaSolaCeldaLanzaError() {
        String rutaJsonInvalido = "/archivos/mapaConUnaCelda.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(CantidadInvalidaDeCeldasError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test19TipoDeCeldaEnArchivoNoValidaError() {
        String rutaJsonInvalido = "/archivos/mapaConTipoInvalido.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(TipoDeCeldaEnArchivoNoValidaError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test20AfectanteInvalidoError() {
        String rutaJsonInvalido = "/archivos/mapaConAfectanteInvalido.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(AfectanteInvalidoError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test21LogSistemaAlSerAtacadoPorUnAnimal() {
        Logger logger = LogManager.getLogger();

        logger.info("Gladiador + nombreGladiador + avanza + pasos +  , se ha encontrado una comida se incrementa 15 puntos, energia (x)");
        logger.info("Gladiador + nombreGladiador + avanza + pasos +  encuentra un premio y recibe casco en casilla (x,y)");
        logger.info("Gladiador Tito no tiene energía (-5) y pasa turno");
        logger.info("Gladiador Comodus avanza 4, encuentra pizza, energía (10)");
        logger.info("Jugador Tito Gana la Partida");

        logger.debug("Processing request for user ID 12345");

        logger.error("tableroParser.leerArchivo(rutaJsonInvalido");
    }
}

