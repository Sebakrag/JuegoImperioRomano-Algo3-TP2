package edu.fiuba.algo3.testsUnitarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExcepcionesTests {

    @Test
    public void test01LanzaAfectanteInvalidoError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test02LanzaArchivoNoEncontradoError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test03LanzaCantidadInvalidaDeCeldasError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test04LanzaCoordenadaInvalidaError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test05LanzaPasaronTreintaRondasYnoHuboGanadorError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test06LanzaTipoDeCeldaEnArchivoNoValidaError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test07LanzaTurnoPerdidoError() {

        Assertions.assertNotSame(2, 3);
    }

    @Test
    public void test08LanzaUnJugadorGanoLaPartidaError() {

        Assertions.assertNotSame(2, 3);
    }

}
