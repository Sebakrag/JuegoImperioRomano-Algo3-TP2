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

    public Tablero leerArchivo(String ruta) throws ArchivoNoEncontradoError, IOException, ParseException {
        try (FileReader lectorJson = new FileReader(System.getProperty("user.dir") + ruta)) {

            JSONParser jsonParser = new JSONParser();
            JSONObject json = (JSONObject) jsonParser.parse(lectorJson);

            return generarTablero(json);

        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoError(System.getProperty("user.dir") + ruta);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Tablero generarTablero(JSONObject jsonTablero) {
        ArrayList<Celda> celdas = this.parsearCeldas(jsonTablero);
        Tablero tablero = new Tablero();
        tablero.armarMapa(celdas);
        return tablero;
    }

    private ArrayList<Celda> parsearCeldas(JSONObject tablero) throws ArchivoNoEncontradoError{
        JSONArray celdas = (JSONArray)((JSONObject) tablero.get("camino")).get("celdas");

        if (celdas == null){ throw new ArchivoNoEncontradoError("El mapa no es valido"); }
        CeldaParser celdaParser = new CeldaParser();
        ArrayList<Celda> celdasParseadas = new ArrayList<>();

        for (Object celda : celdas) {
            Celda celdaCreada = celdaParser.parse((JSONObject) celda);
            celdasParseadas.add(celdaCreada);
        }

        return celdasParseadas;
    }

}

