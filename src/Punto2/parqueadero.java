
package Punto2;

import java.util.Scanner;


public class parqueadero {
    private Nodo entrada;
    private Nodo salida;

    public void ingresarCarro(String nombre) {
        Nodo nuevoCarro = new Nodo(nombre);
        if (entrada == null) {
            entrada = nuevoCarro;
            salida = nuevoCarro;
        } else {
            salida.siguiente = nuevoCarro;
            salida = nuevoCarro;
        }
    }

    public void mostrarParqueadero() {
        Nodo actual = entrada;
        System.out.println("Parqueadero actual:");
        while (actual != null) {
            System.out.println(actual.nombre);
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void retirarCarro(String nombre) {
        Nodo actual = entrada;
        Nodo anterior = null;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                if (actual == entrada) {
                    entrada = actual.siguiente;
                    if (entrada == null) {
                        salida = null;
                    }
                } else if (actual == salida) {
                    salida = anterior;
                    salida.siguiente = null;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                System.out.println("Carro retirado correctamente.");
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        System.out.println("El carro ingresado no se encuentra en el parqueadero.");
    }

   
}