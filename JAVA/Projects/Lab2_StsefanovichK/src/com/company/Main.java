package com.company;
import java.lang.reflect.Array;
import java.math.*;
import java.util.*;
import java.util.Comparator;
public class Main {
    public static void printMatr(int [][]A)
    {
        for(int i=0;i<A.length;i++)
        {
            System.out.println(Arrays.toString((A[i])));
        }
    }
    public static int characteristic(int [][]A,int raw)
    {
        int answer=0;
        for(int i=1;i<A.length;i+=2)
        {
            if(A[i][raw]<0)
                answer-=A[i][raw];
        }
        return answer;
    }
    public static void printAllCharacteristic(int [][]A)
    {
        System.out.println("All Characteristics: ");
        for(int j=0;j<A.length;j++)
            System.out.print(characteristic(A,j)+" ");
        System.out.println("\n");
    }
    public static void printMatrVar2(int [][]A)
    {
        System.out.println("Full Matrix:");
        for(int i=0;i<A.length;i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.format("%7d",A[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void change(int [][]A)
    {
        for(int i=0;i<A.length;i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (characteristic(A, j) < characteristic(A, j + 1)) {
                    for (int k = 0; k < A.length; k++) {
                        int param = A[k][j];
                        A[k][j] = A[k][j + 1];
                        A[k][j + 1] = param;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        Random random=new Random();
        System.out.println("Type the number...");
        int size=in.nextInt();
        int [][] mas=new int[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
            {
                mas[i][j]=random.nextInt(201)-100;
            }
        System.out.println(Arrays.deepToString((mas)));
        printMatrVar2(mas);
        printAllCharacteristic(mas);
        change(mas);
        printMatrVar2(mas);
        printAllCharacteristic(mas);
        int [] another_mas=mas[5];
        System.out.println(Arrays.toString((another_mas)));
        Integer[] ia = new Integer[mas[0].length];
        for(int i=0;i<mas[0].length;i++)
            ia[i]=mas[mas[0].length-1][i];
        Arrays.sort(ia,new IntComparator());
        for(int i=0;i<mas[0].length;i++)
            mas[mas[0].length-1][i]=ia[i];
        printMatrVar2(mas);
    }

}
