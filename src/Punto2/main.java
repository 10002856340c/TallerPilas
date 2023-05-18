/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Punto2;

import java.util.Scanner;


public class main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        parqueadero parqueadero = new parqueadero();

        System.out.print("Ingrese la cantidad de carros en el parqueadero: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.println("Ingrese los nombres de los carros en el parqueadero:");
        for (int i = 0; i < n; i++) {
            String carro = scanner.nextLine();
            parqueadero.ingresarCarro(carro);
        }

        parqueadero.mostrarParqueadero();

        System.out.print("Ingrese el nombre del carro que desea retirar: ");
        String carroRetirar = scanner.nextLine();

        parqueadero.retirarCarro(carroRetirar);

        parqueadero.mostrarParqueadero();

        scanner.close();
    }
}
