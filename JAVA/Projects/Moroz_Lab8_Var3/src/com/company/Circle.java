package com.company;
import java.io.*;
import java.util.*;
class Circle{
    private int N;
    private int M;
    private double x;
    private double y;
    private double r;
    private TreeMap<String,String> map;
    public Circle(String str) throws IOException{
        map=new TreeMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader(str)));
        N=sc.nextInt();
        M=sc.nextInt();
        x=sc.nextDouble();
        y=sc.nextDouble();
        r=sc.nextDouble();
    }
    public void solve()throws IOException{
        int n=0;
        for(int i=0;i<N+1;i++)
            for(int j=0;j<M+1;j++){
                if(Math.sqrt((x-i)*(x-i)+(y-j)*(y-j))<(r+0.01) &&
                        Math.sqrt((x-i-1)*(x-i-1)+(y-j)*(y-j))<(r+0.01)&&
                        Math.sqrt((x-i)*(x-i)+(y-j-1)*(y-j-1))<(r+0.01)&&
                        Math.sqrt((x-i-1)*(x-i-1)+(y-j-1)*(y-j-1))<(r+0.01)) {
                    n++;
                   map.put(((Double)(Math.sqrt((x - i - 0.5) * (x - i - 0.5) + (y - j - 0.5) * (y - j - 0.5)))).toString()+" "+n, "" + i + " " + j);
                }
            }
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
        for(Map.Entry e : map.entrySet()){
            bw2.append("Расстояние:"+e.getKey().toString().substring(0,e.getKey().toString().indexOf(' '))+" Клетка:"+ e.getValue()+System.getProperty("line.separator"));
        }
        bw2.close();
    }
}