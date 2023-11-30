package edu.fiuba.algo3.testsUnitarios;
import edu.fiuba.algo3.modelo.seniorities.Seniority;
import edu.fiuba.algo3.modelo.seniorities.SemiSenior;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SemiSeniorTests {
    @Test
    public void test01SiTurnoEsEntreOchoYOnceAscenderDevuelveASiMismo(){
        Logger logger = LogManager.getLogger();
        SemiSenior semiSenior = new SemiSenior(logger);
        int turno = 9;

        Seniority seniortyActual = semiSenior.ascender(turno);

        Assertions.assertEquals(semiSenior, seniortyActual);
    }

   /* @Test
    public void test02SiTurnoEsDoceAscenderDevuelveSiguienteSeniority(){
        SemiSenior semiSenior = new SemiSenior();
        int turno = 12;

        Seniority seniorityActual = semiSenior.ascender(turno);

        Assertions.assertEquals(semiSenior, seniorityActual);
    }*/

}
