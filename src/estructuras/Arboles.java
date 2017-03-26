/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class Arboles {

    private NodoArb r;

    public Arboles() {
        r = null;
    }

    /**
    
    @param r Nodo raíz
    @param d Nodo a insertar
    @return 
     */
    public NodoArb insertaArb(NodoArb r, NodoArb d) {
        if (r == null) {
            return d;
        } else {
            if (r.getD() > d.getD()) {
                r.setIzq(insertaArb(r.getIzq(), d));
            } else {
                r.setDer(insertaArb(r.getDer(), d));
            }
            return r;
        }
    }

    /**
    
    @param r Nodo raíz
    @param dato
    @return 
     */
    public NodoArb[] eliminaArb(NodoArb r, int dato) {
        NodoArb tmp[] = {null, r};   //dato a eliminar y la nueva r
        NodoArb se = null;

        if (r != null) {
            if (dato == r.getD()) {
                if (r.getDer() == null && r.getIzq() == null) {
                    tmp[0] = r;       //dato a eliminar es la raíz
                    tmp[1] = null;    //si no tiene hijo la raíz del nodo se vuelve null (posición 1) -> nueva r
                    return tmp;
                } else if (r.getDer() == null || r.getIzq() == null) {  //si tiene un hijo
                    tmp[0] = r; //dato a eliminar
                    if (r.getDer() == null) {
                        tmp[1] = r.getIzq(); //nueva r
                    } else {
                        tmp[1] = r.getDer();
                    }
                } else {    //2 hijos
                    tmp[0] = r; //r se elimina en ambos casos
                    if (r.getDer().getIzq() == null) {  //sucesor en orden, derecha y luego a la izquierda, izq es nulo
                        se = r.getDer();
                        se.setIzq(r.getIzq());
                        r.setDer(null);
                        r.setIzq(null);
                    } else {
                        se = sucesor(r.getDer());
                        se.setDer(r.getDer());
                        se.setIzq(r.getIzq());
                        r.setDer(null);
                        r.setIzq(null);
                    }
                    tmp[1] = se;
                    
                }
                return tmp;
            } else {    //recursividad
                NodoArb loc[];
                if (r.getD() > dato) {
                    loc = eliminaArb(r.getIzq(), dato); //cambia por lo que regrese
                    r.setIzq(loc[1]); //posición de la nueva r
                } else {
                    loc = eliminaArb(r.getDer(), dato);
                    r.setDer(loc[1]);
                }
                loc[1] = r; //desconexión
                return loc;
            }
        } else {
            System.out.println("No se encontro el dato o no hay elementos");
            return tmp;
        }
    }

    /**
    Recorre hacía la izquierda hasta llegar al penúltimo
    @param r
    @return 
     */
    public NodoArb sucesor(NodoArb r) {
        if (r.getIzq().getIzq() == null) {
            NodoArb tmp = r.getIzq();
            r.setIzq(tmp.getDer());
            tmp.setDer(null);
            return tmp;
        } else {
            return sucesor(r.getIzq());
        }
    }

    /**
     * @return the r
     */
    public NodoArb getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArb r) {
        this.r = r;
    }

    public void enorden(NodoArb r) {
        if (r != null) {
            enorden(r.getIzq());
            System.out.println(r.getD());
            enorden(r.getDer());
        }
    }

    public void preorden(NodoArb r) {
        if (r != null) {
            System.out.println(r.getD());
            preorden(r.getIzq());
            preorden(r.getDer());
        }
    }

    public void postorden(NodoArb r) {
        if (r != null) {
            postorden(r.getIzq());
            postorden(r.getDer());
            System.out.println(r.getD());
        }
    }

}
