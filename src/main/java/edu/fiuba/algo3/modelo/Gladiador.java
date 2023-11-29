package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;
import edu.fiuba.algo3.modelo.estados.*;
import edu.fiuba.algo3.modelo.seniorities.Seniority;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/


public class Gladiador {

    private static final int ENERGIA_INICIAL = 20;
    private int energia;
    private Seniority seniority;
    private Equipamiento equipamiento;
    private Estado estado;

    public Gladiador() {
        this.energia = ENERGIA_INICIAL;
        this.seniority = new Novato();
        this.equipamiento = new Desequipado();
        this.estado = new Sano();
    }

    /*private static Logger logger = LogManager.getLogger();*/

    // -------------------------------- PUBLICOS -------------------------------- //

    public void aumentarEnergia() {
        this.energia += this.seniority.aumentarEnergia();
        /*logger.info("Se ha aumentado la energía. Nueva energía: " + this.energia);*/

    }

    public void mejorarSeniority(int turnos) {
        this.seniority = this.seniority.ascender(turnos);
    }

    public boolean totalmenteEquipado() { return this.equipamiento.equipoCompleto(); }

    public void recibirImpacto(Fiera fiera) {
        this.energia = this.equipamiento.recibirAtaque(this.energia);
        this.estado = this.estado.cansar(this.energia);
    }

    public void recibirImpacto(Bacanal bacanal) {
        this.energia = bacanal.calcularEnergia(this.energia);
        // TODO: preguntar:
        //bacanal.modificarEnergia(this.estado);
        this.estado = this.estado.cansar(this.energia);
    }

    public void recibirImpacto(Lesion lesion) {
        this.estado = this.estado.lesionar();
    }

    public void recibirImpacto(Comida comida) {
        this.energia = comida.calcularEnergia(this.energia);
        this.estado = this.estado.sanar();
    }

    public void recibirImpacto(Potenciador potenciador) {
        this.equipamiento = this.equipamiento.mejorarEquipamiento(potenciador);
    }

    public void recibirImpacto(Vacio vacio) {
        //no hace nada;)
    }

    public int avanzar(int avances) {
        int cantidad = this.estado.avanzar(avances);
        this.energia = this.estado.calcularEnergia(this.energia);
        this.estado = this.estado.sanar();
        return cantidad;
    }
}
