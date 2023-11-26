package edu.fiuba.algo3.modelo.parser;


import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class TableroParser {

    public Tablero parse(JSONObject mapa) {
    /* Nos es util ?
        JSONObject mapa = (JSONObject) tablero.get("mapa");
        int ancho = (int) mapa.get("ancho");
        int largo = (int) mapa.get("largo");
    */
        JSONObject camino = (JSONObject) mapa.get("camino");
        JSONArray celdas = (JSONArray) mapa.get("celdas");

        CeldaParser celdaParser = new CeldaParser();
        ArrayList<Celda> celdasCreadas = new ArrayList<>();
        agregarCeldas(celdas, celdaParser, celdasCreadas);

        Tablero tablero = new Tablero(celdasCreadas.get(0));
        tablero.armarMapa(celdasCreadas);

        return tablero;
    }

    public void agregarCeldas(JSONArray celdas, CeldaParser celdaParser, ArrayList<Celda> celdasCreadas) throws CoordenadaInvalidaError{

        for (int i = 0; i < celdas.size(); i++) {
            try{
                Celda celdaCreada = celdaParser.parse((JSONObject) celdas.get(i));
                celdasCreadas.add(celdaCreada);
            } catch (CoordenadaInvalidaError e ){
               //e.printStackTrace();{
                throw new CoordenadaInvalidaError();
            }
        }
    }
}

