package edu.fiuba.algo3.modelo.parser;

import org.json.simple.JSONObject;
import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.excepcion.TipoDeCeldaEnArchivoNoValidaError;

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
        int x = (int) celda.get("x");
        int y = (int) celda.get("y");

        String tipo = (String) celda.get("tipo");
        String premio = (String) celda.get("premio");
        String obstaculo = (String) celda.get("obstaculo");

        switch(tipo){
            case "Salida":
                return new CeldaInicial(x, y);
            case "Camino":
                CeldaComun celdaComun = new CeldaComun(x, y);
                setPremioACelda(celdaComun, premio);
                setObstaculoACelda(celdaComun, obstaculo);
                return new CeldaComun(x, y );
            case "Llegada":
                return new CeldaFinal(x, y);
            default:
                throw new TipoDeCeldaEnArchivoNoValidaError();
        }

    }

    public void setPremioACelda(CeldaComun celda, String afectante){
        switch (afectante){
            case "Equipamiento":
                celda.setPremio(new Potenciador());
            case "Comida":
                celda.setPremio(new Comida());
            case "":
                celda.setPremio(new Vacio());
        }
    }

    public void setObstaculoACelda(CeldaComun celda, String afectante){
        switch (afectante){
            case "Lesion":
                celda.setObstaculo(new Lesion());
            case "Bacanal":
                celda.setObstaculo(new Bacanal());
            case "Fiera":
                celda.setObstaculo(new Fiera());
            case "":
                celda.setObstaculo(new Vacio());
        }
    }
}
