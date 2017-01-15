package com.company;
import java.lang.*;
import java.io.*;
import java.util.*;
public class LargeText{
    private List<PieceOfText> text;
    public LargeText(String file)throws IOException{
        text=new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        text.add(new PieceOfText());
        int check=0;
        while ((line = br.readLine()) != null) {
            if(check==0) {
                if (checkOperation(line)) {
                    text.get(text.size() - 1).addOperation(line);
                    check=1;
                }
                else text.get(text.size() - 1).addLine(line);
            }
            else{
                if (checkOperation(line)) {
                    text.get(text.size() - 1).addOperation(line);
                }
                else {
                    text.get(text.size() - 1).addLine(line);
                    text.add(new PieceOfText());
                    check=0;
                }
            }
        }
    }
    private boolean checkOperation(String line){
        return line.matches("((R )|(S ))(\\d)+( )(\\d)+( )(\\d)+");
    }
    public void printAllText(String file)throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(PieceOfText t:text){
            for(int i=0;i<t.getNumberOfLines();i++)
                bw.append(t.getLine(i)+System.getProperty("line.separator"));
        }
        bw.close();
    }
    public void printAllOperations(String file)throws IOException{
        ArrayList<SliceOperation> list=new ArrayList<>();
        for(PieceOfText t:text){
            for(int i=0;i<t.getNumberOfOperations();i++)
                list.add(t.getOperation(i));
        }
        Runnable r = new MyThread(list,file);
        new Thread(r).start();
    }
    public void makeTask(String file)throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(PieceOfText t:text){
            for(int i=0;i<t.getNumberOfOperations();i++){
                SliceOperation s=t.getOperation(i);
                String line=t.getLine(s.getNumberOfLine());
                if(s.getOperand()=='R')
                    line=line.substring(0,s.getBeginLine())+new StringBuilder(line.substring(s.getBeginLine(),s.getEndLine()+1)).reverse().toString()+line.substring(s.getEndLine()+1);
                if(s.getOperand()=='S') {
                    char[] chars=(line.substring(s.getBeginLine(),s.getEndLine()+1)).toCharArray();
                    Arrays.sort(chars);
                    line = line.substring(0, s.getBeginLine())+new String(chars)+ line.substring(s.getEndLine() + 1);
                }
                t.setLine(line,s.getNumberOfLine());
                bw.append(line+System.getProperty("line.separator"));
            }
        }
        bw.close();
    }
}