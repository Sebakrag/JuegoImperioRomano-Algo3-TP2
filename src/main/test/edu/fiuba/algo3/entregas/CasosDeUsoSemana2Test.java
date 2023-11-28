package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.parsers.TableroParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.excepcion.*;
import edu.fiuba.algo3.modelo.celdas.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class CasosDeUsoSemana2Test {

    @Test
    public void test13ElFormatoDelMapaJsonEsValido(){
        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertDoesNotThrow(() -> tableroParser.leerArchivo(rutaJsonValida));
    }

    @Test
    public void test14AlNoEncontrarElArchivoTableroParserLevantaUnaExcepcion(){
        String rutaJsonValida = "/NoMapa.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(ArchivoNoEncontradoError.class,() -> tableroParser.leerArchivo(rutaJsonValida));
    }

    @Test
    public void test15ElTableroSeCreaCorrectamenteAPartirDeUnArchivoJSON(){
        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();
        Tablero tablero = tableroParser.leerArchivo(rutaJsonValida);

        Celda celda = tablero.getCeldaInicial();
        int coordenadaXInicial = 1;
        int coordenadaYInicial = 7;

        Assertions.assertTrue(celda.tieneCoordenadas(coordenadaXInicial,coordenadaYInicial));
    }

    @Test
    public void test16ElFormatoJsonEsValidoYConversionDelMapaHecha(){

        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();
        Tablero tablero = tableroParser.leerArchivo(rutaJsonValida);
        Celda celda = tablero.getCeldaInicial();
        Celda celdaConEquipamiento = celda.celdaSiguiente();
        Celda celdaConComida = celdaConEquipamiento.celdaSiguiente();

        Gladiador gladiador = new Gladiador();
        celdaConComida.afectar(gladiador);
        int energiaInicial = 20;
        int energiaEsperada = energiaInicial + 15;

        Assertions.assertTrue(gladiador.energiaIgualA(energiaEsperada));
    }

    @Test
    public void test17ElJsonAlTenerCoordenadasIncorrectasLanzaError(){
        String rutaJsonInvalido = "/archivos/mapaConCoordenadaInvalida.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(CoordenadaInvalidaError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test18ElJsonAlTenerUnaSolaCeldaLanzaError(){
        String rutaJsonInvalido = "/archivos/mapaConUnaCelda.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(CantidadInvalidaDeCeldasError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test19TipoDeCeldaEnArchivoNoValidaError(){
        String rutaJsonInvalido = "/archivos/mapaConTipoInvalido.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(TipoDeCeldaEnArchivoNoValidaError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }

    @Test
    public void test20AfectanteInvalidoError(){
        String rutaJsonInvalido = "/archivos/mapaConAfectanteInvalido.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(AfectanteInvalidoError.class, () -> tableroParser.leerArchivo(rutaJsonInvalido));
    }


    @Test
    public void testLogSistemaAlSerAtacadoPorUnAnimal() {

        Logger logger = LogManager.getLogger();

        logger.info("Hello world!");
        logger.trace("Entering method doSomething with parameters (param1=5, param2=10)");
        logger.debug("Processing request for user ID 12345");
        logger.info("user with ID '1234' just signed in");
        logger.warn("Potential security vulnerability detected in user input: '...'");
        logger.error("Failed to connect to database: java.sql.SQLException: Connection refused");
    }

}
