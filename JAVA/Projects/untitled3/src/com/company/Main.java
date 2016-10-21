package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args)  throws IOException{
Chese s=new Chese(64);
        int i=0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        while(i<64*64*64-1)
        {
            i++;
            s.solve(0);
            s.move(bw);
        }
        System.out.println(s);
bw.append(s.toString());
        bw.close();
    }
}
class Chese{
    public int [][][]A;
    private final static int[][] moves = {{1,2,2},{1,2,-2},{1,-2,2},{1,-2,-2},{-1,2,2}, {-1,2,-2},{-1,-2,2},{-1,-2,-2},
                                          {2,1,2},{2,1,-2},{2,-1,2},{2,-1,-2},{-2,1,2}, {-2,1,-2},{-2,-1,2},{-2,-1,-2},
                                          {2,2,1},{2,2,-1},{2,-2,1},{2,-2,-1},{-2,2,1}, {-2,2,-1},{-2,-2,1},{-2,-2,-1}};
    public int x;
    public int y;
    public int z;
    Chese(int n) {
        A=new int[n][n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++)
                    A[i][j][k]=0;
        solve(-1);
        x=23;
        y=32;
        z=5;
    }
    public void solve(int index) {
        int indexx1;
        int indexx2;
        int indexy1;
        int indexy2;
        int indexz1;
        int indexz2;
        if(index==-1) {
            indexx1 = 0;
            indexx2=64;
            indexy1 = 0;
            indexy2=64;
            indexz1 = 0;
            indexz2=64;
        }
        else{
            indexx1 = x-3;
            indexx2=x+3;
            indexy1 = y-3;
            indexy2=y+3;
            indexz1 = z-3;
            indexz2=z+3;
            if(indexx1<0)
                indexx1=0;
            if(indexy1<0)
                indexy1=0;
            if(indexz1<0)
                indexz1=0;
            if(indexx2>64)
                indexx2=64;
            if(indexy2>64)
                indexy2=64;
            if(indexz2>64)
                indexz2=64;
        }

        for(int i=indexx1;i<indexx2;i++)
            for(int j=indexy1;j<indexy2;j++)
                for(int k=indexz1;k<indexz2;k++)
                {
                    if(A[i][j][k]!=-1) {
                        A[i][j][k] = 0;
                        if (i + 1 < 64 && j + 2 < 64 && k + 2 < 64 && A[i + 1][j + 2][k + 2] != -1) A[i][j][k]++;
                        if (i + 1 < 64 && j + 2 < 64 && k - 2 >= 0 && A[i + 1][j + 2][k - 2] != -1) A[i][j][k]++;
                        if (i + 1 < 64 && j - 2 >= 0 && k + 2 < 64 && A[i + 1][j - 2][k + 2] != -1) A[i][j][k]++;
                        if (i + 1 < 64 && j - 2 >= 0 && k - 2 >= 0 && A[i + 1][j - 2][k - 2] != -1) A[i][j][k]++;

                        if (i - 1 >= 0 && j + 2 < 64 && k + 2 < 64 && A[i - 1][j + 2][k + 2] != -1) A[i][j][k]++;
                        if (i - 1 >= 0 && j + 2 < 64 && k - 2 >= 0 && A[i - 1][j + 2][k - 2] != -1) A[i][j][k]++;
                        if (i - 1 >= 0 && j - 2 >= 0 && k + 2 < 64 && A[i - 1][j - 2][k + 2] != -1) A[i][j][k]++;
                        if (i - 1 >= 0 && j - 2 >= 0 && k - 2 >= 0 && A[i - 1][j - 2][k - 2] != -1) A[i][j][k]++;

                        if (i + 2 < 64 && j + 1 < 64 && k + 2 < 64 && A[i + 2][j + 1][k + 2] != -1) A[i][j][k]++;
                        if (i + 2 < 64 && j + 1 < 64 && k - 2 >= 0 && A[i + 2][j + 1][k - 2] != -1) A[i][j][k]++;
                        if (i + 2 < 64 && j - 1 >= 0 && k + 2 < 64 && A[i + 2][j - 1][k + 2] != -1) A[i][j][k]++;
                        if (i + 2 < 64 && j - 1 >= 0 && k - 2 >= 0 && A[i + 2][j - 1][k - 2] != -1) A[i][j][k]++;

                        if (i - 2 >= 0 && j + 1 < 64 && k + 2 < 64 && A[i - 2][j + 1][k + 2] != -1) A[i][j][k]++;
                        if (i - 2 >= 0 && j + 1 < 64 && k - 2 >= 0 && A[i - 2][j + 1][k - 2] != -1) A[i][j][k]++;
                        if (i - 2 >= 0 && j - 1 >= 0 && k + 2 < 64 && A[i - 2][j - 1][k + 2] != -1) A[i][j][k]++;
                        if (i - 2 >= 0 && j - 1 >= 0 && k - 2 >= 0 && A[i - 2][j - 1][k - 2] != -1) A[i][j][k]++;

                        if (i + 2 < 64 && j + 2 < 64 && k + 1 < 64 && A[i + 2][j + 2][k + 1] != -1) A[i][j][k]++;
                        if (i + 2 < 64 && j + 2 < 64 && k - 1 >= 0 && A[i + 2][j + 2][k - 1] != -1) A[i][j][k]++;
                        if (i + 2 < 64 && j - 2 >= 0 && k + 1 < 64 && A[i + 2][j - 2][k + 1] != -1) A[i][j][k]++;
                        if (i + 2 < 64 && j - 2 >= 0 && k - 1 >= 0 && A[i + 2][j - 2][k - 1] != -1) A[i][j][k]++;

                        if (i - 2 >= 0 && j + 2 < 64 && k + 1 < 64 && A[i - 2][j + 2][k + 1] != -1) A[i][j][k]++;
                        if (i - 2 >= 0 && j + 2 < 64 && k - 1 >= 0 && A[i - 2][j + 2][k - 1] != -1) A[i][j][k]++;
                        if (i - 2 >= 0 && j - 2 >= 0 && k + 1 < 64 && A[i - 2][j - 2][k + 1] != -1) A[i][j][k]++;
                        if (i - 2 >= 0 && j - 2 >= 0 && k - 1 >= 0 && A[i - 2][j - 2][k - 1] != -1) A[i][j][k]++;
                    }
                }
    }
    public void move(BufferedWriter bw) throws IOException {
        int i=x;
        int j=y;
        int k=z;
        A[i][j][k]=-1;
        int min=1000;
        int index=-1;
        for(int l=0;l<24;l++)
        {
            if((i+moves[l][0])<64&&(i+moves[l][0])>=0&&(j+moves[l][1])<64&&(j+moves[l][1])>=0&&(k+moves[l][2])<64&&(k+moves[l][2])>=0)
            if(min>=A[i+moves[l][0]][j+moves[l][1]][k+moves[l][2]]&&A[i+moves[l][0]][j+moves[l][1]][k+moves[l][2]]!=-1&&A[i+moves[l][0]][j+moves[l][1]][k+moves[l][2]]!=0)
            {
                Random random = new Random();
                int r=0;
                if(min==A[i+moves[l][0]][j+moves[l][1]][k+moves[l][2]])
                {
                    r=random.nextInt(50);
                    if(r%2==0)
                    {
                        min=A[i+moves[l][0]][j+moves[l][1]][k+moves[l][2]];
                    }
                }
                else
                {
                    min = A[i + moves[l][0]][j + moves[l][1]][k + moves[l][2]];
                    index = l;
                }
            }
        }
        if(index==-1)
            System.out.println("!!!!!!");
        x+=moves[index][0];
        y+=moves[index][1];
        z+=moves[index][2];
        bw.append(index+" ");

    }

    @Override
    public String toString() {
        return Arrays.deepToString(A);
    }
}