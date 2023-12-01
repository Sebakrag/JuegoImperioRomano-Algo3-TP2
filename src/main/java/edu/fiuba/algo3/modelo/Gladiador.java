package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.excepcion.TurnoPerdidoError;
import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.estados.*;
import edu.fiuba.algo3.modelo.seniorities.Seniority;
import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;


public class Gladiador {

    private final Logger logger;
    private Seniority seniority;
    private Equipamiento equipamiento;
    private Estado estado;
    private Celda celdaActual;

    public Gladiador(Logger logger, Celda celdaActual) {
        this.seniority = new Novato(logger);
        this.equipamiento = new Desequipado();
        this.estado = new Sano();
        this.logger = logger;
        this.celdaActual = celdaActual;
    }


    // -------------------------------- PUBLICOS -------------------------------- //

    public void mejorarSeniority(int turnos) {
        this.seniority = this.seniority.ascender(turnos);
        this.estado = this.seniority.aumentarEnergia(this.estado);
        logger.info("Se mejorado la seniority.");
    }

    public boolean totalmenteEquipado() { return this.equipamiento.equipoCompleto(); }

    public void recibirImpacto(Fiera fiera) {
        this.estado = this.equipamiento.recibirAtaque(this.estado);
        logger.info("Es atacado por un animal en casilla y pierde energía 10");
    }

    public void recibirImpacto(Bacanal bacanal) {
        this.estado = bacanal.modificarEnergia(this.estado);
        logger.info("El jugador asiste a un Bacanal y saca 4 puntos de energía por cada a trago tomado.");
    }

    public void recibirImpacto(Lesion lesion) {
        this.estado = new Lesionado(this.estado.obtenerEnergia());
        logger.info("Se ha recibido un impacto de tipo Lesion");
    }

    public void recibirImpacto(Comida comida) {
        // No hace falta actualizar el estado porque siempre que recibe comida es porque SANO
        this.estado = comida.modificarEnergia(this.estado);
        logger.info("Se ha encontrado un choripan, se incrementan 15 puntos");
    }

    public void recibirImpacto(Potenciador potenciador) {
        this.equipamiento = this.equipamiento.mejorarEquipamiento(potenciador);
        logger.info("Mejorando equipamiento.");
    }

    public void recibirImpacto(Vacio vacio) {
        logger.info("El destino jugara con ti otro turno , descansa");
    }

    public void mover(int avances, Tablero tablero, int turnos) throws TurnoPerdidoError {
        this.estado = this.estado.avanzar(avances, tablero, this, logger);

        this.mejorarSeniority(turnos);
    }

    public void mover(int avances, Tablero tablero){
        celdaActual = tablero.avanzar(avances, celdaActual);
        celdaActual = celdaActual.afectar(this);
    }
}
