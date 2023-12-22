package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.estados.*;
import edu.fiuba.algo3.modelo.seniorities.Seniority;
import edu.fiuba.algo3.modelo.celdas.Celda;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;


public class Gladiador extends Observable {

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
        this.observadores = new ArrayList<>();
    }


    // -------------------------------- PUBLICOS -------------------------------- //

    public void mejorarSeniority(int turnos) {
        this.seniority = this.seniority.ascender(turnos);
        this.estado = this.seniority.aumentarEnergia(this.estado);
        logger.info("Se ha mejorado la seniority.");

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
        this.estado = new Lesionado(this.estado.getEnergia());
        logger.info("Se ha recibido un impacto de tipo Lesion");
    }

    public void recibirImpacto(Comida comida) {
        this.estado = comida.modificarEnergia(this.estado);
        logger.info("Se ha encontrado un choripan, se incrementan 15 puntos");
    }

    public void recibirImpacto(Potenciador potenciador) {
        this.equipamiento = this.equipamiento.mejorarEquipamiento(potenciador);
        logger.info("Mejorando equipamiento.");
    }

    public void recibirImpacto(Vacio vacio) {
        logger.info("El destino jugara con ti otro turno, descansa");
    }

    public Celda mover(Celda futuraCelda, int turnos) {

        this.estado = this.estado.avanzar(futuraCelda, this, logger);
        this.mejorarSeniority(turnos);

        notificarObservadores(this.estado, this.seniority);
        notificarObservadores(this.equipamiento);

        return this.celdaActual;
    }

    public Estado mover(Celda nuevaCelda) {
        this.celdaActual = nuevaCelda;
        this.celdaActual = celdaActual.afectar(this);
        return  this.estado;
    }


    // -------------------------------- PRIVADOS -------------------------------- //
    private void notificarObservadores(Estado estado, Seniority seniority) {
        for (Observador observador : this.observadores) {
            observador.actualizar(estado.getEnergia(), estado.getID(), seniority.getID());
        }
    }

    private void notificarObservadores(Equipamiento equipamiento) {
        for (Observador observador : this.observadores) {
            observador.actualizar(equipamiento.getID());
        }
    }
}
