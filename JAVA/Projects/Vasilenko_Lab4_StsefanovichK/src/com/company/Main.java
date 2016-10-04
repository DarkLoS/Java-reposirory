package com.company;
import java.io.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws IOException{
        DeleteComments deleteComments=new DeleteComments("in.txt");
        deleteComments.calculate("out.txt");
    }
}
