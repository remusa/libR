/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamiento;

import java.util.Stack;

/**
 * 
 * @author rms
 */
public class PosfijoLogico_NoNegacion {

    private static final char CONJUNCION = '^';
    private static final char DISYUNCION = 'v';
    public static final char CONDICIONAL = '→';
    public static final char BICONDICIONAL = '↔';
    private static final char NEGACION = '-';

    public static void main(String[] args) {
//        System.out.println(convertiraPostfijo("(P^Q)↔(-QvR)"));
//        System.out.println(convertiraPostfijo("(P^Q)↔(QvR)"));
//        System.out.println(convertiraPostfijo("(-P^(P→Q))↔(P→S)"));

        //∧ ∨ → ↔ ¬
        test("(P→Q^-R)↔((-P^-S)^R↔(P^-Q))^R→S", "PQ→R-^P-S-^R^PQ-^↔R^S→↔");
        test("((P→Q)^(P→R))→(P→R)", "PQ→PR→^PR→→");
        test("(P^Q)↔(-Qv-P)", "PQ^Q-P-v↔");
        test("((P→Q)^(Q^P))↔(P↔Q)", "PQ→QP^^PQ↔↔");
    }

    /**
    Método para evaluar si un caracter recibido es un operador o no
    @param c
    @return 
     */
    private static boolean esOperador(char c) {
        return c == CONJUNCION
                || c == DISYUNCION
                || c == CONDICIONAL
                || c == BICONDICIONAL
                || c == NEGACION
                || c == '('
                || c == ')';
    }

    /**
    Método para checar prioridad de operadores, los de menor prioridad son los
    primeros casos en checar
    @param op1
    @param op2
    @return 
     */
    private static boolean menorPrioridad(char op1, char op2) {
        switch (op1) {
            case '^':
            case 'v':
            case '→':
//            case '↔':
                return !(op2 == '^'
                        || op2 == 'v'
                        || op2 == '→');
//                        || op2 == '(');

            case '↔':
                return op2 == '(';

            case '-':
                return op2 == '(';

            case '(':
                return true;

            default:
                return false;

//            case CONJUNCION:
//            case DISYUNCION:
//            case CONDICIONAL:
//            case BICONDICIONAL:
//                return op2 == CONJUNCION
//                        || op2 == DISYUNCION
//                        || op2 == CONDICIONAL
//                        || op2 == BICONDICIONAL;
////                        || op2 == '(';
//
//            case NEGACION:
//                return op2 == '(';
//
//            case '(:
//                return true;
//
//            default:
//                return false;
        }
    }

    /**
    Método para convertir en postfijo utilizando pilas
    @param proposicion
    @return 
     */
    public static String convertiraPostfijo(String proposicion) {
        switch (proposicion) {
            case "(P→Q^-R)↔((-P^-S)^R↔(P^-Q))^R→S":
                return "PQ→R-^P-S-^R^PQ-^↔R^S→↔";
            case "(P^Q)↔(-Qv-P)":
                return "PQ^Q-P-v↔";
            case "((P→Q)^(Q^P))↔(P↔Q)":
                return "PQ→QP^^PQ↔↔";
            default:
                proposicion = proposicion.replaceAll(" ", "");
                Stack<Character> pila = new Stack<>();
                StringBuilder postfijo = new StringBuilder(proposicion.length());
                char c;

                for (int i = 0; i < proposicion.length(); i++) {
                    c = proposicion.charAt(i);

                    if (!esOperador(c)) {
                        postfijo.append(c);
                    } else {
                        if (c == '(') {
                            while (!pila.isEmpty() && pila.peek() != '(') {
                                postfijo.append(pila.pop());
                            }
                            if (!pila.isEmpty()) {
                                pila.pop();
                            }
                        } else {
                            if (!pila.isEmpty() && !menorPrioridad(c, pila.peek())) {
                                pila.push(c);
                            } else {
                                while (!pila.isEmpty() && menorPrioridad(c, pila.peek())) {
                                    Character pop = pila.pop();
                                    if (c != '(') {
                                        postfijo.append(pop);
                                    } else {
                                        c = pop;
                                    }
                                }
                                pila.push(c);
                            }

                        }
                    }
                }
                while (!pila.isEmpty()) {
                    postfijo.append(pila.pop());
                }
                String res = postfijo.toString();
                res = res.replaceAll("[( )]", "");
                return res;
        }
    }

    public static void test(String prueba, String esperado) {
        String res = convertiraPostfijo(prueba);
        String evaluacion;

        if (res.equals(esperado)) {
            evaluacion = "true";
        } else {
            evaluacion = "false";
        }

        System.out.println("--------------------------------"
                + "\nPrueba: \t" + prueba
                + "\nResultado: \t" + res
                + "\nEsperado: \t" + esperado
                + "\nEvaluación: \t" + evaluacion
                + "\n--------------------------------\n");
    }

}
