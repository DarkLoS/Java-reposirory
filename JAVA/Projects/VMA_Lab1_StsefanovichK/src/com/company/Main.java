package com.company;
public class Main {
    public static LinearEquations generateSystem(){
        LinearEquations list = new LinearEquations();
        int i;
        for (i = 0; i < WIDTH; i++){
            MyEquation eq = new MyEquation();
            eq.generate(i,HEIGHT + 1);
            list.push(eq);
        }
        return list;
    }
    public static LinearEquations generateSystem2(LinearEquations l){
        LinearEquations list = new LinearEquations();
        int i;
        for (i = 0; i < WIDTH; i++){
            MyEquation eq = new MyEquation();
            eq.generate2(i,l);
            list.push(eq);
        }
        return list;
    }
    public static void printSystem(LinearEquations system){
        for (int i = 0; i < system.size(); i++){
            MyEquation temp = system.get(i);
            String s = "";
            for (int j = 0; j < temp.size(); j++){
                s += String.format("%.4f; %s", system.itemAt(i, j), "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }
    public static void printMatrix(Float[][] x){
        for (int i = 0; i < x.length; i++){
            String s = "";
            for (int j = 0; j < x[i].length; j++){
                s += String.format("%.4e; %s", x[i][j], "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }
    public static  Float[][] MatrixMultiplection(Float[][] mA,Float[][] mB) {
        int m = mA.length;
        int n = mB[0].length;
        int o = mB.length;
        Float[][] res = new Float[m][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j]=0.0f;
            }
            }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }
        return res;
    }
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    public static void main(String args[]){
        LinearEquations list = generateSystem();
        LinearEquations copy = generateSystem();
        System.out.println("Matrix:");
        printSystem(list);
        LinearEquations list2 = generateSystem2(list);
        Algorithm alg = new Algorithm(list);
        Float [][]x;
        x= alg.calculate((WIDTH-1)+1);
        System.out.println("Determinate:");
        System.out.println(alg.determinate);
        System.out.println();
        System.out.println("Vector:");
        printMatrix(x);
        System.out.println("Invertible matrix:");
        Algorithm alg2 = new Algorithm(list2);
        Float [][]x2;
        x2=alg2.calculate((2*WIDTH-1));
        printMatrix(x2);
        Float [][]res=MatrixMultiplection(copy.toArray(),x);
        for(int i=0;i<5;i++)
              res[i][0]-=copy.itemAt(i,copy.size());
        System.out.println("AX-B:");
        printMatrix(res);
        Float [][]res2=MatrixMultiplection(copy.toArray(),x2);
        System.out.println("A*A^(-1):");
        printMatrix(res2);
    }
}
