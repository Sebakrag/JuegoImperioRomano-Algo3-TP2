package edu.fiuba.algo3.modelo.excepcion;

public class ArchivoNoEncontradoError extends RuntimeException {
        public ArchivoNoEncontradoError(String ruta){ super(ruta); };
}
