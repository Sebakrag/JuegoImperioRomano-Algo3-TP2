package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.seniorities.Seniority;
import edu.fiuba.algo3.modelo.seniorities.Novato;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NovatoTests {
    @Test
    //mockito ?
    public void test01SiTurnoEsMenorQueOchoAscenderDevuelveASiMismo(){
        Logger logger = LogManager.getLogger();
        Novato novato = new Novato(logger);
        int turno = 4;

        Seniority seniortyActual = novato.ascender(turno);

        // funciona pero a que costo?
        Assertions.assertEquals(novato, seniortyActual);
    }

    @Test
    public void test02SiTurnoEsOchoAscenderDevuelveSiguienteSeniority() {
        Logger logger = LogManager.getLogger();
        Novato novato = new Novato(logger);
        int turno = 8;

        // A CHEQUEAR !
        Seniority seniorityNueva = novato.ascender(turno);

        Assertions.assertNotEquals(novato, seniorityNueva);
    }

}
