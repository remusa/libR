/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class Bicola {

    Nodo[] bicola;
    private int a1 = -1;
    private int a2;

    public Bicola(int n) {
        bicola = new Nodo[n];   //arreglo para saber de cuántas posiciones va a ser la bicola
        a2 = n;
    }

    /**
    
    @param d Dato a insertar
    @param a Posición de atrás
    @param n Límite del atrás por ambos lados
    @param f Factor
    @return 
     */
    public int inserta(Nodo d, int a, int n, int f) {
        if (a + f == n) {
            System.out.println("cola llena");
        } else {
            a += f;
            bicola[a] = d;
        }
        return a;
    }

    /**
    
    @param l Límite
    @param a
    @param f
    @return 
     */
    public Object[] elimina(int l, Integer a, int f) { //al cambiar la posición del atrás se debe saber su posición
        Object[] aux = {null, a}; //null porque lleva un objeto (nodo)
        if (a == l) { //-1 o n, dependiendo del lado
            System.out.println("cola vacia");
        } else { //en la posición del arreglo tipo object
            aux[0] = bicola[l + f]; //frente siempre es 0 o n-1
            for (int i = l + f; i != a; i += f) {
                bicola[i] = bicola[i + f];
            }
            a -= f; //-(-f) =+1; -(-1)=+1
        }
        aux[1] = a; //valor que se debe conocer (cuál de las 2 a cambio de posición)
        return aux;
    }

    public int lnBicola() {
        return bicola.length;
    }

    public void desp(int l, int a, int f) {
        int j = 1;
        for (int i = l - f; i != a - f; i -= f) {
            System.out.println("bicola[" + (j) + "]=" + bicola[i]);
            j++;
        }
    }

    /**
     * @return the a1
     */
    public int getA1() {
        return a1;
    }

    /**
     * @param a1 the a1 to set
     */
    public void setA1(int a1) {
        this.a1 = a1;
    }

    /**
     * @return the a2
     */
    public int getA2() {
        return a2;
    }

    /**
     * @param a2 the a2 to set
     */
    public void setA2(int a2) {
        this.a2 = a2;
    }

}
