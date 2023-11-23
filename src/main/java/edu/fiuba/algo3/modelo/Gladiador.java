package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;

public class Gladiador {
    //Declaramos constantes ?
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;

    private int energia;
    private Seniority seniority;
    private Equipamiento equipamiento;

    public Gladiador() {
        this.energia = ENERGIA_INICIAL;
        this.seniority = new Novato();
        this.equipamiento = new Desequipado();
    }

    // -------------------------------- PUBLICOS -------------------------------- //

    public void aumentarEnergiaConSeniority(){
        this.energia += this.seniority.aumentarEnergia();
    }

    public boolean energiaIgualA(int energia) {
        return this.energia == energia;
    }

    public boolean tieneEnergia(){
        return this.energia > SIN_ENERGIA;
    }

    public void recibirAtaque(){
        this.disminuirEnergia(this.equipamiento.recibirAtaque()); //ROMPE ENCAPSULAMIENTO
    }

    public void recibirDanio(int danio) { this.disminuirEnergia(danio); }

    public void mejorarEquipamiento(){
        this.equipamiento = this.equipamiento.mejorarEquipamiento();
    }

    public void mejorarSeniority(int turnos){
        this.seniority = this.seniority.ascender(turnos);
    }

    public void recibirEnergia(int energia) { this.aumentarEnergia(energia); }

    public boolean totalmenteEquipado(){
        return this.equipamiento.equipoCompleto();
    }

    // -------------------------------- PRIVADOS -------------------------------- //

    private void disminuirEnergia(int energia) {
        this.energia -= energia;
    }

    private void aumentarEnergia(int energia) {
        this.energia += energia;
    }
}
