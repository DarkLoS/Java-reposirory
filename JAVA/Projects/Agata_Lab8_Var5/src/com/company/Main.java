package com.company;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Cars car=new Cars("in.txt");
        car.solve();
        car.printOvertake();
    }
}
