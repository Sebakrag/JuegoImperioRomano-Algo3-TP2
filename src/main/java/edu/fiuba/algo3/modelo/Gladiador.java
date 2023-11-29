package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.celdas.CeldaComun;
import edu.fiuba.algo3.modelo.celdas.CeldaFinal;
import edu.fiuba.algo3.modelo.celdas.CeldaInicial;
import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;

public class Gladiador extends Personaje {
    //Declaramos constantes ? -> SI
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;

    // TODO: Nos dimos cuenta que hay estados...
    private boolean lesionado;

    public Gladiador() {
        this.energia = ENERGIA_INICIAL;
        this.seniority = new Novato();
        this.equipamiento = new Desequipado();
        this.lesionado = false;
    }

    // -------------------------------- PUBLICOS -------------------------------- //

    public void aumentarEnergia() {
        this.energia += this.seniority.aumentarEnergia();
    }

    // TODO: diu
    public boolean tieneEnergia() {
        boolean tieneEnergia = energia > SIN_ENERGIA;
        if(!tieneEnergia){
            this.energia += 5;
        }
        return tieneEnergia;
    }

    public void mejorarSeniority(int turnos) {
        this.seniority = this.seniority.ascender(turnos);
    }

    public boolean totalmenteEquipado() { return this.equipamiento.equipoCompleto(); }

    public void recibirImpacto(Fiera fiera) {
        this.energia = this.equipamiento.recibirAtaque(this.energia);
    }

    public void recibirImpacto(Bacanal bacanal) {
        this.energia = bacanal.calcularEnergia(this.energia);
    }

    public void recibirImpacto(Lesion lesion) {
        this.lesionado = true;
    }

    public void recibirImpacto(Comida comida) {      // Este metodo reemplaza el metodo 'recibirEnergia()' de Gladiador
        this.energia = comida.calcularEnergia(this.energia);
    }

    public void recibirImpacto(Potenciador potenciador) {
        this.equipamiento = this.equipamiento.mejorarEquipamiento(potenciador);
    }

    public void recibirImpacto(Vacio vacio) {
        //no hace nada;)
    }

    //TODO: tan modificando el estado desde fuera!!. Cuando la celda pase por este estado, esto vuela
    public void sanar(){
        this.lesionado = false;
    }

    public boolean estaLesionado(){
        return this.lesionado;
    }

}
