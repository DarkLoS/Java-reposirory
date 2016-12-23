package com.company;
import java.io.*;
public class ChangeFile{
    public void change(String file,int number,String string)throws IOException{
        RandomAccessFile fin =new  RandomAccessFile(file,"rw");
        fin.seek(number);
        fin.write(string.getBytes());
    }
}