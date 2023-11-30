package edu.fiuba.algo3.modelo.celdas;

import edu.fiuba.algo3.modelo.afectantes.Afectante;
import edu.fiuba.algo3.modelo.Gladiador;
import org.apache.logging.log4j.Logger;

public class CeldaComun extends Celda {
    private Afectante premio;
    private Afectante obstaculo;
    //private final Logger logger;
    public CeldaComun(int x, int y, Afectante premio, Afectante obstaculo,Logger logger){
        this.coordenadasValidas(x,y);
        this.x = x;
        this.y = y;
        this.premio = premio;
        this.obstaculo = obstaculo;
        this.logger = logger;
    }

    public Celda afectar(Gladiador gladiador){
        logger.info("Se avanzo hasta la celda ("+ this.x + ", " + this.y + " )");
        this.premio.afectar(gladiador);
        this.obstaculo.afectar(gladiador);
        return this;
    }

    @Override
    public Celda celdaSiguiente(){
        return this.siguiente;
    }
}
