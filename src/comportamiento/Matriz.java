/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamiento;

/**
 * 
 * @author rms
 */
public class Matriz {

    /**
    Método para imprimir matriz de doubles
    @param matriz 
     */
    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j] + " ");
                System.out.printf("%.1f\t", matriz[i][j]); //número de decimales
            }
            System.out.println();
        }
    }

    /**
    Método para imprimir matriz de integers
    @param matriz 
     */
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {   //recorremos filas
            for (int j = 0; j < matriz[i].length; j++) {    //recorremos columnas
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    /**
    Método para ordenar matriz de 3 renglones por diagonal principal
    @param m
    @return 
     */
    public static double[][] ordenarMatriz(double[][] m) {
        double[][] matrizAux = m;

//        System.out.println("Filas: " + matrizAux.length);   //filas
//        System.out.println("Columnas: " + matrizAux[0].length); //columnas
//        double[] renglon1 = matrizAux[0];
//        double[] renglon2 = matrizAux[1];
//        double[] renglon3 = matrizAux[2];
//        java.util.Arrays.sort(matrizAux, java.util.Comparator.<double[]>comparingDouble(a -> a[2]).thenComparingDouble(a -> a[1]).thenComparingDouble(a -> a[0]));
//        java.util.Arrays.sort(matrizAux, java.util.Comparator.<double[]>comparingDouble(a -> a[2]));
        //ponemos coeficiente más grande de x en la primera columna
//        for (int i = 0; i < matrizAux.length; i++) { //recorremos filas para encontrar coeficiente más grande de x
//            if (m[i+1][0] > m[i][0]) {
//                renglon1 = matrizAux[i+1];
//            } else {
//                renglon1 = matrizAux[i];
//            }
////            matrizAux[0] = renglon1;
//        }

        //ordenar x
        int renglonMayor = encontrarMayor(matrizAux, 0, matrizAux[0][0]);
        double[] renglon = matrizAux[0];
        matrizAux[0] = matrizAux[renglonMayor];
        matrizAux[renglonMayor] = renglon;

        //ordenar y
        int renglonMayor2 = encontrarMayor(matrizAux, 1, matrizAux[1][1]);
        double[] renglon2 = matrizAux[1];
        matrizAux[1] = matrizAux[renglonMayor2];
        matrizAux[renglonMayor2] = renglon2;

        return matrizAux;
    }

    /**
    Método para encontrar valor mayor y ordenar matriz
     * @param matriz
     * @param renglonMayor
     * @param numeroMayor
    @return 
     */
    public static int encontrarMayor(double matriz[][], int renglonMayor, double numeroMayor) {
//        int renglonMayor = 0;
//        double numeroMayor = matriz[0][0];

        for (int i = renglonMayor; i < matriz.length; i++) { //recorrer filas
            if (matriz[i][renglonMayor] > numeroMayor) {
                numeroMayor = matriz[i][renglonMayor];
                renglonMayor = i;
            }
        }
        return renglonMayor;
    }

//    public static int encontrarMayor(double matriz[][]) {
//        int renglonMayor = 0;
//        double numeroMayor = matriz[0][0];
//
//        for (int i = 0; i < matriz.length; i++) { //recorrer filas
//            if (matriz[i][0] > numeroMayor) {
//                numeroMayor = matriz[i][0];
//                renglonMayor = i;
//            }
//        }
//        return renglonMayor;
//    }
}
