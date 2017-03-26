/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class Listas {

    private Nodo r;

    public Listas() {
        r = null;
    }

    public void insertaLista(Nodo d) {
        Nodo aux = getR();
        if (aux == null) {
            setR(d);
        } else if (aux.getCve() > d.getCve()) {
            d.setSig(aux);
            setR(d);
        } else {
            boolean b = false;
            while (aux.getSig() != null && !b) {
                if (aux.getSig().getCve() > d.getCve()) {
                    d.setSig(aux);
                    aux.setSig(d);
                    b = true;
                }
            }
            if (!b) {
                aux.setSig(d);
            }

        }

    }

    public Nodo eliminaLista(int dato) {
        Nodo aux, elim = null;
        if (getR() == null) {
            System.out.println("no hay elementos en la lista");
        } else if (getR().getCve() > dato) {
            System.out.println("Dato no encontrado");
        } else {
            elim = aux = getR();
            if (getR().getCve() == dato) {
                getR().setSig(aux.getSig());
            } else {
                boolean b = false;
                while (aux.getSig() != null && !b) {
                    if (aux.getSig().getCve() == dato) {
                        elim = aux.getSig();
                        b = true;
                    }
                }
                if (!b) {
                    System.out.println("dato no encontrado");
                }
            }
        }
        return elim;
    }

    /**
     * @return the r
     */
    public Nodo getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r) {
        this.r = r;
    }

}
