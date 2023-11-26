package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import edu.fiuba.algo3.modelo.parser.Lector;


public class CasosDeUsoSemana2Test {

    @Test
    public void test13ElFormatoDelMapaJsonEsValido(){
        String rutaJsonValida = "archivos/mapa.json";
        Lector lector = new Lector();

        Assertions.assertDoesNotThrow(() -> lector.leerArchivo(rutaJsonValida));
    }


    @Test
    public void test15ElFormatoJsonEsValidoYConversionDeObstaculosHecha(){

    }

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
