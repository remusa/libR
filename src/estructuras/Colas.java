/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class Colas {

    Nodo[] cola;
    int a = -1;

    public Colas(int n) {
        cola = new Nodo[n];
    }

    public void inserta(Nodo d) {
        if (a == cola.length - 1) {
            System.out.println("Cola llena");
        } else {
            cola[++a] = d;
        }
    }

    public Nodo elimina() {
        Nodo aux = null;
        if (a == -1) {
            System.out.println("Cola vacia");
        } else {
            aux = cola[0];
            for (int i = 0; i < a; i++) {
                cola[i] = cola[i + 1];
            }
            a--;
        }
        return aux;
    }

}
