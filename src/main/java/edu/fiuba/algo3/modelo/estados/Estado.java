package edu.fiuba.algo3.modelo.estados;

public interface Estado {

    public int avanzar(int avances);
    public Estado sanar();
    public Estado lesionar();
    public Estado reducirEnergia(int energia);
    public Estado aumentarEnergia(int energia);
}
