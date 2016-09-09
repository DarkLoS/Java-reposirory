package com.company;
import java.math.*;
import java.util.*;
public class Main {
//loool 45,this is()so    56 noon,moon equals aa bbbb grerg ghg 45t 54 55
    public static void quickSearch(String S,String P)
    {
        int t1=-1;
        int ex=0;
        int i=P.length()-1;
        int j=P.length()-1;
        int t=0;
        while(i<S.length())
        {
            char q;
            if(i==S.length()-1){q=S.charAt(i);t1=0;}
            else q=S.charAt(i+1);
            int k=0;
            if(S.charAt(i)==P.charAt(j))
            {
                while(S.charAt(i)==P.charAt(j))
                {
                    i-=1;
                    j-=1;
                    k+=1;
                    if(k==P.length()) {
                        System.out.println("Found at place "+i);
                        ex=1;
                        t1=0;
                        return;

                    }
                }
            }
            if(t1==0)
            {System.out.println("Not Found(");
            return;}
            if(P.lastIndexOf(String.valueOf(q))==-1)
            {
                t=P.length()-1;
            }
            else
            {
                t=P.length()-1-P.lastIndexOf(String.valueOf(q));
            }
            i=i+k+t+1;
            j=P.length()-1;
        }
        System.out.println("Not Found(");
    }
    public static void main(String[] args) {
        quickSearch("adf56hj75aaaafgfggahj76aaaaaaaa","hj76");
        Scanner in =new Scanner(System.in);
        System.out.println("Type the string");
        String str=in.nextLine();
        System.out.println("Type the separators");
        String buf=in.nextLine();
        char[] array =buf.toCharArray();
        Arrays.sort(array);
        buf=new String(array);
        System.out.println("Type the number for search");
        int p=in.nextInt();
        String[] parts=str.split("["+buf+"]+");
        System.out.println(Arrays.toString(parts));
        List<Integer> numbers = new ArrayList();
        List<String> strings = new ArrayList();
        int valueNumbers=0;
        int valueStrings=0;
        for(int i=0;i<parts.length;i++)
        {
            if(parts[i].matches("[-+]?\\d+")) {
                numbers.add(Integer.parseInt(parts[i]));
                valueNumbers++;
            }
            else {
                strings.add(parts[i]);
                valueStrings++;
            }
        }
        System.out.println(Arrays.toString(numbers.toArray()));
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println("Palindroms:");
        for(int i=0;i<strings.size();i++)
        {
            if(strings.get(i).equals(new StringBuilder(strings.get(i)).reverse().toString()))
            {
                System.out.println(strings.get(i));
            }
        }
        int value=0;
        int v=Integer.MIN_VALUE;
        for( int x:numbers) {
            if(x==p) {System.out.println("Find value P!"); value++;}
        if(x<p)v=x;}
        if(value==0)System.out.println("Not find value P!");
        StringBuffer secondBuffer = new StringBuffer(str);
        secondBuffer.insert(0,Integer.toString(p*(-1)));
        System.out.println(secondBuffer);
        if(v==Integer.MIN_VALUE) {
            System.out.println("Not find value less than P");
        }
        else {
            int index = secondBuffer.lastIndexOf(Integer.toString(v));
            secondBuffer.delete(index, index + (Integer.toString(v).length()));
            System.out.println(secondBuffer);
        }
        int x=0;
        do
        {
            System.out.println("Choose the operation");
            System.out.println("1. getChars");
            System.out.println("2. substring");
            System.out.println("3. replace");
            System.out.println("4. indexOf");
            System.out.println("5. lastIndexOf");
            System.out.println("0. Otmena");
            System.out.println("");
            System.out.println("String:  "+str);
            System.out.println("");
            System.out.println("\nNumber of operation > ");
            x=in.nextInt();
            switch (x)
            {
                case 1:
                    System.out.println("Type 2 values");
                    int bound1=in.nextInt();
                    int bound2=in.nextInt();
                    char[] massiv = new char[bound1+bound2];
                    str.getChars(bound1,bound2,massiv,0);
                    System.out.println("Array "+Arrays.toString(massiv));
                break;
                case 2:
                    System.out.println("Type 1 values");
                    int bound=in.nextInt();
                    String param=str.substring(bound);
                    System.out.println(param);
                break;
                case 3:
                    System.out.println("Type 2 times!");
                    String replace=in.nextLine();
                    replace=in.nextLine();
                    String input=in.nextLine();
                    String replaceStr =str.replace(replace,input);
                    System.out.println(replaceStr);
                break;
                case 4:
                    System.out.println("Type...");
                    String value1=in.nextLine();
                    value1=in.nextLine();
                    int index = str.indexOf(value1);
                    System.out.println("Index: "+index);
                break;
                case 5:
                    System.out.println("Type...");

                    String value2=in.nextLine();
                    value2=in.nextLine();
                    int index2 = str.lastIndexOf(value2);
                    System.out.println("Index: "+index2);
                    break;
            }
        } while (x != 0);

    }
}
