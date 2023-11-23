package edu.fiuba.algo3.testsUnitarios;

import edu.fiuba.algo3.modelo.Seniority;
import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.seniorities.SemiSenior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NovatoTests {
    @Test
    //mockito ?
    public void test01SiTurnoEsMenorQueOchoAscenderDevuelveASiMismo(){
        Novato novato = new Novato();
        int turno = 4;

        Seniority seniortyActual = novato.ascender(turno);

        // funciona pero a que costo?
        Assertions.assertEquals(novato, seniortyActual);
    }

    @Test
    public void test02SiTurnoEsOchoAscenderDevuelveSiguienteSeniority() {
        Novato novato = new Novato();
        int turno = 8;

        // A CHEQUEAR !
        Seniority seniorityNueva = novato.ascender(turno);

        Assertions.assertNotEquals(novato, seniorityNueva);
    }

}
