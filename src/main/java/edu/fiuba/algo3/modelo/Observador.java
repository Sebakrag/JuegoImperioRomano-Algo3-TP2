package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.*;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.seniorities.Seniority;

public interface Observador {

    public void actualizar(String nombreJugador, Celda celdaAnterior, Celda celdaActual, int avances);

    public void actualizar(String nombreJugador, int rondas);

    public void actualizar(String nombreJugador, boolean hayGanador);

    public void actualizar(String equipamientoID);

    public void actualizar(int energia, String ID, String seniorityID);
}
