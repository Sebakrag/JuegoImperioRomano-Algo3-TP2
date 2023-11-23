package edu.fiuba.algo3.testsUnitarios;
import edu.fiuba.algo3.modelo.Seniority;
import edu.fiuba.algo3.modelo.seniorities.Senior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeniorTests {
    @Test
    public void test01SiTurnoEsDeDoceEnAdelanteAscenderDevuelveASiMismo(){
      Senior senior = new Senior();
      int turno = 15;

      Seniority seniortyActual = senior.ascender(turno);

      Assertions.assertEquals(senior, seniortyActual);

    }
}
