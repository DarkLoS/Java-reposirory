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
                s += String.format("%f; %s", system.itemAt(i, j), "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }
    public static void printInvert(LinearEquations system){
        for (int i = 0; i < system.size(); i++){
            MyEquation temp = system.get(i);
            String s = "";
            for (int j = temp.size()/2; j < temp.size(); j++){
                s += String.format("%f; %s", system.itemAt(i, j), "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }
    public static void printVector(Float [] x){
        String s = "";
        for (int i = 0; i < x.length; i++){
            s += String.format("x%d = %f; ", i, x[i]);
        }System.out.println(s);
    }
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    public static void main(String args[]){
        LinearEquations list = generateSystem();
        LinearEquations copy = generateSystem();
        System.out.println("Matrix:");
        printSystem(list);
        LinearEquations list2 = generateSystem2(list);


        int i, j;
        double[][] test = new double[WIDTH][HEIGHT];
        for(i=0;i<WIDTH;i++)
            for(j=0;j<HEIGHT;j++)
            {
                test[i][j]=list.itemAt(i,j);
            }
        MatrixCalculation mc = new MatrixCalculation();
        double Result = mc.CalculateMatrix(test);
        System.out.println("Determinate:");
        System.out.println(Result);




        Algorithm alg = new Algorithm(list);
        try{
            alg.calculate();
        }catch (NullPointerException|ArithmeticException  e){
            System.out.println(e.getMessage());
            System.exit(0);
        }


        Float []x = new Float[WIDTH];
        for(i = list.size() - 1; i >= 0; i--) {
            Float sum = 0.0f;
            int pos=0;
            for(j = list.size() - 1; j >=0; j--) {
                if(x[j]!=null)
                sum += list.itemAt(i, j) * x[j];
                if(list.itemAt(i, j)!=0.0f && x[j]==null) {
                    pos = j;
                }
            }
            x[pos] = (list.itemAt(i, list.size()) - sum) / list.itemAt(i, pos);
        }

        System.out.println("System:");
        printSystem(list);
        System.out.println("Vector:");
        printVector(x);
        System.out.println("AX-B:");
       for(i=0;i<WIDTH;i++)
       {
           Float sum=0.0f;
           for(j=0;j<WIDTH;j++) {
           sum+=copy.itemAt(i,j)*x[j];
           }
           sum-=copy.itemAt(i,WIDTH);
           System.out.print(String.format("%f; %s", sum, "\t"));
       }
        System.out.println("");
        System.out.println("Invertible matrix:");
        Algorithm alg2 = new Algorithm(list2);
        try{
            alg2.calculateInverse();
        }catch (NullPointerException|ArithmeticException  e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        printInvert(list2);

    }
}
