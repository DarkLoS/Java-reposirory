package com.company;
import java.util.*;
public class Main {
//loool 45,this is()so    56 noon,moon equals aa bbbb grerg ghg 45t 54 55
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Type the string");
        String str=in.nextLine();
        System.out.println("Type the separators");
        String buf=in.nextLine();
        char[] array =buf.toCharArray();
        Arrays.sort(array);
        buf=new String(array);
        String[] parts=str.split("["+buf+"]+");
        System.out.println(Arrays.toString(parts));
        List<Integer> numbers = new ArrayList();
        List<String> strings = new ArrayList();
        for(int i=0;i<parts.length;i++) {
            if(parts[i].matches("[-+]?\\d+")) numbers.add(Integer.parseInt(parts[i]));
            else strings.add(parts[i]);
        }
        Collections.sort(numbers);
        Collections.sort(strings);
        System.out.println(Arrays.toString(numbers.toArray()));
        for(String s:strings)
            System.out.println(s);
    }
}
