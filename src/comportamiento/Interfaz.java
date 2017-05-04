/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamiento;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Interfaz {

    /**
    Método para borrar el último caracter
    @param jtf 
     */
    public static void borrarUltimoCaracter(JTextField jtf) {
        if (!jtf.getText().isEmpty()) {
            String str = jtf.getText();
            str = str.substring(0, str.length() - 1);
            jtf.setText(str);
        }
    }

    /**
    Método para deshabilitar varios elementos
    @param objs 
     */
    public static void deshabilitar(Object... objs) {
        try {
            for (Object obj : objs) {
                if (obj instanceof JButton) {
                    JButton f = (JButton) obj;
                    f.setEnabled(false);
                } else if (obj instanceof JTextField) {
                    JTextField f = (JTextField) obj;
                    f.setEnabled(false);
                } else if (obj instanceof JTextArea) {
                    JTextArea f = (JTextArea) obj;
                    f.setEnabled(false);
                } else if (obj instanceof JComboBox) {
                    JComboBox f = (JComboBox) obj;
                    f.setEnabled(false);
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public static void habilitarBoton(JTextField tf, JButton jb) {
        jb.setEnabled(false);
        try {
            if (!tf.getText().equals("")) {
                jb.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void habilitarBoton2(Container container, JButton jb) {
        try {
            for (Component c : container.getComponents()) {
                if (c instanceof JTextField) {
                    JTextField f = (JTextField) c;
                    if (f.getText().equals("")) {
                        jb.setEnabled(true);
                    } else {
                        jb.setEnabled(true);
                    }
                } else if (c instanceof Container) {
                    habilitarBoton2((Container) c, jb);
                }
            }
        } catch (Exception e) {
            
        }
    }
    
    public static boolean checarVacios(Container container) {
        boolean camposLlenos = false;
        try {
            for (Component c : container.getComponents()) {
                if (c instanceof JTextField) {
                    JTextField f = (JTextField) c;
                    if (f.getText().equals("")) {
                        camposLlenos = false;
                    } else {
                        camposLlenos = true;
                    }
                } else if (c instanceof Container) {
                    checarVacios((Container) c);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return camposLlenos;
    }
    
    public static boolean camposLlenos(Object... objs) {
        boolean camposLlenos = true;
        for (Object obj : objs) {
            if (obj instanceof JTextField) {
                JTextField j = (JTextField) obj;
                if (j.getText().equals("")) {
                    camposLlenos = false;
                } else {
                    camposLlenos = true;
                }
            }
        }
        boolean campos2 = camposLlenos;
        return campos2;
    }
    
    public static void cambia(Object obj) {
        if (obj instanceof JTextField) {
            JTextField j = (JTextField) obj;
            selecciona(j);
            j.setForeground(Color.black);
            j.requestFocus();
        } else if (obj instanceof JButton) {
            JButton j = (JButton) obj;
            j.requestFocus();
        } else if (obj instanceof JComboBox) {
            JComboBox j = (JComboBox) obj;
            j.requestFocus();
        }
    }
    
    public static void selecciona(JTextField jt) {
        jt.setSelectionStart(0);
        jt.setSelectionEnd(jt.getText().length());
    }
    
    public static void etiqueta(Object... objs) {
        try {
            for (int i = 0; i < objs.length; i += 2) {
                JTextField j = (JTextField) objs[i];
                String s = (String) objs[i + 1];
                j.setForeground(Color.gray);
                j.setText(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void limpiarElementos(Object... objs) {
        try {
            for (Object obj : objs) {
                if (obj instanceof JTextField) {
                    ((JTextField) obj).setText("");
                } else if (obj instanceof JTextArea) {
                    ((JTextArea) obj).setText("");
                } else if (obj instanceof JComboBox) {
                    ((JComboBox) obj).setSelectedIndex(0);
                } else if (obj instanceof JRadioButton) {
                    ((JRadioButton) obj).setSelected(false);
                } else if (obj instanceof JCheckBox) {
                    ((JCheckBox) obj).setSelected(false);
                } else if (obj instanceof ButtonGroup) {
                    ((ButtonGroup) obj).clearSelection();
                } else if (obj instanceof JButton) {
                    ((JButton) obj).setEnabled(false);
                } else if (obj instanceof JTable) {
                    ((JTable) obj).setModel(new DefaultTableModel());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    Método para limpiar elementos de la interfaz (JTextField, JTextArea, JComboBox)
    @param container 
     */
    public static void limpiar(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) {
                JTextField f = (JTextField) c;
                f.setText("");
            } else if (c instanceof JTextArea) {
                JTextArea f = (JTextArea) c;
                f.setText("");
            } else if (c instanceof JComboBox) {
                JComboBox f = (JComboBox) c;
                f.setSelectedIndex(0);
            } else if (c instanceof Container) {
                limpiar((Container) c);
            }
        }
    }
    
}
