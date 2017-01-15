package com.company;
import java.lang.*;
import java.util.*;
public class PieceOfText{
    private List<String> listOfLines;
    private List<SliceOperation> listOfOperations;
    public PieceOfText(){
        listOfLines=new ArrayList<>();
        listOfOperations=new ArrayList<>();
    }
    public void addLine(String string){
        listOfLines.add(string);
    }
    public void addOperation(String string){
        listOfOperations.add(new SliceOperation(string));
    }
    public String getLine(int i){
        return listOfLines.get(i);
    }
    public void setLine(String line,int pos){
        listOfLines.set(pos,line);
    }
    public int getNumberOfLines(){
        return  listOfLines.size();
    }
    public SliceOperation getOperation(int i){
        return listOfOperations.get(i);
    }
    public int getNumberOfOperations(){
        return listOfOperations.size();
    }
}