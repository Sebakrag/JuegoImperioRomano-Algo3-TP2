package edu.fiuba.algo3.modelo.parser;

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
        long x = (long) celda.get("x");
        long y = (long) celda.get("y");

        String tipo = (String) celda.get("tipo");
        String premio = (String) celda.get("premio");
        String obstaculo = (String) celda.get("obstaculo");

        int coorX = (int) x; // VER si hay mejor forma de hacerlo
        int coorY = (int) y;

        switch(tipo){
            case "Salida":
                return new CeldaInicial(coorX, coorY);
            case "Camino":
                CeldaComun celdaComun = new CeldaComun(coorX, coorY);
                setPremioACelda(celdaComun, premio);
                setObstaculoACelda(celdaComun, obstaculo);
                return new CeldaComun(coorX, coorY);
            case "Llegada":
                return new CeldaFinal(coorX, coorY);
            default:
                throw new TipoDeCeldaEnArchivoNoValidaError();
        }

    }

    public void setPremioACelda(CeldaComun celda, String afectante){
        switch (afectante){
            case "Equipamiento":
                celda.setPremio(new Potenciador());
                break;
            case "Comida":
                celda.setPremio(new Comida());
                break;
            case "":
                celda.setPremio(new Vacio());
                break;
            default:
                throw new AfectanteInvalidoError();
        }
    }

    public void setObstaculoACelda(CeldaComun celda, String afectante){
        switch (afectante){
            case "Lesion":
                celda.setObstaculo(new Lesion());
                break;
            case "Bacanal":
                celda.setObstaculo(new Bacanal());
                break;
            case "Fiera":
                celda.setObstaculo(new Fiera());
                break;
            case "":
                celda.setObstaculo(new Vacio());
                break;
            default:
                throw new AfectanteInvalidoError();
        }
    }
}
