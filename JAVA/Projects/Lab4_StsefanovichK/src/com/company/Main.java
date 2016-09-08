package com.company;
import java.util.Arrays;
import java.util.regex.*;
import java.io.*;
import java.util.*;
public class Main {
    public static final Pattern pattern = Pattern.compile
            ("(г. )[А-Я]{1}[а-яА-Я]+((, ул. )|(, пр. )|(, пер. ))[А-Я]{1}[а-яА-Я]+(, д.)[\\d]{1,3}(, кв.)?[\\d]{0,3}");

    public static String doMatch(String word) {
        Matcher matcher = pattern.matcher(word);
       return "Validation for " + word +
                (matcher.matches() ? " passed." : " not passed.");
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt"), "Cp1251"));
            BufferedReader bn = new BufferedReader(new FileReader("readme.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            String line;
            System.out.println(bn.readLine());
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.flush();
                bw.append(doMatch(line)+System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
        System.out.println("Type the Pattern");
        Pattern p = null;
        try {
            p = Pattern.compile(in.nextLine());
            System.out.println("Pattern created: "+p.pattern());
        } catch (PatternSyntaxException ex) {
            System.out.println("This string could not compile: "+ex.getPattern());
            System.out.println(ex.getMessage());
        }

    }
}
