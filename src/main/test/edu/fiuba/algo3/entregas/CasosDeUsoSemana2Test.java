package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.parser.TableroParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.excepcion.*;


public class CasosDeUsoSemana2Test {

    @Test
    public void test13ElFormatoDelMapaJsonEsValido(){
        String rutaJsonValida = "/archivos/mapa.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertDoesNotThrow(() -> tableroParser.leerArchivo(rutaJsonValida));
    }

    @Test
    public void test14AlNoEncontrarElArchivoTableroParserLevantaUnaExcepcion(){
        String rutaJsonValida = "/mapa.json";
        TableroParser tableroParser = new TableroParser();

        Assertions.assertThrows(ArchivoNoEncontradoError.class,() -> tableroParser.leerArchivo(rutaJsonValida));
    }

    @Test
    public void test15ElFormatoJsonEsValidoYConversionDeObstaculosHecha(){ }



    @Test
    public void test16ElFormatoJsonEsValidoYConversionDelMapaHecha(){

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
