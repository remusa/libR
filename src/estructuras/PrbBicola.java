/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq.poo.edd;

/**
 *
 * @author Mauro
 */
public class PrbBicola {

    public static void main(String[] args) {
        String s1 = "mauro";
        NodoArb n1 = new NodoArb(5, s1); //5 es la clave para buscar
        String s2 = "oruam";
        NodoArb n2 = new NodoArb(2, s2);
        String s3 = "amoru";
        NodoArb n3 = new NodoArb(4, s3);
        String s4 = "morua";
        NodoArb n4 = new NodoArb(3, s4);
        String s5 = "uroma";
        NodoArb n5 = new NodoArb(1, s5);
        
        Arboles a = new Arboles(); //a es la raíz del árbol
        
        a.setR(a.insertaArb(a.getR(), n1)); //se crea el árbol
        a.setR(a.insertaArb(a.getR(), n2));
        a.setR(a.insertaArb(a.getR(), n3));
        a.setR(a.insertaArb(a.getR(), n4));
        a.setR(a.insertaArb(a.getR(), n5));
        
        //Recorridos
        a.preorden(a.getR());
        a.enorden(a.getR());
        a.postorden(a.getR());
        
//        int [] elim;

//      Bicola obj= new Bicola(5);
//      obj.setA1(obj.inserta(1, obj.getA1(), obj.getA2(), 1));
//      obj.setA1(obj.inserta(3, obj.getA1(), obj.getA2(), 1));
//      obj.setA2(obj.inserta(10, obj.getA2(), obj.getA1(), -1));
//      obj.setA2(obj.inserta(12, obj.getA2(), obj.getA1(), -1));
//      obj.desp(-1,obj.getA1(), -1);
//      obj.desp(obj.lnBicola(),obj.getA2(), 1);
//      elim=obj.elimina(-1, obj.getA1(), 1);
//        System.out.println("Dato eliminado="+elim[0]);
//        obj.setA1(elim[1]);
//      System.out.println("a="+obj.getA1());
//      elim=obj.elimina(-1, obj.getA1(), 1);
//        System.out.println("Dato eliminado="+elim[0]);
//        obj.setA1(elim[1]);
//      System.out.println("a="+obj.getA1());
//      elim=obj.elimina(obj.lnBicola(), obj.getA2(), -1);
//        System.out.println("Dato eliminado="+elim[0]);
//        obj.setA2(elim[1]);
//      System.out.println("a="+obj.getA2());
//      elim=obj.elimina(obj.lnBicola(), obj.getA2(), -1);
//        System.out.println("Dato eliminado="+elim[0]);
//        obj.setA2(elim[1]);
//      System.out.println("a="+obj.getA2());

//        NodoArb a1=new NodoArb(2);
//        NodoArb a2=new NodoArb(1);
//        NodoArb a3=new NodoArb(6);
//        NodoArb a4=new NodoArb(7);
//        NodoArb a5=new NodoArb(5);
//        NodoArb a6=new NodoArb(3);
//        NodoArb a7=new NodoArb(4);
//        Arboles arb=new Arboles();
//        arb.setR(arb.insertaArb(arb.getR(), a1));
//        arb.setR(arb.insertaArb(arb.getR(), a2));
//        arb.setR(arb.insertaArb(arb.getR(), a3));
//        arb.setR(arb.insertaArb(arb.getR(), a4));
//        arb.setR(arb.insertaArb(arb.getR(), a5));
//        arb.setR(arb.insertaArb(arb.getR(), a6));
//        arb.setR(arb.insertaArb(arb.getR(), a7));
//        arb.enorden(arb.getR());
//        arb.setR(arb.eliminaArb(arb.getR(), 2));
//        arb.preorden(arb.getR());
        
    }

}
