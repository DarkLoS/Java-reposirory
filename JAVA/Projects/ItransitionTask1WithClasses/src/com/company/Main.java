package com.company;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Record r;
        if(args[0].equals("US"))
            r=new RegionUS(args[0],Double.parseDouble(args[2]));
        else if(args[0].equals("BY")||args[0].equals("RU"))
            r=new RegionByRu(args[0],Double.parseDouble(args[2]));
        else return;
        for(int i=0;i<Integer.parseInt(args[1]);i++){
            System.out.println(r.generare());
        }
    }
}
