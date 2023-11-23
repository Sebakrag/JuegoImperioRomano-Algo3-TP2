package edu.fiuba.algo3.testsUnitarios;
import edu.fiuba.algo3.modelo.Seniority;
import edu.fiuba.algo3.modelo.seniorities.SemiSenior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SemiSeniorTests {
    @Test
    public void test01SiTurnoEsEntreOchoYOnceAscenderDevuelveASiMismo(){
        SemiSenior semiSenior = new SemiSenior();
        int turno = 9;

        Seniority seniortyActual = semiSenior.ascender(turno);

        Assertions.assertEquals(semiSenior, seniortyActual);
    }
    /*@Test
    public void test02SiTurnoEsDoceAscenderDevuelveSiguienteSeniority(){
        SemiSenior semiSenior = new SemiSenior();
        int turno = 12;

        Seniority seniortyActual = semiSenior.ascender(turno);

        Assertions.assertNotEquals(semiSenior, seniortyActual);
    }*/

}
