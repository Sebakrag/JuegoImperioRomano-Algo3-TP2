package edu.fiuba.algo3.modelo;


public abstract class Celda {
    protected Celda siguiente;
    protected int x;
    protected int y;
    protected Afectante afectante;

    public void afectar(Jugador jugador){
        this.afectante.afectar(jugador);
    }

    public boolean tieneCoordenadas(int x, int y){
        return ((this.x == x) && (this.y == y));
    }

    public Celda celdaSiguiente(){
        return this.siguiente;
    }

    public void setSiguiente(Celda siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean esCeldaFinal();
}
