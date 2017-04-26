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

/**
 * 
 * @author rms
 */
public class PostfijoAritmetico {
    
    public static void main(String[] args) {
        System.out.println(convertiraPostfijo("(x*1-y/y+x+0+y/1+(x-(x-0)*1)/1+w)+(x+3*y)/(x+3*y)"));
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
                || c == '(' || c == ')';
    }

    private static boolean menorPrioridad(char op1, char op2) {
        switch (op1) {
            case '+':
            case '-':
                return !(op2 == '+' || op2 == '-');

            case '*':
            case '/':
                return op2 == '^' || op2 == '(';

            case '^':
                return op2 == '(';

            case '(':
                return true;

            default:
                return false;
        }
    }

    public static String convertiraPostfijo(String proposicion) {
        proposicion = proposicion.replaceAll(" ", "");
        Stack<Character> pila = new Stack<>();
        StringBuilder postfijo = new StringBuilder(proposicion.length());
        char c;

        for (int i = 0; i < proposicion.length(); i++) {
            c = proposicion.charAt(i);

            if (!esOperador(c)) {
                postfijo.append(c);
            } else {
                if (c == ')') {

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
        return postfijo.toString();
    }

}

