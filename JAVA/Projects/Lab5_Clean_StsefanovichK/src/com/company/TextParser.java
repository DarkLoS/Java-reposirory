package com.company;
import java.io.*;
import java.util.*;
public class TextParser{
    private String file;
    public TextParser(String file)throws IOException{
        this.file=file;
    }
    public HashMap<String,String> parse()throws IOException{
        BufferedReader bn = new BufferedReader(new FileReader(file));
        HashMap<String,String> allWords=new HashMap<>();
        String line;int countParagraph=1;
        while ((line = bn.readLine()) != null) {
            HashMap<String,String> temp=parseParagraph(line);
            for (Map.Entry<String, String> entry : temp.entrySet()) {
                allWords.put(entry.getKey()+";"+countParagraph,countParagraph+" "+entry.getValue());
            }
            countParagraph++;
        }
        return allWords;
    }
    private HashMap<String,String> parseParagraph(String paragraph) {
        HashMap<String,String> stringsMap=new HashMap<>();
        String[] lines=paragraph.split("[!.?]+");
        for(int i=1;i<=lines.length;i++) {
            if(lines[i-1].equals("\'")){}
            else{
                HashMap<String,String> temp=parseString(lines[i-1]);
                for (Map.Entry<String, String> entry : temp.entrySet()) {
                stringsMap.put(entry.getKey()+";"+i,i+" "+entry.getValue());
                }
            }
        }
        return stringsMap;
    }
    private HashMap<String,String> parseString(String line){
        HashMap<String,String> wordsMap=new HashMap<>();
        String[] words=line.split("[ \"&'()*+,-:;]+");
        for(int i=1;i<=words.length;i++)
            if(!words[i-1].equals(""))
            wordsMap.put(words[i-1]+";"+i,String.valueOf(i));
        return wordsMap;
    }
}