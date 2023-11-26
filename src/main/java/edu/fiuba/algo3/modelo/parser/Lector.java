package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepcion.ArchivoNoEncontradoError;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Tablero;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Lector {
    private static final String RUTA = "/archivos/mapa.json";

    public void leerArchivo(String ruta) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader lectorJson = new FileReader(System.getProperty("user.dir") + ruta)) {
            Object objetoParseado = jsonParser.parse(lectorJson);
            generarTablero(objetoParseado);
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoError(System.getProperty("user.dir") + ruta);
        } catch(IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void generarTablero(Object objetoParseado) {
        JSONObject tablero = (JSONObject) objetoParseado;

        ArrayList<Celda> celdas = new ArrayList<Celda>();
    }

/*
    public Tablero parse(JSONObject tablero) {

        JSONObject mapa = (JSONObject) tablero.get("mapa");
        int ancho = (int) mapa.get("ancho");
        int largo = (int) mapa.get("largo");

        JSONObject camino = (JSONObject) tablero.get("camino");
        JSONArray celdas = (JSONArray) camino.get("celdas");

        for (int i = 0; i < celdas.size(); i++) {
            JSONObject celda = (JSONObject) celdas.get(i);
            int x = (int) celda.get("x");
            int y = (int) celda.get("y");
            String tipo = (String) celda.get("tipo");
        }



        Tablero nuevoTablero = new Tablero(ancho, largo);


        JSONArray jrespuestasEnOrden = (JSONArray) jOrder.get("respuestasEnOrden");
        String enunciado = (String) jOrder.get("enunciado");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        jrespuestasEnOrden.forEach(jsRespuesta-> respuestasOrdenadas.add(new OpcionSimple((String) jsRespuesta )));

        return FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);
    }*/
}

