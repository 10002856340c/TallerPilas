
package Punto1;


public class estudiante {
    public String nombre;
    public int codigo;
    public double nota1;
    public double nota2;
    public double nota3;
    public double promedio;

    public estudiante(String nombre, int codigo, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.promedio = calcularPromedio();
    }

    private double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Código: " + codigo + "\n" +
                "Promedio: " + promedio + "\n";
    }
}
