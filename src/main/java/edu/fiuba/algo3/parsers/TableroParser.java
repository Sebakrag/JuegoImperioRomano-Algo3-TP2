package edu.fiuba.algo3.parsers;


import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import edu.fiuba.algo3.modelo.excepcion.CoordenadaInvalidaError;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TableroParser {

    public Tablero leerArchivo(String ruta) throws ArchivoNoEncontradoError {
        JSONParser jsonParser = new JSONParser();
        Tablero tablero = new Tablero();

        try (FileReader lectorJson = new FileReader(System.getProperty("user.dir") + ruta)) {
            Object objetoParseado = jsonParser.parse(lectorJson);
            generarTablero(objetoParseado, tablero);
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoError(System.getProperty("user.dir") + ruta);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return tablero;
    }

    public void generarTablero(Object objetoParseado, Tablero tablero) {
        JSONObject jsonTablero = (JSONObject) objetoParseado;

        ArrayList<Celda> celdasCreadas = new ArrayList<>();
        this.parse(jsonTablero, celdasCreadas);

        tablero.armarMapa(celdasCreadas);
    }


    public void parse(JSONObject tablero, ArrayList<Celda> celdasCreadas){

        /* Nos es util ?
        JSONObject mapa = (JSONObject) tablero.get("mapa");

        int ancho = (int) mapa.get("ancho");
        int largo = (int) mapa.get("largo");
    */
        JSONObject camino = (JSONObject) tablero.get("camino");
        JSONArray celdas = (JSONArray) camino.get("celdas");

        agregarCeldas(celdas, celdasCreadas);

    }

    public void agregarCeldas(JSONArray celdas, ArrayList<Celda> celdasCreadas) throws CoordenadaInvalidaError {
        CeldaParser celdaParser = new CeldaParser();

        for (Object celda : celdas) {
            try {
                Celda celdaCreada = celdaParser.parse((JSONObject) celda);
                celdasCreadas.add(celdaCreada);
            } catch (CoordenadaInvalidaError e) {
                //e.printStackTrace();{
                throw new CoordenadaInvalidaError();
            }
        }
    }
}

