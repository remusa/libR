/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamiento;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class Validaciones {

    Pattern pattern;
    Matcher matcher;

    /**
    Valida correo mediante una expresión regular
    @param correo
    @return 
     */
    public boolean validaCorreo(String correo) {
        boolean valido = false;
        pattern = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z]+(.com|.net|.org)");
        matcher = pattern.matcher(correo.toLowerCase());
        if (matcher.matches()) {
            valido = true;
        }
        return valido;
    }

    public static void rfc(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() <= length) {
            validarRFC(jtf.getText());
        } else {
            evt.consume();
        }
    }

    /**
    Valida RFC mediante una expresión regular (máximo 13 caracteres)
    @param rfc
    @return 
     */
    public static boolean validarRFC(String rfc) {
        rfc = rfc.toUpperCase().trim();
        return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
    }

    /**
    Valida CURP mediante una expresión regular
    @param curp
    @return 
     */
    public static boolean validarCURP(String curp) {
        curp = curp.toUpperCase().trim();
        return curp.matches("[A-Z]{4}[0-9]{6}[H,M][A-Z]{5}[0-9]{2}");
    }

    private static boolean validarCURP2(String curp) {
        String regex
                = "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}"
                + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
                + "[HM]{1}"
                + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
                + "[B-DF-HJ-NP-TV-Z]{3}"
                + "[0-9A-Z]{1}[0-9]{1}$";
        Pattern patron = Pattern.compile(regex);
        if (!patron.matcher(curp).matches()) {
            return false;
        } else {
            return true;
        }
    }

    /**
    Valida número de credencial mediante una expresión regular
    @param numCrede
    @return 
     */
    public static boolean validarNumCredencial(String numCrede) {
        numCrede = numCrede.toUpperCase().trim();
        return numCrede.matches("[A-Za-z]{6}[0-9]{8}[H,M][0-9]{3}");
    }

    /**
    @param evt  Evento
    @param l    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void entero(KeyEvent evt, int l, JTextField jtf) {
        if (jtf.getText().length() < l) {
            if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8) {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param l    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void enteroNegativo(KeyEvent evt, int l, JTextField jtf) {
        if (jtf.getText().length() < l) {
            if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8 && evt.getKeyChar() != '-') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void alfabetico(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z')
                    && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z')
                    && evt.getKeyCode() != 8 && evt.getKeyChar() != ' '
                    && evt.getKeyChar() != 'á' && evt.getKeyChar() != 'Á'
                    && evt.getKeyChar() != 'é' && evt.getKeyChar() != 'É'
                    && evt.getKeyChar() != 'í' && evt.getKeyChar() != 'Í'
                    && evt.getKeyChar() != 'ó' && evt.getKeyChar() != 'Ó'
                    && evt.getKeyChar() != 'ú' && evt.getKeyChar() != 'Ú'
                    && evt.getKeyChar() != 'ñ' && evt.getKeyChar() != 'Ñ') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     * @param init
     * @param fin
     */
    public static void alfabeticoMayusculas(KeyEvent evt, int length, JTextField jtf, char init, char fin) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < init 
                    || evt.getKeyChar() > fin)) {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void alfanumerico(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z')
                    && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z')
                    && (evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8
                    && evt.getKeyChar() != 'ñ' && evt.getKeyChar() != 'Ñ') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void flotante(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8 && evt.getKeyChar() != '.') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void flotanteNegativo(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8 && evt.getKeyChar() != '.' && evt.getKeyChar() != '-') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void correo(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z')
                    && (evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8
                    && evt.getKeyChar() != '.' && evt.getKeyChar() != '@'
                    && evt.getKeyChar() != '_' && evt.getKeyChar() != '-') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void hora(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8 && evt.getKeyChar() != ':') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    /**
    @param evt  Evento
    @param length    Longitud máxima
    @param jtf  Nombre de la caja de texto
     */
    public static void fecha(KeyEvent evt, int length, JTextField jtf) {
        if (jtf.getText().length() < length) {
            if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                    && evt.getKeyCode() != 8 && evt.getKeyChar() != '/') {
                evt.setKeyChar((char) 8);
            }
        } else {
            evt.consume();
        }
    }

    public static boolean vFlotante(String str) {
        try {
            double x = Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean vEntero(String str) {
        try {
            double x = Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
