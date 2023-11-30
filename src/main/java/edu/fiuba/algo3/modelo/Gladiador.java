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

    private static final int ENERGIA_INICIAL = 20;
    private int energia;
    private final Logger logger;
    private Seniority seniority;
    private Equipamiento equipamiento;
    private Estado estado;

    public Gladiador(Logger logger) {
        this.energia = ENERGIA_INICIAL;
        this.seniority = new Novato(logger);
        this.equipamiento = new Desequipado();
        this.estado = new Sano();
        this.logger = logger;
    }



    // -------------------------------- PUBLICOS -------------------------------- //

    public void mejorarSeniority(int turnos) {
        this.seniority = this.seniority.ascender(turnos);
        this.energia += this.seniority.aumentarEnergia();
        logger.info("Se ha aumentado la energía. Nueva energía: " + this.energia);
    }

    public boolean totalmenteEquipado() { return this.equipamiento.equipoCompleto(); }

    public void recibirImpacto(Fiera fiera) {
        this.energia = this.equipamiento.recibirAtaque(this.energia);
        this.estado = this.estado.cansar(this.energia);
        logger.info("es atacado por un animal en casilla (X,Y) y pierde energía 10");
    }

    public void recibirImpacto(Bacanal bacanal) {
        this.energia = bacanal.calcularEnergia(this.energia);
        // TODO: preguntar: Conviene que la energia sea un atributo del estado del gladiador? Eso nos obliga a modificar bacanal, fiera y comida
        //bacanal.modificarEnergia(this.estado);
        this.estado = this.estado.cansar(this.energia);
        logger.info(" El jugador asiste a un Bacanal y saca 4 puntos de energía por cada a trago tomado.");
    }

    public void recibirImpacto(Lesion lesion) {
        this.estado = this.estado.lesionar();
        logger.info("Se ha recibido un impacto de tipo Lesion. Nuevo estado: " + this.estado);
    }

    public void recibirImpacto(Comida comida) {
        this.energia = comida.calcularEnergia(this.energia);
        this.estado = this.estado.sanar();
        logger.info("Gladiador afectado. Se ha encontrado una comida, se incrementan 15 puntos (+" + this.energia + ").");
    }

    public void recibirImpacto(Potenciador potenciador) {
        this.equipamiento = this.equipamiento.mejorarEquipamiento(potenciador);
        logger.info("Mejorando equipamiento.");
    }

    public void recibirImpacto(Vacio vacio) {
        //no hace nada;)
    }

    public Celda mover(int avances, Celda celdaActual, int turnos) throws TurnoPerdidoError {
        this.mejorarSeniority(turnos);

        try {
            this.estado.avanzar(avances);
            celdaActual = this.avanzar(avances, celdaActual);
            celdaActual = celdaActual.afectar(this);
            logger.info("Movimiento exitoso. Nueva celda: " + celdaActual);
            return celdaActual;
        } catch (TurnoPerdidoError e) {
            this.energia = this.estado.calcularEnergia(this.energia);
            this.estado = this.estado.sanar();
            logger.error("Turno perdido. Energía actual: " + this.energia + ", Nuevo estado: " + this.estado);
            throw e;
        }
    }

    // ------------------------------ PRIVADOS ----------------------------- //
    private Celda avanzar(int avances, Celda celdaActual) {
        for (int i = 0; i < avances; i++) {
            celdaActual = celdaActual.celdaSiguiente();
        }
        return celdaActual;
    }
}
