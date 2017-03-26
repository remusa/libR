/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class Nodo {

    private int cve;
    private Object obj;
    private Nodo sig;
    private Nodo abj;

    public Nodo(int d, Object obj) {
        this.cve = d;
        this.obj = obj;
        sig = null;
        abj = null;
    }

    /**
     * @return the cve
     */
    public int getCve() {
        return cve;
    }

    /**
     * @param cve the cve to set
     */
    public void setCve(int cve) {
        this.cve = cve;
    }

    /**
     * @return the sig
     */
    public Nodo getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig) {
        this.sig = sig;
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
     * @return the abj
     */
    public Nodo getAbj() {
        return abj;
    }

    /**
     * @param abj the abj to set
     */
    public void setAbj(Nodo abj) {
        this.abj = abj;
    }

}
