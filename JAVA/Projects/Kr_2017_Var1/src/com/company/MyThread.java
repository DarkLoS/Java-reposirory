package com.company;
import java.io.*;
import java.lang.*;
import java.util.*;
public class MyThread implements Runnable {
    private ArrayList<SliceOperation> list;
    private BufferedWriter bw;
    public MyThread(ArrayList<SliceOperation> list,String file) throws IOException {
        bw = new BufferedWriter(new FileWriter(file));
        this.list=new ArrayList<>();
        this.list=list;
    }
    public void run() {
        try {
            Collections.sort(list, new OperationComparator());
            for (SliceOperation s : list) {
                bw.append(s + System.getProperty("line.separator"));
            }
            bw.close();
        }
         catch(IOException ex){}
    }
}