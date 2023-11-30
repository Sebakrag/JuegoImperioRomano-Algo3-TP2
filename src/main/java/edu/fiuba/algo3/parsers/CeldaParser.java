package edu.fiuba.algo3.parsers;

import edu.fiuba.algo3.modelo.afectantes.Afectante;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import edu.fiuba.algo3.modelo.celdas.Celda;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.excepcion.*;
import org.apache.logging.log4j.Logger;

/*
*       "x": 17,
        "y": 4,
        "tipo": "Camino",
        "obstaculo": "",
        "premio": "Comida"
*
* */

public class CeldaParser {

    public Celda parse(JSONObject celda) {

        Logger logger = LogManager.getLogger();
        int coorX = (int) ((long) celda.get("x"));
        int coorY = (int) ((long) celda.get("y"));

        String tipo = (String) celda.get("tipo");
        String premio = (String) celda.get("premio");
        String obstaculo = (String) celda.get("obstaculo");

        switch(tipo){
            case "Salida":
                return new CeldaInicial(coorX, coorY, logger);
            case "Camino":
                Afectante afectantePremio = this.parsearPremio(premio);
                Afectante afectanteObstaculo = this.parsearObstaculo(obstaculo);
                CeldaComun celdaComun = new CeldaComun(coorX, coorY, afectanteObstaculo, afectantePremio, logger);
                return celdaComun;
            case "Llegada":
                return new CeldaFinal(coorX, coorY, logger);
            default:
                throw new TipoDeCeldaEnArchivoNoValidaError();
        }
    }

    private Afectante parsearPremio(String afectante) throws AfectanteInvalidoError{
        switch (afectante){
            case "Equipamiento":
                return new Potenciador();
            case "Comida":
                return new Comida();
            case "":
                return new Vacio();
            default:
                throw new AfectanteInvalidoError();
        }
    }

    private Afectante parsearObstaculo(String afectante){
        /*Logger logger = LogManager.getLogger();*/
        switch (afectante){
            case "Lesion":
                return new Lesion();
            case "Bacanal":
                return new Bacanal();
            case "Fiera":
                return new Fiera();
            case "":
                return new Vacio();
            default:
                throw new AfectanteInvalidoError();
        }
    }
}
