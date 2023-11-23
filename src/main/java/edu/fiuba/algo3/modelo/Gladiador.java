package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.seniorities.Novato;
import edu.fiuba.algo3.modelo.equipamientos.Desequipado;
import edu.fiuba.algo3.modelo.afectantes.*;

public class Gladiador extends Personaje {
    //Declaramos constantes ?
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;

    //private int energia;
    //private Seniority seniority;
    //private Equipamiento equipamiento;

    public Gladiador() {
        this.energia = ENERGIA_INICIAL;
        this.seniority = new Novato();
        this.equipamiento = new Desequipado();
    }

    // -------------------------------- PUBLICOS -------------------------------- //

    public void aumentarEnergia() {
        this.energia += this.seniority.aumentarEnergia();
    }

    public boolean energiaIgualA(int energia) {
        return this.energia == energia;
    }

    public boolean tieneEnergia() {
        return this.energia > SIN_ENERGIA;
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
        // PROBLEMA con la propuesta de cambio:
        // Aqui el Jugador en el siguiente turno no avanza.
        // Esta logica quizas es conveniente que este en Jugador por el hecho de que un
        // jugador tiene la cantidad de turnos.
    }

    public void recibirImpacto(Comida comida) {      // Este metodo reemplaza el metodo 'recibirEnergia()' de Gladiador
        this.energia = comida.calcularEnergia(this.energia);
    }

    public void recibirImpacto(Potenciador potenciador) {
        this.equipamiento = this.equipamiento.mejorarEquipamiento();
    }

    public void recibirImpacto(Vacio vacio) {
        //no hace nada;)
    }

    /*
    public void recibirImpacto(Afectante afectante){
        afectante.afectar(this);
    }
*/

}

 /*
    interface recibirImparto{
        recibirImpacto()
    }

    class VacioImpacto extends recibirImpacto {

    }
    */
