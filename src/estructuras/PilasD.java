/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class PilasD {

    Nodo[] pila;
    Nodo t; //tope

    public PilasD() {
        t = null;
    }

    /**
    
    @param d Dato a insertar
     */
    public void inserta(Nodo d) {
        if (d == null) {    //dato a insertar es nulo, nada que insertar
            System.out.println("No se puede insertar un nulo");
        } else {
            if (t != null) {    //si el tope no es nulo
                t = d;
            }
            t = d;
        }
    }

    public Nodo elimina() {
        Nodo aux = null;
        if (t == null) {
            System.out.println("Pila vacia");
        } else {
            aux = t;
            t = aux.getSig();
        }
        return aux;
    }

}
