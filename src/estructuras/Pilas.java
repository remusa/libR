/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class Pilas {

    Nodo[] pila;
    int t = -1; //tope

    public Pilas(int n) {
        pila = new Nodo[n];
    }

    /**
    
    @param d Dato a insertar
     */
    public void inserta(Nodo d) {
        if (t == pila.length - 1) {
            System.out.println("Pila llena");
        } else {
            pila[++t] = d;
        }
    }

    public Nodo elimina() {
        Nodo aux = null;
        if (t == -1) {
            System.out.println("Pila vacia");
        } else {
            aux = pila[t];
            t--;
        }
        return aux;
    }

}
