package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;

public class Gladiador extends Personaje {
    //Declaramos constantes ?
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;

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

    public boolean energiaIgualA(int energia) {
        return this.energia == energia;
    }

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

    public void sanar(){
        this.lesionado = false;
    }

    public boolean estaLesionado(){
        return this.lesionado;
    }
}
