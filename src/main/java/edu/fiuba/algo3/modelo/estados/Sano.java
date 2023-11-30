package edu.fiuba.algo3.modelo.estados;

public class Sano implements Estado {
    
    private static final int ENERGIA_INICIAL = 20;
    private static final int SIN_ENERGIA = 0;

    private int energiaActual;

    public Sano() {
        this.energiaActual = ENERGIA_INICIAL;
    }

    public Sano(int energia) {
        this.energiaActual = energia;
    }

    public int avanzar (int avances) {
        return avances;
    }

    public Estado sanar() {
        return this;
    }

    public Estado lesionar() {
        return new Lesionado(this.energiaActual);
    }



    public Estado reducirEnergia(int energia) {
        this.energiaActual -= energia;
        if (this.energiaActual <= SIN_ENERGIA) {
            return new Cansado();
        }
        return this;
    }
    
    public Estado aumentarEnergia(int energia) {
        this.energiaActual += energia;
        return this;
    }
}
