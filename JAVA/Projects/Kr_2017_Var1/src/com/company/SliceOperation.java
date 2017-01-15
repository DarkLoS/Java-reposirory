package com.company;
import java.lang.*;
public class SliceOperation{
    private char operand;
    private int numberOfLine;
    private int beginLine;
    private  int endLine;
    public SliceOperation(String string){
        String[] arr=string.split(" ");
        operand=(char)arr[0].charAt(0);
        numberOfLine=Integer.parseInt(arr[1]);
        beginLine=Integer.parseInt(arr[2]);
        endLine=Integer.parseInt(arr[3]);
    }
    @Override
    public String toString() {
        return operand+" "+numberOfLine+" "+beginLine+" "+endLine;
    }
    public char getOperand(){
        return  operand;
    }
    public int getNumberOfLine(){
        return  numberOfLine;
    }
    public int getBeginLine(){
        return  beginLine;
    }
    public int getEndLine(){
        return  endLine;
    }
}