package com.company;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        LargeText text=new LargeText("input.txt");
        text.printAllText("out.txt");
        text.printAllOperations("out2.txt");
        text.makeTask("out3.txt");
    }
}