package com.company;
import java.util.*;
public class Main {
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

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        Random random=new Random();
        System.out.println("Type the number...");
        int size=in.nextInt();
        int [][] mas=new int[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
            {
                mas[i][j]=random.nextInt(11)-5;
            }
        printMatrVar2(mas);
        int max=mas[0][0];
        int Max=Integer.MIN_VALUE;
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
            {
                if(mas[i][j]>=max)
                {
                    max=mas[i][j];
                    for(int i2=i+1;i2<size;i2++)
                        for(int j2=0;j2<size;j2++) {
                        if(mas[i2][j2]==max) Max=max;
                        }
                    for(int j2=j+1;j2<size;j2++) {
                        if (mas[i][j2] == max) Max = max;
                    }
                    max=Max;
                }
            }
            if(Max==Integer.MIN_VALUE)
                System.out.println("Search is over.Error!");
        else
            System.out.println(Max);
    }

}