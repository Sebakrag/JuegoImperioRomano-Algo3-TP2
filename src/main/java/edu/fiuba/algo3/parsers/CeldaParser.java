package edu.fiuba.algo3.parsers;

import edu.fiuba.algo3.modelo.Afectante;
import org.json.simple.JSONObject;
import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.excepcion.*;

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
        int coorX = (int) ((long) celda.get("x"));
        int coorY = (int) ((long) celda.get("y"));

        String tipo = (String) celda.get("tipo");
        String premio = (String) celda.get("premio");
        String obstaculo = (String) celda.get("obstaculo");

        switch(tipo){
            case "Salida":
                return new CeldaInicial(coorX, coorY);
            case "Camino":
                Afectante afectantePremio = this.parsearPremio(premio);
                Afectante afectanteObstaculo = this.parsearObstaculo(obstaculo);
                CeldaComun celdaComun = new CeldaComun(coorX, coorY, afectanteObstaculo, afectantePremio);
                return celdaComun;
            case "Llegada":
                return new CeldaFinal(coorX, coorY);
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
