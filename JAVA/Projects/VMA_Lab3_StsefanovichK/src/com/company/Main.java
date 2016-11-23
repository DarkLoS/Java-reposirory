package com.company;
import java.util.Arrays;
public class Main {
    static  Double[][] mas=new Double[][]
            {{0.7277,-0.0958,0.0192, 0.0383,0.1341},
                    {0.0996, 1.1394,0.0000,-0.0766,0.0766},
                    {0.0575, 0.0000,0.9154,-0.2681,0.1532},
                    {-0.1149,0.2413,0.0000,0.9001,-0.0383},
                    {0.4788,0.0000,0.1724,0.0192,1.0724}};
    static  Double[][] matrB=new Double[][]
            {{1.4363}, {-1.6431}, {6.0514}, {-3.4508}, {5.5727}};
    public static void printMatrix(Double[][] x){
        for (int i = 0; i < x.length; i++){
            String s = "";
            for (int j = 0; j < x[i].length; j++){
                s += String.format("%.4f; %s", x[i][j], "\t");
            }
            System.out.println(s);
        }System.out.println("");
    }
    public static void printAB(Double[][] x,Double[][] y){
        for (int i = 0; i < x.length; i++){
            String s = "";
            for (int j = 0; j < x[i].length; j++){
                s += String.format("%.4f; %s", x[i][j], "\t");
            }
            s += String.format("%.4f; %s", y[i][0], "\t");
            System.out.println(s);
        }System.out.println("");
    }
    public static  void Normal(Double[][] a,Double[][] b) {
       for(int i=0;i<a.length;i++) {
           for(int j=0;j<a[i].length;j++) {
               if(i==j){}
               else{
                   a[i][j]=-a[i][j]/a[i][i];
               }
           }
           b[i][0]=b[i][0]/a[i][i];
           a[i][i]=0.0;
       }
    }
    public static Double[] Iteration(Double[][] a,Double[][] b,Double e) {
        Double []M=new Double[a.length];
        Double []P=new Double[a.length];
        for(int i=0;i<a.length;i++)
            M[i]=b[i][0];
        int index=0;
        int sum;
        while(true) {
            sum=0;
            for(int i=0;i<a.length;i++) {
                double x=0.0;
                for(int j=0;j<a[i].length;j++) {
                    x+=a[i][j]*M[j];
                }
                x+=b[i][0];
                if(Math.abs(x-M[i])<=e)
                sum++;
                P[i]=x;
            }
          index++;
            if(sum==5)
                break;
            for(int i=0;i<a.length;i++)
                M[i]=P[i];
        }
        System.out.println("Количество итераций="+index);

        return M;
    }
    public static void main(String args[]){
        System.out.println("Matrix:");
        printAB(mas,matrB);
        Normal(mas,matrB);
        System.out.println("B:");
        printAB(mas,matrB);
        System.out.println(Arrays.toString(Iteration(mas,matrB,0.0001)));
    }
}