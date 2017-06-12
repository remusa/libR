/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamiento;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author MSS
 */
public class Mensajes {

    public static void exito(JFrame jf) {
        JOptionPane.showMessageDialog(jf, "La acción solicitada se ha realizado con éxito");
    }

    public static void falla(JFrame jf) {
        JOptionPane.showMessageDialog(jf, "La acción solicitada no se pudo concretar, verifique por favor");
    }
    
    public static void mensajes(JFrame jf, String s) {
        JOptionPane.showMessageDialog(jf, s);
    }

    public static void falla(JFrame jf, String s) {
        JOptionPane.showMessageDialog(jf, s);
    }

    public static int consulta(JFrame jf, String s) {
        return JOptionPane.showConfirmDialog(jf, s);
    }

    public static int mensaje(JFrame jf, String s) {
        return JOptionPane.showConfirmDialog(jf, s);
    }

    public static int preguntarPago(JFrame ventana, JRootPane rootPane, String cadena, String op1, String op2) {
        int eleccion;
        Object[] opciones = {op1, op2};

        eleccion = JOptionPane.showOptionDialog(rootPane, cadena, "Mensaje de tipo de pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            eleccion = 1;
        } else {
            eleccion = 2;
        }
        return eleccion;
    }

}
