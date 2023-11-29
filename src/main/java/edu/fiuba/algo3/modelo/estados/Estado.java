package edu.fiuba.algo3.modelo.estados;

public interface Estado {

    public int avanzar(int avances);

    public Estado sanar();
    public Estado lesionar();
    public Estado cansar(int energia);
    public int calcularEnergia(int energia);
}
