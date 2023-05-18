
package Punto1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        pila pila = new pila();
        Scanner scanner = new Scanner(System.in);

        ingresarEstudiantes(scanner, pila);

        double promedioTotal = calcularPromedioTotal(pila);

        guardarResultados("resultados_inicial.txt", pila, promedioTotal);

        pila atendidos = atenderEstudiantes(pila, 3);

        guardarResultados("resultados_restantes.txt", pila, promedioTotal);

        pila.listar();

        scanner.close();
    }

    public static void ingresarEstudiantes(Scanner scanner, pila pila) {
        System.out.println("Ingrese los datos de los estudiantes:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Estudiante " + i);
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            System.out.print("Nota 1: ");
            double nota1 = scanner.nextDouble();
            System.out.print("Nota 2: ");
            double nota2 = scanner.nextDouble();
            System.out.print("Nota 3: ");
            double nota3 = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer de entrada

            estudiante estudiante = new estudiante(nombre, codigo, nota1, nota2, nota3);
            pila.agregar(estudiante);
            System.out.println("Estudiante agregado correctamente.\n");
        }
    }

    public static double calcularPromedioTotal(pila pila) {
        nodo rec = pila.cabeza;
        double sumaPromedios = 0;
        int contador = 0;
        while (rec != null) {
            sumaPromedios += rec.estudiante.promedio;
            contador++;
            rec = rec.siguiente;
        }
        return sumaPromedios / contador;
    }

    public static void guardarResultados(String archivo, pila pila, double promedioTotal) {
        try {
            FileWriter writer = new FileWriter(archivo);
            writer.write("Promedio total del grupo: " + promedioTotal + "\n\n");
            nodo rec = pila.cabeza;
            while (rec != null) {
                writer.write(rec.estudiante.toString());
                rec = rec.siguiente;
            }
            writer.close();
            System.out.println("Resultados guardados en el archivo '" + archivo + "' correctamente.\n");
        } catch (IOException e) {
            System.out.println("Error al guardar los resultados en el archivo '" + archivo + "'.");
            e.printStackTrace();
        }
    }

    public static pila atenderEstudiantes(pila pila, int cantidad) {
        pila atendidos = new pila();
        for (int i = 0; i < cantidad; i++) {
            estudiante estudiante = pila.atender();
            if (estudiante != null) {
                atendidos.agregar(estudiante);
            }
        }
        return atendidos;
    }
}
       
       

