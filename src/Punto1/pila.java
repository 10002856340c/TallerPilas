
package Punto1;


public class pila {
    public nodo cabeza;

    public void agregar(estudiante estudiante) {
        if (cabeza == null) {
            cabeza = new nodo();
            cabeza.estudiante = estudiante;
        } else {
            nodo nuevo = new nodo();
            nuevo.estudiante = estudiante;
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }
public estudiante atender() {
        if (cabeza != null) {
            nodo temp = cabeza;
            cabeza = cabeza.siguiente;
            temp.siguiente = null;
            return temp.estudiante;
        }
        return null;
    }

    public void listar() {
        nodo rec = cabeza;
        System.out.println("La pila está conformada por:");
        while (rec != null) {
            System.out.println(rec.estudiante);
            rec = rec.siguiente;
        }
    }
}