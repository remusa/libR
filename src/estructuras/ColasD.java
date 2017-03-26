/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class ColasD {

    private Nodo a = null; //requiere un atrás para ser circular (apuntador)

    public ColasD() {   //no recibe datos porque se inicializa la cola
        a = null;
    }

    public void inserta(Nodo d) {
        if (getA() == null) {    //no hay dato por insertar, no se puede crear el nodo (sin memoria)
            System.out.println("Cola llena o no se puede insertar en null (memoria llena)");
        } else if (getA() == null) {    //primera vez que se va a insertar
            setA(d);
            getA().setSig(d);
        } else {    //ya hay datos
            d.setSig(getA().getSig()); //se conecta el que llega al siguiente de atrás
            getA().setSig(d); //se conectan los que ya están
            setA(d); //el final ahora es d
        }
    }

    public Nodo elimina() {
        Nodo aux = null;
        if (getA() == null) {    //no hay datos
            System.out.println("Cola vacia");
        } else {
            aux = getA().getSig(); //valor a eliminar (a.getSiguiente() siempre es el final)
            if (aux == getA()) { //solo hay un dato
                setA(null); //se regresa aux y se pone a como null
            } else {
                getA().setSig(aux.getSig()); //se desconectan primero los que se quedan
            }
            aux.setSig(null); //se desconecta totalmente aux
        }
        return aux;
    }

    /**
     * @return the a
     */
    public Nodo getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Nodo a) {
        this.a = a;
    }

}
