/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class NodoArb {

    private int d;
    private Object obj;
    private NodoArb izq;
    private NodoArb der;

    public NodoArb(int d, Object obj) {
        this.d = d;
        this.obj = obj;
        izq = null;
        der = null;
    }

    /**
     * @return the d
     */
    public int getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * @return the izq
     */
    public NodoArb getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoArb izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoArb getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoArb der) {
        this.der = der;
    }

}
