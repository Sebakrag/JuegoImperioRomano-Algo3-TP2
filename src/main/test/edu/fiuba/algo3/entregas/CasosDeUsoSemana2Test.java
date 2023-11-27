package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.Equipamiento;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.parsers.TableroParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.excepcion.*;
import edu.fiuba.algo3.modelo.Celda;


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
    public void test17VerificoQueElMapaSeHayaCreadoAcordeAlJson(){

    }

    /*


    @Test
    public void test18LogSistemaAlSerAtacadoPorUnAnimal() {

        logger = new Logger();
        mensaje = new Mensaje();
        String mensajeEsperado = ""Nombre de Gladiador"";

       Assertions.assertEquals(mensajeEsperado, logger.informar(mensaje));




    }
*/
}
