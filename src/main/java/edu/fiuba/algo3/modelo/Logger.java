package edu.fiuba.algo3.modelo;

enum Evento {
    Comida,
    Equipamiento,
    Bacanal,
    Fiera,
    Lesion,
    NoEnergia,
    Ganar,
}

//falta crear un caso para cada equipamiento zzzzzzzz agregar mas info pasarle como energia actual , se deberia pasar el gladiador y aca se ve que info se usa del objeto

public class Logger {
    //public static void imprimir(Jugador jugador, Comida comida, Integer pasos) {
    //     System.out.println("Gladiador" + jugador.nombre() + "avanza" + pasos +  ", se ha encontrado una comida se incrementa" + comida.getAumento() +"puntos, energia (x)\n");
    //     break;
   // }

    public static void imprimir(String nombreGladiador, Evento evento, Integer pasos){
        switch (evento){
            case Comida:
                System.out.println("Gladiador" + nombreGladiador + "avanza" + pasos +  ", se ha encontrado una comida se incrementa 15 puntos, energia (x)\n");
                break;
            case Equipamiento:
                System.out.println("Gladiador" + nombreGladiador + "avanza" + pasos +  "encuentra un premio y recibe casco en casilla (x,y)\n");
                break;
            case Bacanal:
                System.out.println("Gladiador" + nombreGladiador +  "avanza" + pasos +  "saca 4 puntos de energía por cada trago tomado\n ");
                break;
            case Fiera:
                System.out.println("Gladiador" + nombreGladiador + "avanza" + pasos +  "es atacado por un animal en casilla (X,Y) y pierde energía 10\n");
                break;
            case Lesion:
                System.out.println("Gladiador" + nombreGladiador + "avanza" + pasos +  "El gladiador se enoja con la vida, patea una piedra y debe esperar un turno sin avanzar");
                break;
            case NoEnergia:
                System.out.println("Gladiador" + nombreGladiador + "avanza" + pasos +  " no tiene energía (x) y pasa turno");
                break;
            case Ganar:
                System.out.println("Jugador" + nombreGladiador + " Gana la Partida\n");
                break;
            default:
                System.out.println("No se reconocio la accion");
        }
    }
}
